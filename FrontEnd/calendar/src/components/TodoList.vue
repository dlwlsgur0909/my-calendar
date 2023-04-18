<template>
    <div>
        <div v-if="scheduleDetail.length > 0">
            <div class="detail-list" v-for="detail in scheduleDetail" :key="detail.id">
                <input type="text" class="detail-title" v-model="detail.title">
                <input type="checkbox" class="detail-done" v-if="detail.done === 'T'" @click="onClickDone(detail.done, detail.id)" checked="true">
                <input type="checkbox" class="detail-not-done" v-else @click="onClickDone(detail.done, detail.id)">
                <span class="detail-delete-button" @click="onClickDeleteButton(detail.id)">⛔</span>
                <span class="detail-update-button" @click="onClickUpdateButton(detail.id, detail.title)">🔄️</span>
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
            };

            this.$store.dispatch('CHANGE_DONE', data);
        },
        onClickDeleteButton(id) {

            const data = {
                id: id,
                currentYear: this.$store.state.year,
                currentMonth: this.$store.state.month,
            };

            this.$store.dispatch('DETAIL_DELETE', data);

        },
        onClickUpdateButton(id, title) {
            const data = {
                id: id,
                title: title,
                currentYear: this.$store.state.year,
                currentMonth: this.$store.state.month,
            };

            this.$store.dispatch('DETAIL_UPDATE', data);

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

.detail-title {
    width: 70%;
}

.detail-done {
    position: absolute;
    right: 4%;
    margin-top: -0.5%;
    font-size: 1.2rem;
    cursor: pointer;
    width: 5%;
    height: 5%;
}

.detail-not-done {
    position: absolute;
    right: 4%;
    margin-top: -0.5%;
    font-size: 1.2rem;
    cursor: pointer;
    width: 5%;
    height: 5%;
}

.detail-delete-button {
    position: absolute;
    right: 12%;
    margin-top: -0.5%;
    font-size: 1.2rem;
    cursor: pointer;
}

.detail-update-button {
    position: absolute;
    right: 20%;
    margin-top: -0.5%;
    font-size: 1.2rem;
    cursor: pointer;
}

    
</style>