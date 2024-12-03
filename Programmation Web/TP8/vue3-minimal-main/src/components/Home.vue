<template>
  <Meteo :ville="ville"/>
</template>

<script setup>
import { ref } from 'vue';
import Meteo from './Meteo.vue'

const ville = ref("La Rochelle");
</script>

<style>
</style>