<template>
  <button @click="testEnfant">Test du compsant enfant</button>
</template>

<script setup>

// on crée un point d'entrée pour les évènements
const emit = defineEmits(['appelEvenement'])

function testEnfant() {
  // on lance l'évènement en lui passant des données
  emit('appelEvenement', 'pink')
}
</script>