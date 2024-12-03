<template>
  <Galerie :photos="photos"></Galerie>
  <Galerie :photos="photos2"></Galerie>
</template>

<script setup>
  import { ref } from 'vue'; // à ne faire qu’une fois pour toutes les variables
  import Galerie from './Galerie.vue'
  const photos = ref([
      {
          lien : 'images/grandes/clouds.jpg',
          titre: 'Nuages sur les Alpes',
          mini: 'images/petites/clouds.jpg'
      },
      {
          lien : 'images/grandes/colorfull.jpg',
          titre: 'Lac de montagne',
          mini: 'images/petites/colorfull.jpg'
      },
      {
          lien : 'images/grandes/melbourne.jpg',
          titre: 'Falaises de Melbourne',
          mini: 'images/petites/melbourne.jpg'
      },
      {
          lien : 'images/grandes/road.jpg',
          titre: 'Route des Rocheuses',
          mini: 'images/petites/road.jpg'
      },
      {
          lien : 'images/grandes/rocks.jpg',
          titre: 'Pic',
          mini: 'images/petites/rocks.jpg'
      },
      {
          lien : 'images/grandes/viaduc.jpg',
          titre: 'Viaduc',
          mini: 'images/petites/viaduc.jpg'
      },
  ]);

  const photos2 = ref([]);
</script>

<style>
</style>