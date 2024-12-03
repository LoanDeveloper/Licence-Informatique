<template>
    <p>{{ c.nom }}</p>
</template>

<script>
import { ref } from 'vue'

const props = defineProps({
    nom: {
        type: String,
        require: true
    },
    prenom: {
        type: String,
        require: true
    },
    adresse: {
        type: String,
        require: true
    },
    tel: {
        type: Number,
        require: true
    },
    favorite: {
        type: Boolean,
        require: true
    }
})
</script>