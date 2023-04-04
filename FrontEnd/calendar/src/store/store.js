import { createStore } from 'vuex';
import mutations from './mutations.js';
import actions from './actions.js';


export const store = createStore({
    state: {
        loginStatus: window.sessionStorage.getItem('username') !== null ? true : false,
        username: window.sessionStorage.getItem('username'),
        name: window.sessionStorage.getItem('name'),
        regdate: window.sessionStorage.getItem('regdate')
    },
    mutations, 
    actions,

});