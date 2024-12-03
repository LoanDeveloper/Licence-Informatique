<template>
  <main>
    <div class="wrapper">
    <!-- on charge le composant HelloWorld -->
      <HelloWorld msg="Exemple avec les composants" />
    </div>
  </main>
</template>

<script setup>
import HelloWorld from './components/HelloWorld.vue'
</script>

<style>
/* on importe un fichier pour le composant css*/
@import './assets/composant.css';

</style>
