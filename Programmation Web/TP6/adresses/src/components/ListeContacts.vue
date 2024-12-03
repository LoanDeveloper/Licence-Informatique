<template>
    <ul>
        <li v-for="(c,index) in props.contactFavoris" :key="index"><UnContact :nom="c.nom" :prenom="c.prenom" :adresse="c.adresse" :tel="c.tel" :favorite="c.favorite"/></li>
    </ul>

    <AjouterContact />
</template>
  
<script setup>
import { ref } from 'vue'
import UnContact from './UnContact.vue'
import AjouterContact from './AjouterContact.vue'

const props = defineProps({
    contactFavoris: {
        type: Array,
        require: true
    }
})
</script>
 
<style>
</style>