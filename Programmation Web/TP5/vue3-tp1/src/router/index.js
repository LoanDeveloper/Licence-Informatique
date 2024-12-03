import { createRouter, createWebHashHistory } from 'vue-router'
import PremierComposant from '../components/PremierComposant.vue'

const routes = [
    // À compléter
    {
      path: '/',
      name : 'homepage',
      component : PremierComposant
    }
  ]
const router = createRouter({
    history: createWebHashHistory(),
    routes,
  })

export default router