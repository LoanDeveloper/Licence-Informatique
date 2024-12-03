<template>
    <h2>Galerie</h2>
    <ImageView :titre="titre" :image="lien"></ImageView>
    <ul>
        <li v-for="(element, index) in props.photos" :key="index">
            <img :src="baseUrl + element.mini" alt="" @mouseenter="changePhoto(element)">
        </li>
    </ul>
  </template>
  
  <script setup>
    import { ref } from 'vue'; // à ne faire qu’une fois pour toutes les variables
    import ImageView from './ImageView.vue';
  
    const baseUrl = ref('https://ntrugeon.lpmiaw.univ-lr.fr/Cours/CoursVueL2/');

    const props = defineProps({
        photos: {
            type: Array,
            require: true
        }
    })

    const titre = ref(props.photos[0].titre)
    const lien = ref(props.photos[0].lien)

    function changePhoto(element){
        titre.value = element.titre;
        lien.value = element.lien;
    }
  </script>
  
  <style>
  </style>