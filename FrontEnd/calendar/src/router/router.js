import { createWebHistory, createRouter} from 'vue-router';
import IndexView from '../views/IndexView.vue';
import LoginView from '../views/LoginView.vue';
import SignUpView from '../views/SignUpView.vue';


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
        component: IndexView
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