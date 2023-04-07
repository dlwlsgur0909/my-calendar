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
            const dateInfo = {
                year: store.state.year,
                month: store.state.month
            }

            store.dispatch('CREATE_CALENDAR', dateInfo);
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