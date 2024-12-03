<script setup>
import PremierComposant from './components/PremierComposant.vue'
import Galerie from './components/Galerie.vue'
import Panier from './components/Panier.vue'


// si vous voulez utilisez pinia , il faut placer ces deux lignes dans le composant de votre choix.
//import { useDefaultStore } from './stores/index'
//const store = useDefaultStore()
</script>

<template>
  <main>
    <PremierComposant />
    <Galerie />
    <Panier />
  </main>
</template>

<style>

</style>
