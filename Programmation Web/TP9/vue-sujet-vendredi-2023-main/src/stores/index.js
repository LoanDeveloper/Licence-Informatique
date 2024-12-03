import { defineStore } from 'pinia';
import Axios from 'axios';
import { ref, onMounted } from 'vue';


export const useDefaultStore = defineStore({
  
  id: 'default',
  state: () => ({
    
    baseUrl: 'https://ntrugeon.lpmiaw.univ-lr.fr/staderochelais/imagesJoueurs/',
    postes: ref(null),
    listeJoueurs: ref(null)
  }),
  getters: {
    
  },
  actions: {

    fetchData() {
      let url = ref("http://localhost:3000/postes");
      let url2 = ref("http://localhost:3000/listeJoueurs")

      Axios.get(url2.value)
        .then(response => {
            this.listeJoueurs = response.data
            //console.log(donnees)
            // on poursuit le traitement
            console.log("test");
        })
        .catch( e => {
            // on poursuit la gestion des erreurs
            console.log("non");
            console.log(e);
        })

        Axios.get(url.value)
        .then(response => {
            this.postes = response.data
            // on poursuit le traitement
            console.log("test2");
          })
          .catch( e => {
              // on poursuit la gestion des erreurs
              console.log("non");
              console.log(e);
          })

          }
    
  }
})
