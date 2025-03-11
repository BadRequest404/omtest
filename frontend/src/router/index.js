import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import CountryDetail from '../views/CountryDetail.vue';

const routes = [
  { path: '/', component: HomeView },
  { path: '/country/:name', component: CountryDetail }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
