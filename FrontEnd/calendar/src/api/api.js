// import axios from 'axios';

const config = {
    baseUrl: 'http://localhost:8080',
}

// 회원가입
function fetchSignUp(user) {
    return fetch(`${config.baseUrl}/signup`, {
        method: 'POST',
        headers: {
            'content-type': 'application/json',
        },
        body: JSON.stringify(user)
    })
}

// 로그인
function fetchLogin(user) {
    return fetch(`${config.baseUrl}/login`, {
        method: 'POST',
        header: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
}




export {
    fetchSignUp,
    fetchLogin,
}