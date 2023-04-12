/* eslint-disable */ 

import {
    fetchSignUp,
    fetchLogin,
    fetchSchedule
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

    FETCH_SCHEDULE(context, data) {

    },

    CHANGE_MONTH(context, month) {
        context.commit('SET_MONTH', month);
    },

    CHANGE_YEAR(context, year) {
        context.commit('SET_YEAR', year);
    },

    CREATE_CALENDAR(context, dateInfo) {


        const year = dateInfo.year;
        const month = dateInfo.month;

        let firstDay = new Date(year, month).getDay();
        let firstDate = new Date(year, month, 1);
        let lastDate = new Date(year, month+1, 0).getDate();
        let isFirstZero = firstDay === 0 ? true : false;

        // 전월 정보
        let before = new Date(firstDate.setDate(firstDate.getDate()-firstDay));
        let beforeYear = before.getFullYear();
        let beforeMonth = before.getMonth();
        let beforeStart = before.getDate();
        let beforeEnd = new Date(beforeYear, beforeMonth+1, 0).getDate();
        
        // 다음 달 정보
        let afterYear = month === 11 ? year + 1 : year;
        let afterMonth = month + 1
        let afterStart = 1;
        let afterEnd = 42;



        const data = { 
            beginYear: beforeYear,
            beginMonth: beforeMonth+1,
            beginDate: beforeStart,
            endYear: afterYear+1,
            endMonth: afterMonth,
        }


        if(firstDay === 0) {
            afterEnd -= lastDate;
        }else {
            afterEnd -= (lastDate + (beforeEnd - beforeStart) + 1);
        }

        data.endDate = afterEnd;

        const obj = {
            beforeObj: {
                beforeYear: beforeYear,
                beforeMonth: beforeMonth,
                beforeStart: beforeStart,
                beforeEnd: beforeEnd
            },
            afterObj: {
                afterYear: afterYear,
                afterMonth: afterMonth,
                afterStart: afterStart,
                afterEnd: afterEnd
            },
            currentObj: {
                currentYear: year,
                currentMonth: month,
                firstDate: 1,
                lastDate: lastDate,
                isFirstZero: isFirstZero
            }
        };

        fetchSchedule(data)
        .then(res => res.json())
        .then(res => {
            if(res.errorMessage) {
                alert(res.errorMessage);
                return;
            }else {
                context.commit('SET_SCHEDULE', res);
            }
        })


        context.commit('SET_CALENDAR', obj);



        // this.FETCH_SCHEDULE(data);
    }

    // 해당 년, 월의 총 일 수를 구하는 함수
    // CalculateTotalDays(context, year, month) {
    //     totalDays = new Date(year, month, 0).getDate();
    //     context.commit('SET_TOTALDAYS', totalDays);
    // }

}