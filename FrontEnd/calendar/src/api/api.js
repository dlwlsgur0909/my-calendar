// import axios from 'axios';

const config = {
    baseUrl: 'https://localhost:8080',
}

// 회원가입

function fetchSignUp(user) {
    return fetch(`${config.baseUrl}/signup`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(user)
    })
}


export {
    fetchSignUp,
}