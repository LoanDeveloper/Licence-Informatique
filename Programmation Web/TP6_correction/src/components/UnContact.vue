<template>
    <li class="bloccomposant">
        <h4 class='label'>{{ contact.nom }} {{ contact.prenom }} : </h4>
        <p class='desc'>{{ contact.adresse }}</p>
        <p>{{ contact.telephone }}</p>
    </li>
</template>

<script setup>
defineProps({
    contact: Object
})
</script>