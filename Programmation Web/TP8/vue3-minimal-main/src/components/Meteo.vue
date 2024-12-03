<script setup>
  import { ref, onMounted } from 'vue';
  import Axios  from 'axios';
  import { useDefaultStore } from '../stores/index'
  const store = useDefaultStore()

  const props = defineProps({
    ville: {
        type: String,
        require: true
    }
  })

  const donnees = ref(null);
  const estCharge = ref(false)
  const url = ref(store.urlMeteo + props.ville + '&appid=' + store.cle);

  onMounted(() => {
    
    Axios.get(url.value)
        .then(response => {
            donnees.value = response.data;
            estCharge.value = true;
            console.log(donnees);
        })
        .catch(e => {
            console.log(e)
        })
  })

  </script>
  
  <template>
    <h2>Meteo</h2>
    
    <p>Ville : {{ props.ville }}</p>
    <p v-if="estCharge">Température : {{ donnees.main.temp }} °C</p>
    <p v-if="estCharge">Coordonnées : {{ donnees.coord.lon}} {{ donnees.coord.lat }}</p>
    <p v-if="estCharge">Condition météo : {{ donnees.weather[0].description }}</p>
  </template>

  <style>
  </style>