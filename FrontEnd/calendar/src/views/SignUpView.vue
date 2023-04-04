<template>
    <div class="signup-form">
        <h2>Welcome to My Calendar</h2>
        <div class="signup-input">
            <div id="signup-username">
                Username: 
                <input type="text" placeholder="아이디를 입력하세요" size="20" v-model="this.username">
            </div>
            <div id="signup-name">
                Name: 
                <input type="text" placeholder="이름을 입력하세요" size="20" v-model="this.name">
            </div>
            <div id="signup-password">
                Password:
                <input type="password" placeholder="비밀번호를 입력하세요" size="20" v-model="this.password">
            </div>
            <div id="signup-repassword">
                Re-Password:
                <input type="password" placeholder="비밀번호 확인" size="20" v-model="this.rePassword">
            </div>
            <div>
                <button id="signup-button" @click="onClickSignUp">회원가입</button>
            </div>
        </div>
    </div>
</template>
<script>

import { fetchSignUp } from '../api/api.js';

export default {
    data() {
        return {
            username: '',
            name: '',
            password: '',
            rePassword: '',
        };
    },
    methods: {
        onClickSignUp() {
            if(!this.username || !this.name || this.password.trim() === '' || this.rePassword.trim() === '') {
                alert("가입 정보를 다시 확인해주세요");
                return;
            }

            if(this.password !== this.rePassword) {
                alert("비밀번호가 일치하지 않습니다.");
                return;
            }

            const user = {
               userUsername: this.username,
                userName: this.name,
                userPassword: this.password
            };

            // 회원가입 fetch
            fetchSignUp(user)
            .then(res => res.json())
            .then(res => {
                if(res.errorMessage) {
                    alert(res.errorMessage);
                    return;
                }else {
                    alert("회원가입을 완료했습니다. 로그인 해주세요");
                    window.location.href = "/login";
                }
            })
        },

    }
    
}
</script>
<style scoped>

input {
    border: none;
    border-radius: 5px;
}
.signup-form {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-left: auto;
    margin-right: auto;
    margin-top: 10vh;
    width: 30vw;
    height: 50vh;
    border: 1px solid black;
    border-radius: 10px;
    background: rgb(54, 230, 157);
}

.signup-form h2 {
    margin-top: 10%;
    text-align: center;
    width: 100%;
}

.signup-input {
    width: 70%;
    height: 35%;
    margin-top: 10%;
}

#signup-username,
#signup-name,
#signup-password,
#signup-repassword {
    display: flex;
    justify-content: space-between;
    height: 18%;
    background: white;
    padding-left: 20px;
    border-radius: 5px;
    margin-top: 2vh;
    margin-bottom: 2vh;
}

#signup-username input,
#signup-name input,
#signup-password input,
#signup-repassword input {
    margin-left: 15px;
}


#signup-button {
    width: 100%;
    height: 25px;
    margin-top: 20px;
    margin-bottom: 20px;
    background: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

#signup-button:hover {
    font-weight: 800;
}

.signup-form-buttons {
    font-size: 14px;
    color: #333;
    text-align: center;
}


</style>