<template>
    <div class="header">
        <router-link to="/index">Index</router-link> |  
        <router-link to="/users">My Profile</router-link>
    </div>
</template>

<script>
export default {
    
}
</script>

<style scopde>
.header {
    box-sizing: border-box;
    height: 10vh;
    display: flex;
    border: 1px solid black;
    justify-content: center;
    align-items: center;
}
    
</style>