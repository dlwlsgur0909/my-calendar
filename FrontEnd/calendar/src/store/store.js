import { createStore } from 'vuex';
import mutations from './mutations.js';
import actions from './actions.js';



export const store = createStore({
    state: {
        loginStatus: window.sessionStorage.getItem('username') !== null ? true : false,
        username: window.sessionStorage.getItem('username'),
        name: window.sessionStorage.getItem('name'),
        regdate: window.sessionStorage.getItem('regdate'),
        schedule:[],
        scheduleDetail: [],
        calendar: [],
        year: new Date().getFullYear(),
        month: new Date().getMonth(),
        date: new Date().getDate(),
        day: new Date().getDay(),
        nowYear: new Date().getFullYear(),
        nowMonth: new Date().getMonth(),
        nowDate: new Date().getDate(),


    },
    mutations, 
    actions,

});