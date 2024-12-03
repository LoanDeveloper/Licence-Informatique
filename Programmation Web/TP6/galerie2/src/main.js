import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router/index.js'
import './assets/css/layout.css'
import './assets/css/look.css'
import './assets/css/reset.css'

const app = createApp(App)

app.use(router)
app.use(createPinia())

app.mount('#app')
