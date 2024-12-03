<template>

    <figure>
        <img id="mainimg" :src="baseUrl + props.image" alt="">
        <figcaption>{{titre}}</figcaption>
    </figure>

  </template>
  
  <script setup>
    import { ref } from 'vue'; // à ne faire qu’une fois pour toutes les variables
  
    const baseUrl = ref('https://ntrugeon.lpmiaw.univ-lr.fr/Cours/CoursVueL2/');
    
    const props = defineProps({
        titre: {
            type: String,
            require: true
        },
        image: {
            type: String,
            require: true
        }
    })

  </script>
  
  <style>
  </style>