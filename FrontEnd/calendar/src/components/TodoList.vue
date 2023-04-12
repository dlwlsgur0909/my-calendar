<template>
    <div>
        <ul>
            <li v-for="detail in scheduleDetail" :key="detail.id">
                {{ detail.title }}
            </li>
        </ul>    
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
<style>
    
</style>