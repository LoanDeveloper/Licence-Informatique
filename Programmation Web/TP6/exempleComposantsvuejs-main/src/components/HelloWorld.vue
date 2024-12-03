<template>
  <div class="greetings">
    <h1>{{ msg }}</h1>
    <h2 :style="{color: couleur}">{{ chaine }}</h2>
    <button @click="test">Test du compsant HelloWorld</button>
  </div>
  <section>
    <!-- ou <composant-enfant> -->
    <!-- on définit un évènement dans l'enfant qui appel une fonction du parent -->
    <ComposantEnfant @appelEvenement="test2" />
  </section>
</template>

<script setup>
// on importe les éléments de vue dont on a besoin
import { ref } from 'vue'

// on importe les composants enfants
import ComposantEnfant from './ComposantEnfant.vue'

// defineProps permet de définir les paramètres d'entrée du composant
// ici un paramètre msg de type chaîne de caractère qui est obligatoire
defineProps({
  msg: {
    type: String,
    required: true
  }
})

// on définit une variable nom qui est un objet
// on utilise ref pour que ce soit réactif
const chaine = ref('Bonjour ! Une chaine de caractère de départ')

const couleur = ref('green')

// on définit une fonction facilement
function test() {
  chaine.value = "Le composant change sa propre chaine de caractère"
  couleur.value = 'red'
}

function test2(c) {
  console.log(c)
  chaine.value = "Le composant enfant change une des propriétés du composant parent avec emit"
  couleur.value = c
}


</script>

<style scoped>
/* scoped pour dire que ce css est encapsulé uniquement pour ce composant */

h1 {
  font-weight: 500;
  font-size: 2.6rem;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}

.greetings h1,
.greetings h3 {
  text-align: center;
}

@media (min-width: 1024px) {
  .greetings h1,
  .greetings h3 {
    text-align: left;
  }
}
</style>
