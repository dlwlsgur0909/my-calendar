// import Vue from 'vue';
import router from './router/router.js';
import { createApp } from 'vue'
import { store } from './store/store.js';
import App from './App.vue'

const app = createApp(App);
app.use(router);
app.use(store);
app.mount('#app');