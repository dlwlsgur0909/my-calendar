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

// 알정 상세 
function fetchScheduleDetail(data) {
    const username = window.sessionStorage.getItem('username');

    return fetch(`${config.baseUrl}/schedule/${username}/detail/`, {
        method: 'POST',
        headers: {
            'content-type': 'application/json',
        },
        body: JSON.stringify({
            year: data.year,
            month: data.month,
            date: data.date,
        })
    })
}

// 일정 추가 
function fetchAddSchedule(data) {
    const username = window.sessionStorage.getItem('username');

    return fetch(`${config.baseUrl}/schedule/${username}/new-detail/`, {
        method: 'POST',
        headers: {
            'content-type': 'application/json',
        },
        body: JSON.stringify({
            title: data.title,
            year: data.year,
            month: data.month,
            date: data.date,
        })
    })
}

// 일정 완료 여부 변경
function fetchChangeDone(data) {
    const username = window.sessionStorage.getItem('username');
    
    return fetch(`${config.baseUrl}/schedule/${username}/detail/${data.id}`, {
        method: 'PATCH',
        headers: {
            'content-type': 'application/json',
        },
        body: JSON.stringify({
            done: data.done,
        })
    })
}

// 일정 삭제
function fetchDetailDelete(id) {
    const username = window.sessionStorage.getItem('username');
    return fetch(`${config.baseUrl}/schedule/${username}/detail/${id}`, {
        method: 'DELETE',
    })
}

// 일정 제목 변경
function fetchDetailUpdate(data) {
    const username = window.sessionStorage.getItem('username');
    
    return fetch(`${config.baseUrl}/schedule/${username}/detail/${data.id}`, {
        method: 'PUT',
        headers: {
            'content-type': 'application/json',
        },
        body: JSON.stringify({
            title: data.title,
        })
    })

}




export {
    fetchSignUp,
    fetchLogin,
    fetchSchedule,
    fetchScheduleDetail,
    fetchAddSchedule,
    fetchChangeDone,
    fetchDetailDelete,
    fetchDetailUpdate,
}