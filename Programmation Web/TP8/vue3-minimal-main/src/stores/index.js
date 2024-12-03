import { defineStore } from 'pinia'

export const useDefaultStore = defineStore({
  id: 'default',
  state: () => ({
    cle: '59a89c842909ccfafe26e72300471b2c',
    urlMeteo: 'https://api.openweathermap.org/data/2.5/weather?lang=fr&units=metric&q='
  }),
  
  getters: {
    
  },
  actions: {
    
  }
})
