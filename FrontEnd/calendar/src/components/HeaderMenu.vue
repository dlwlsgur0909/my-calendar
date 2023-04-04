<template>
    <div class="header">
        <div v-if="loginStatus">
            <router-link to="/index">Index</router-link> |  
            <router-link to="/users">My Profile</router-link>
        </div>
        <div class="before-login-header" v-else>
            <h1 @click="onClickLogo">Welcom to My Calendar</h1>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        loginStatus: {
            type: Boolean,
            required: true,
        },
    },
    methods: {
        onClickLogo() {
            window.location.href = '/login';
        }
    }
    
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
    background: rgb(54, 230, 157);
}

.before-login-header {
    color: rgb(255, 255, 255);
    cursor: pointer;
}

.before-login-header:hover {
    color: rgba(255, 255, 255, 0.74);
}
    
</style>