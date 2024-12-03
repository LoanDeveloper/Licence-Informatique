<template>
  <div class="stade">
    <h1>Bienvenue au Stade Rochelais</h1>
    <img src="../assets/effectif.png" alt="">
  </div>

  <Postes @appelEvenement="changePoste(p)"/>
  <ListeJoueur :joueurs="store.listeJoueurs" @appelEvenement="changeJoueur"/>
  <Joueur :joueur="joueur"/>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import ListeJoueur from './ListeJoueurs.vue';
import Postes from './Postes.vue';
import Joueur from './Joueur.vue';
import { useDefaultStore } from '../stores/index';

const store = useDefaultStore();

const joueur = ref(null);
const poste = ref("Tous");

const emit = defineEmits(['appelEvenement']);

onMounted(() => {
  store.fetchData();
})

function changeJoueur(j){
  joueur.value = j;
  emit('appelEvenement', j) ;
}

function changePoste(p){
  poste.value = p;
  console.log("yes "+ poste)
}
</script>

<style>
</style>