<template>
  <h2>Mon carnet d'adresses</h2>

  <ListeContacts :contact-favoris="contactsFavoris"/>
</template>

<script setup>
import { ref } from 'vue'
import { computed } from 'vue'

import ListeContacts from './ListeContacts.vue'

const contacts = ref([
  {
    nom: "thomy",
    prenom: "loan",
    adresse: "16 rue leonard de vinci",
    tel: "06111111",
    favorite: true
  },
])

const contactsFavoris = computed(() => {
  return contacts.value.filter(contact => contact.favorite)
})

</script>

<style>
</style>