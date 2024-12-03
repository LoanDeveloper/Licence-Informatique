<template>
    <div class="joueur">
        <h2>Joueur</h2>

        <img v-if="props.joueur" :src="store.baseUrl+props.joueur.image" alt="">
        <h2 v-if="props.joueur">{{ props.joueur.nom }}</h2>
        <h3 v-if="props.joueur"> {{ props.joueur.prenom }}</h3>
        <h4 v-if="props.joueur">Poste : {{ props.joueur.poste }}</h4>
        <p v-if="props.joueur">Nationalité : {{ props.joueur.nationalite }}</p>

    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useDefaultStore } from '../stores/index'

const store = useDefaultStore();

const props = defineProps({
    joueur: {
        type: String,
        require: true
    }
  })

</script>

<style>
</style>