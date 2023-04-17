<template>
    <div>
        <div v-if="scheduleDetail.length > 0">
            <div class="detail-list" v-for="detail in scheduleDetail" :key="detail.id">
                <span>{{ detail.title }}</span>
                <div class="detail-done" v-if="detail.done === 'T'" @click="onClickDone(detail.done, detail.id)"></div>
                <div class="detail-not-done" v-else @click="onClickDone(detail.done, detail.id)"></div>
            </div>
        </div>    
        <p v-else class="empty-schedule-detail">아직 등록된 일정이 없습니다</p>
    </div>
</template>
<script>
export default {
    props: {
        selectedYear: {
        type: Number,
        required: true
        },
        selectedMonth: {
        type: Number,
        required: true
        },
        selectedDate: {
        type: Number,
        required: true
        },
    },
    computed: {
        scheduleDetail() {
            return this.$store.state.scheduleDetail;
        }
    },
    methods: {
        onClickDone(done, id) {

            if(done === 'T') {
                done = 'F';    
            }else if(done === 'F') {
                done = 'T';
            }

            
            const data = {
                id: id,
                done: done,
                year: this.selectedYear,
                month: this.selectedMonth,
                date: this.selectedDate,
            };

            this.$store.dispatch('CHANGE_DONE', data);
            

        }



    }

    
}
</script>
<style scoped>

.empty-schedule-detail {
    text-align: center;
    width: 100%;
    margin-top: 30%;
    font-weight: 600;
}

.detail-list {
    width: 90%;
    margin-top: 5%;
    margin-left: auto;
    margin-right: auto;
}

.detail-done {
    display: inline-block;
    position: absolute;
    right: 6%;
    background: rgb(54, 230, 157);
    width: 25px;
    height: 25px;
    border-radius: 15px;
    cursor: pointer;
}

.detail-not-done {
    display: inline-block;
    position: absolute;
    right: 6%;
    background: rgba(173, 173, 173, 0.452);
    width: 25px;
    height: 25px;
    border-radius: 15px;
    cursor: pointer;
}


    
</style>