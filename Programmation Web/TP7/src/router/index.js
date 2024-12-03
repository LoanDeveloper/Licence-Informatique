import { createRouter, createWebHashHistory } from 'vue-router'
import Quizs from '../components/Quizs.vue'
import Quiz from '../components/Quiz.vue'

const routes = [
    {
      path: '/',
      name: 'quizs',
      component: Quizs
    },
    {
      path: '/quiz/:num?',
      name: 'quiz',
      component: Quiz
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes,
  })

export default router