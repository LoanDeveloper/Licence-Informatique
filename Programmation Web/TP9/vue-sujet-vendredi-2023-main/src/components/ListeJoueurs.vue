<template>
    <div class="liste-joueurs">
        <h2>ListeJoueur</h2>

        <ul>
            <li v-for="(joueur, indice) in props.joueurs" :key="indice">
                <img v-if="joueur.image" :src="store.baseUrl+joueur.image" alt="" @click="emitFunction(joueur)">
                <img v-else :src="store.baseUrl+'nophoto.png'" alt="" @click="emitFunction(joueur)">
            </li>
        </ul>
       </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useDefaultStore } from '../stores/index'
import Stade from './Stade.vue'

const store = useDefaultStore();

const props = defineProps({
    joueurs: {
        type: Array,
        require: true
    }
  })

const emit = defineEmits(['emitFunction']);

function emitFunction(joueur){
    emit('appelEvenement',  joueur );
    console.log(joueur);
}
</script>

<style>
</style>