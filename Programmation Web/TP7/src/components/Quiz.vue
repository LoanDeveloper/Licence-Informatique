<template>

    <h2>{{ nom }}</h2>

    <h3>{{ questions[questionNumber].question }}</h3>

    <ul>
        <li v-for="(c, index) in questions[questionNumber].answers" :key="index"><button @click="reponse( c )">{{ c }}</button></li>
    </ul>

    <p v-if="reponseBool">Gagné ! <button @click="suivant">Continuer !</button></p>
</template>
  
<script setup>
import { useDefaultStore } from '@/stores';
import { useRouter, useRoute } from 'vue-router'
import {computed, ref} from 'vue'

const store = useDefaultStore()
const route = useRoute();

const nom = computed({
    get(){
        if(route.params.num < 3){
            return store.data.quizs[route.params.num].nom;
        }else{
            return "erreur num";
        }
    }

})

const questions = computed({
    get(){
        if (route.params.num < 3){
            return store.data.quizs[route.params.num].questions;
        }else{
            return "erreur num";
        }
    }
})

let reponseBool = ref(false);
function reponse(c){
    if (c == store.data.quizs[route.params.num].questions[questionNumber.value].answers[store.data.quizs[route.params.num].questions[questionNumber.value].ok]){
        reponseBool.value = true;
    }
}

let questionNumber = ref(0)
function suivant(){
    if (questionNumber.value < store.data.quizs[route.params.num].questions.length){
        questionNumber.value++;
        reponseBool.value = false;
    }
}
</script>
  
<style>
</style>