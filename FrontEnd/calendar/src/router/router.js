import { createWebHistory, createRouter} from 'vue-router';
import IndexView from '../views/IndexView.vue';
import LoginView from '../views/LoginView.vue';
import SignUpView from '../views/SignUpView.vue';
import { store } from '../store/store.js';


/* eslint-disable */

const routes = [
    {
        path: '/',
        redirect: '/login',
    },
    {
        path: '/login',
        name: 'login',
        component: LoginView
    },
    {
        path: '/signup',
        name: 'signup',
        component: SignUpView
    },
    {
        path: '/index',
        name: 'index',
        component: IndexView,
        beforeEnter: (to, from, next) => {
            // 선택 날짜 정보
            let year = store.state.year;
            let month = store.state.month;
            let firstDay = new Date(year, month).getDay();
            let firstDate = new Date(year, month, 1);
            let lastDate = new Date(year, month+1, 0).getDate();

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
            let afterEnd = 42 - (lastDate + (beforeEnd - beforeStart) + 1);

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
                    firstDate: 1,
                    lastDate: lastDate
                }
            };


            store.commit('SET_CALENDAR', obj);
            next();

        }
    },
    {
        path: '/logout',
        name: 'logout',
        beforeEnter: () => {
            window.sessionStorage.clear();
            window.location.href = "/login";
        }
        
    },
    {
        path: '/users',
        name: 'users'
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;