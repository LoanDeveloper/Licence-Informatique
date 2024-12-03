<script setup>

// si vous voulez utilisez pinia , il faut placer ces deux lignes dans le composant de votre choix.
//import { useDefaultStore } from './stores/index'
//const store = useDefaultStore()
</script>

<template>
  <header>
    <nav id="nav">
      <router-link to="/">Accueil</router-link>
    </nav>
    <img src="@/assets/logo.png" alt="logo stade">
  </header>
  <main>
    <RouterView></RouterView>
  </main>
  <footer>
    <p>©The Boss</p>
  </footer>
</template>

<style>

</style>
