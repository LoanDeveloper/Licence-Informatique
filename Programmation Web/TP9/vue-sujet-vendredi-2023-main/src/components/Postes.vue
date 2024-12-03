<template>
    <div class="postes">
        <h2>Poste</h2>

        <nav>
          <ul>
            <li v-for="(poste, indice) in store.postes" :key="indice" @click.prevent="emitFunction(poste)"><a href="#">{{ poste }}</a></li>
          </ul>
        </nav>
    </div>
</template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { useDefaultStore } from '../stores/index'
  
  const store = useDefaultStore();
  
  const props = defineProps({
    postes: {
        type: Array,
        require: true
    }
  })

  const emit = defineEmits(['emitFunction']);

  function emitFunction(poste){
    emit('appelEvenement',  poste );
  }
  </script>
  
  <style>
  </style>