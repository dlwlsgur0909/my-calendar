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
        headers: {
            'content-type': 'application/json',
        },
        body: JSON.stringify(user)
    })
}

// 일정 목록
function fetchSchedule(data) {
    const username = window.sessionStorage.getItem('username');

    return fetch(`${config.baseUrl}/schedule/${username}`, {
        method: 'POST',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify({
            beginYear: data.beginYear,
            beginMonth: data.beginMonth,
            beginDate: data.beginDate,
            endYear: data.endYear,
            endMonth: data.endMonth,
            endDate: data.endDate
        })
    })
}




export {
    fetchSignUp,
    fetchLogin,
    fetchSchedule,
}