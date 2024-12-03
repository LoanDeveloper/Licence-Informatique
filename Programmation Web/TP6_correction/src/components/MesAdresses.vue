<template>
<div class="container">
  <div class="bloccomposant">
    <h1>Mon carnet d'adresses</h1>
    <liste-contacts :contacts="personnes" @ajouterContact="ajout"></liste-contacts>
  </div>
</div>
</template>


<script setup>
import { ref } from 'vue'
import ListeContacts from './ListeContacts.vue'

const personnes = ref([
  {
    nom: 'Dupont',
    prenom: 'Pierre',
    telephone: '0612345667',
    adresse: '34 rue Bolivar 17000 La Rochelle',
    favorite: true
  }, 
  {
    nom: 'Courboulay',
    prenom: 'Vincent',
    telephone: '0612345689',
    adresse: '41 bd du 11 novembre 1918 17000 La Rochelle',
    favorite: true
  }, 
  {
    nom: 'Bourmaud',
    prenom: 'Anthony',
    telephone: '0612345611',
    adresse: '43 bd du 11 novembre 1918, 17000 La Rochelle',
    favorite: false
  }, 
  {
    nom: 'Demko',
    prenom: 'Christophe',
    telephone: '0612345600',
    adresse: '45, bd du 11 novembre 1918 17000 La Rochelle',
    favorite: false
  }
])

// fonction à faire si on veut faire la remontée proprement...
function ajout(contact) {
  personnes.value.push(contact)
}
</script>
