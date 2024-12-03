<template>
    <div>

    <h1>Galerie</h1>

    <div class="till">
    <figure>
        <img id="mainimg" :src="baseUrl + image" alt="">
        <figcaption>{{titre}}</figcaption>
    </figure>
    </div>

    <ul>
        <li v-for="(element, index) in photos" :key="index">
            <img :src="baseUrl + element.mini" alt="" @mouseenter="change(element)">
        </li>
    </ul>
    </div>

</template>
  
  <script setup>
    import { ref } from 'vue'; // à ne faire qu’une fois pour toutes les variables

    const baseUrl = ref('https://ntrugeon.lpmiaw.univ-lr.fr/Cours/CoursVueL2/');
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
    const image = ref(photos.value[0].lien);
    const titre = ref(photos.value[0].titre);
   
    function change(element){
        image.value = element.lien;
        titre.value = element.titre;
    }
  </script>
  
  <style type="text/css" scoped>
  @import url('https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css');
    .till{
        display: flex;
        justify-content: center;

    }
    ul {
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
    }
    li {
        padding:1em;
        list-style: none;
    }
 </style>