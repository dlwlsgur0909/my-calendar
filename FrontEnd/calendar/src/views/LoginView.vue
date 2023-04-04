<template>
    <div class="login-form">
        <h2>Welcome to My Calendar</h2>
        <div class="login-input">
            <div id="login-username">
                Username: 
                <input type="text" placeholder="아이디" size="15" v-model="this.username">
            </div>
            <div id="login-password">
                Password:
                <input type="password" placeholder="비밀번호" size="17" v-model="this.password">
            </div>
            <div>
                <button id="login-button" @click="onClickLogin">로그인</button>
            </div>
            <div class="login-form-buttons">
                <router-link to="/signup"><span id="join-button">회원가입</span></router-link> 
                <!-- | <span id="find-id-pw-button">아이디/비밀번호 찾기</span> -->
            </div>
        </div>
    </div>
</template>
<script>

import { fetchLogin } from '../api/api.js';


export default {
    


    data() {
        return {
            username: '',
            password: '',
        }
    },
    methods: {
        onClickLogin() {
            if(this.username.trim() === '' || this.password.trim() === '') {
                alert("아이디와 비밀번호를 다시 확인해주세요")
                return;
            }


            const user = {
                userUsername: this.username,
                userPassword: this.password,
            };


            // 로그인 fetch
            fetchLogin(user)
            .then(res => res.json())
            .then(res => {
                if(res.errorMessage) {
                    alert(res.errorMessage);
                    return;
                }else {
                    console.log(res);
                    window.sessionStorage.setItem('username', res.userUsername);
                    window.sessionStorage.setItem('userName', res.userName);
                    window.sessionStorage.setItem('regdate', res.userRegdate);

                    window.location.href = '/index';
                }

                
            })
        }
    }
    
}
</script>
<style scoped>

input {
    border: none;
    border-radius: 5px;
}
.login-form {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    margin-left: auto;
    margin-right: auto;
    margin-top: 10vh;
    width: 30vw;
    height: 50vh;
    border: 1px solid black;
    border-radius: 10px;
    background: rgb(54, 230, 157);
}

.login-form h2 {
    text-align: center;
    width: 100%;
}

.login-input {
    width: 250px;
    height: 40%;
}

#login-username,
#login-password {
    /* display: flex; */
    /* justify-content: space-between; */
    width: 100%;
    height: 18%;
    background: white;
    padding-left: 5px;
    border-radius: 5px;
    line-height: 200%;
}

#login-username input,
#login-password input {
    margin-left: 15px;
    text-align: center;
}

#login-username input::placeholder,
#login-password input::placeholder {
    text-align: center;
    color: rgb(252, 110, 110);
}

#login-password {
    margin-top: 10%;
}

#login-button {
    width: 100%;
    height: 25px;
    margin-top: 20px;
    margin-bottom: 20px;
    background: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

#login-button:hover {
    font-weight: 800;
}

.login-form-buttons {
    font-size: 14px;
    color: #333;
    text-align: center;
}

#join-button,
#find-id-pw-button {
    cursor: pointer;
}

#join-button:hover,
#find-id-pw-button:hover {
    color: #747373;
}


</style>