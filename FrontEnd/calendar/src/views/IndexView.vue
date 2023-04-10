<template>
    <div>
        <div class="calendar-header">
            <button class="today-button" @click="onClickToday">TODAY</button>
            <span class="prev-month" @click="onClickPrevMonth">&leftarrow;</span>
            {{ currentYear }} {{ currentMonth+1 }}
            <span class="next-month" @click="onClickNextMonth">&rightarrow;</span>
        </div>
        <div class="calendar-column" @click="change">
            <div class="calendar-column-text">일</div>
            <div class="calendar-column-text">월</div>
            <div class="calendar-column-text">화</div>
            <div class="calendar-column-text">수</div>
            <div class="calendar-column-text">목</div>
            <div class="calendar-column-text">금</div>
            <div class="calendar-column-text">토</div>
        </div>
        <div v-for="(rowData, rowIndex) in calendar" class="calendar-row" :key="rowIndex">
            <div v-for="(data, cellIndex) in rowData" :key="cellIndex" class="calendar-row-data">
                <div class="calendar-date" @click="onClickDate(data)">
                    <div v-if="data.isCurrent" class="current-month">{{ data.date }}</div>
                    <div v-else class="not-current-month">{{ data.date }}</div>
                </div>
            </div>
        </div>
        <div id="block" @click="onClickBlock"></div>
        <todo-modal 
            id="todo-modal" 
            :selectedDate = "selectedDate"
            :selectedMonth = "selectedMonth"
            :selectedYear = "selectedYear"
        >
        </todo-modal>
    </div>
</template>

<script>
/* esling-disabled */

import TodoModal from '../components/TodoModal.vue';




export default {
    components: {
        TodoModal
    },
    data() {
        return {
            currentYear: this.$store.state.year,
            currentMonth: this.$store.state.month,
            selectedYear: '',
            selectedMonth: '',
            selectedDate: '',            
        }
    },
    computed: {
        calendar() {
            return this.$store.state.calendar;
        },
    },
    methods: {
        onClickPrevMonth() {

            if(this.currentMonth === 0) {
                this.currentMonth = 11;
                this.$store.dispatch('CHANGE_YEAR', this.currentYear--);
            }else {
                this.currentMonth--;
            }

            this.$store.dispatch('CHANGE_MONTH', this.currentMonth);

            const dateInfo = {
                year: this.currentYear,
                month: this.currentMonth
            };

            this.$store.dispatch('CREATE_CALENDAR', dateInfo);
        },
        onClickNextMonth() {

            if(this.currentMonth === 11) {
                this.currentMonth = 0;
                this.$store.dispatch('CHANGE_YEAR', this.currentYear++);
            }else {
                this.currentMonth++;
            }

            this.$store.dispatch('CHANGE_MONTH', this.currentMonth);

            const dateInfo = {
                year: this.currentYear,
                month: this.currentMonth
            };

            this.$store.dispatch('CREATE_CALENDAR', dateInfo);
        },
        onClickToday() {
            const thisYear = new Date().getFullYear();
            const thisMonth = new Date().getMonth();

            this.currentYear = thisYear;
            this.$store.dispatch('CHANGE_YEAR', thisYear);
            this.currentMonth = thisMonth;
            this.$store.dispatch('CHANGE_MONTH', thisMonth);

            const dateInfo =  {
                year: thisYear,
                month: thisMonth
            }
            this.$store.dispatch('CREATE_CALENDAR', dateInfo);
        },
        onClickDate(data) {
            this.selectedYear = data.year;
            this.selectedMonth = data.month;
            this.selectedDate = data.date;
            const block = document.querySelector('#block');
            const todoModal = document.querySelector('#todo-modal');
            block.style.display = 'block';
            todoModal.style.display = 'block';
        },
        onClickBlock() {
            const block = document.querySelector('#block');
            const todoModal = document.querySelector('#todo-modal');
            block.style.display = 'none';
            todoModal.style.display = 'none';
        }
    }
    
}
</script>

<style>

#block {
    display: none;
    position: absolute;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    background: rgba(0, 0, 0, 0.178);
}

#todo-modal {
    display: none;
}

.calendar-header {
    text-align: center;
    font-size: 50px;
    height: 10vh;
}

.today-button {
    position: relative;
    padding: 5px 10px;
    left: -3%;
    top: -10%;
    background: rgb(54, 230, 157);
    border: none;
    border-radius: 5px;
    color: #333;
    font-weight: 600;
}

.today-button:hover {
    color: #ffffff;
}

.prev-month:hover,
.next-month:hover {
    cursor: pointer;
    color: rgb(54, 230, 157);
}


.calendar-column {
    display: flex;
    justify-content: space-between;
    width: 90vw;
    border: 1px solid black;
    margin-left: auto;
    margin-right: auto;
}

.calendar-column-text {
    border: 1px solid black;
    width: 100%;
    text-align: center;
}

.calendar-row {
    display: flex;
    justify-content: space-between;
    margin-left: auto;
    margin-right: auto;
    width: 90vw;
    height: 100px;
}

.calendar-row-data {
    border: 1px solid black;
    width: 100%;
}

.calendar-date {
    height: 100%;
}

.current-month {
    font-size: 1.2em;
}

.not-current-month {
    color: #00000052;
    font-size: 1.2em;
}
    
</style>