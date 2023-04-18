<template>
    <div class="header">
        <div v-if="loginStatus" class="after-login-header">
            <router-link to="/index">INDEX</router-link>   
            <router-link to="/users">PROFILE</router-link> 
            <router-link to="/logout">LOGOUT</router-link>
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

<style scoped>
.header {
    box-sizing: border-box;
    height: 10vh;
    display: flex;
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

.after-login-header {
    width: 30%;
    margin-left: auto;
    margin-right: auto;
    display: flex;
    justify-content: space-between;
}

a {
    text-decoration: none;
    color: #fff;
    font-weight: 900;
    font-size: 1.5rem;
    margin-right: 5%;
}

a:hover {
    color: #00000085;
}
    
</style>