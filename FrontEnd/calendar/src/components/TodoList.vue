<template>
    <div>
        <ul v-if="scheduleDetail.length > 0">
            <li v-for="detail in scheduleDetail" :key="detail.id">
                {{ detail.title }}
            </li>
        </ul>    
        <p v-else class="empty-schedule-detail">아직 등록된 일정이 없습니다</p>
    </div>
</template>
<script>
export default {

    computed: {
        scheduleDetail() {
            return this.$store.state.scheduleDetail;
        }
    },

    
}
</script>
<style scoped>

.empty-schedule-detail {
    text-align: center;
    width: 100%;
    margin-top: 30%;
    font-weight: 600;
}

    
</style>