<script setup>
import Quizs from './components/Quizs.vue'
import { useRouter, useRoute } from 'vue-router'
// si vous voulez utilisez pinia , il faut placer ces deux lignes dans le composant de votre choix.
import { useDefaultStore } from './stores/index'
const store = useDefaultStore()


</script>

<template>
  <main>
    <router-view></router-view>
  </main>
</template>

<style>

</style>
