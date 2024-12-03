<template>
    <div class="bloccomposant">
        <h3>Ajouter un contact</h3>
        <p><label for="nom">Nom</label><input id="nom" type="text" v-model="personne.nom" class="validate"></p>
        <p><label for="prenom">Prénom</label><input id ="prenom" type="text" v-model="personne.prenom" class="validate"></p>
        <p><label for="adresse">Adresse</label><input id="adresse" type="text" v-model="personne.adresse" class="validate"></p>
        <p><label for="telephone">Téléphone</label><input id="telephone" type="tel" v-model="personne.telephone" class="validate"></p>
        <p><label for="fav"><input type="checkbox" v-model="personne.favorite" id="fav"><span>Favori</span></label></p>
        <button class="btn waves-effect waves-light" @click="ajouterContact">Ajouter<i class="material-icons right">send</i></button>
    </div>
</template>

<script setup>
import { ref } from 'vue'

const emit = defineEmits(['ajouterContact'])

const personne = ref({
    nom: '',
    prenom: '',
    telephone: '',
    adresse: '',
    favorite: false
  })


function ajouterContact() {
    emit(  'ajouterContact', personne.value)
}
</script>
