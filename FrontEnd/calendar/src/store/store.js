import { createStore } from 'vuex';
import mutations from './mutations.js';
import actions from './actions.js';



export const store = createStore({
    state: {
        loginStatus: window.sessionStorage.getItem('username') !== null ? true : false,
        username: window.sessionStorage.getItem('username'),
        name: window.sessionStorage.getItem('name'),
        regdate: window.sessionStorage.getItem('regdate'),
        calendar: [],
        year: new Date().getFullYear(),
        month: new Date().getMonth(),
        date: new Date().getDate(),
        day: new Date().getDay(),
        nowYear: new Date().getFullYear(),
        nowMonth: new Date().getMonth(),
        nowDate: new Date().getDate(),
        // firstDay: new Date(new Date().getFullYear(), new Date().getMonth()).getDay(),
        // firstDate: new Date(new Date().getFullYear(), new Date().getMonth()).getDate(),
        // start: new Date(new Date.setDate())
        // prevYear: new Date().getMonth() === 0 ? new Date().getFullYear()-1 : new Date().getFullYear(),
        // prevMonth: new Date().getMonth() === 0 ? 12 : new Date().getMonth(),
        // calender: [],
        // today: new Date().toLocaleDateString(),
        // year: new Date().getFullYear(),
        // month: new Date().getMonth()+1,
        // date: new Date().getDate(),
        // day: new Date().getDay(),
        // totalDays: 30,

    },
    mutations, 
    actions,

});