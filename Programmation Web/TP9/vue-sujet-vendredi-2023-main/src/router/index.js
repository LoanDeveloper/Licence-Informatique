import { createRouter, createWebHashHistory } from 'vue-router'
import StadeVue from '../components/Stade.vue'

const routes = [
    // À compléter
    {
      path: '/',
      name : 'homepage',
      component : StadeVue
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes,
  })

export default router