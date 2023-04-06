<template>
    <div>
        <div class="calendar-header">{{ year }}-{{ month+1 }}-{{ text }}</div>
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
            <div v-for="(cellData, cellIndex) in rowData" :key="cellIndex" class="calendar-row-data">
                {{ cellData }}
            </div>
        </div>
    </div>
</template>

<script>
export default {
    
    data() {
        return {
            text: 1,
        }
    },
    computed: {
        calendar() {
            return this.$store.state.calendar;
        },
        year() {
            return this.$store.state.year;
        },
        month() {
            return this.$store.state.month;
        },
    },
    methods: {
        change() {
            this.text++;
        }
    }
    
}
</script>

<style>

.calendar-header {
    text-align: center;
    font-size: 50px;
}

.calendar-column {
    display: flex;
    justify-content: space-between;
    border: 1px solid black;
    width: 90vw;
    margin-left: auto;
    margin-right: auto;
}

.calendar-column-text {
    border: 1px solid red;
    width: 100%;
    text-align: center;
}

.calendar-row {
    display: flex;
    justify-content: space-between;
    margin-left: auto;
    margin-right: auto;
    /* border: 1px solid blue; */
    width: 90vw;
    height: 100px;
}

.calendar-row-data {
    border: 1px solid green;
    width: 100%;
}
    
</style>