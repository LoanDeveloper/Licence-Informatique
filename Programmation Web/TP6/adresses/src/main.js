import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router/index.js'
import 'materialize-css'
import 'materialize-css/dist/css/materialize.css'

const app = createApp(App)

app.use(router)
app.use(createPinia())

app.mount('#app')
