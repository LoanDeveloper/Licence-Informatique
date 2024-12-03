import { createRouter, createWebHashHistory } from 'vue-router'
import Galeries from '../components/Galeries.vue'

const routes = [
    // À compléter
    {
      path: '/',
      name : 'homepage',
      component : Galeries
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes,
  })

export default router