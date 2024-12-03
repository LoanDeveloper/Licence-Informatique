<template>
  <h2 class="m-2">{{titre}}</h2>
  <ul class="list-group" v-if="visible">
    <li class="list-group-item" v-for="(el,indice) in liste" :key="indice">{{ el.nom }}</li>
  </ul>
  <button class="btn btn-info" @click="affiche">{{btnTexte}}</button>
</template>

<script setup>
  import { ref } from 'vue'; // à ne faire qu’une fois pour toutes les variables
  const titre = ref('Bienvenue');
  const visible = ref(true);
  const liste = ref([
    {nom: 'eno'},
    {nom: 'val'},
    {nom: 'loan'}
  ]);
  const btnTexte = ref('cacher');

  function affiche(){
    visible.value = !visible.value;
    if (btnTexte.value === 'cacher'){
      btnTexte.value = 'montrer';
    }else{
      btnTexte.value = 'cacher';
    }
  }
</script>

<style scoped>
@import url('https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css');
</style>