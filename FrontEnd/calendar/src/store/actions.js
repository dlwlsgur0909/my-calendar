/* eslint-disable */ 

import {
    fetchSignUp,
    fetchLogin
} from '../api/api.js';

import router from '../router/router.js';

export default {

    
    FETCH_SIGNUP(context, user) {
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

    FETCH_LOGIN(context, user) {
        fetchLogin(user)
        .then(res => res.json())
        .then(res => {
            if(res.errorMessage) {
                alert(res.errorMessage);
                return;
            }else {
                window.sessionStorage.setItem('username', res.userUsername);
                window.sessionStorage.setItem('name', res.userName);
                window.sessionStorage.setItem('regdate', res.userRegdate);
                
                window.location.href = "/index";
            }
        })
        .catch(error => console.log(error))
    },

}