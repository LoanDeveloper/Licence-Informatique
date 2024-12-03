<template>
    <div class="bloccomposant">
        <ul>
            <un-contact v-for="(c, index) in contactsFavoris" :key="index" :contact="c"></un-contact>
        </ul>
        <a class="btn-floating btn-large waves-effect waves-light red" @click="voirForm"><i class="material-icons">{{ add }}</i></a>
        <transition name="addcontact">
            <ajouter-contact @ajouterContact="ajout" v-if="visible"></ajouter-contact>
        </transition>
    </div>
</template>

<script setup>
import UnContact from './UnContact.vue'
import AjouterContact from './AjouterContact.vue'
import { ref, computed } from 'vue'

const props = defineProps({
  contacts: Array
})

const emit = defineEmits(['ajouterContact'])

const visible = ref(false)
const add = ref('add')


const contactsFavoris = computed(()=>{
    return props.contacts.filter(contact => contact.favorite)
})

function ajout(contact) {
    // il faudrait refaire un emit vers le parent car normalement, on ne modifie pas une propriété d'un composant...
    props.contacts.push(contact)
    // solution avec emit !
    //emit(  'ajouterContact', contact)
    visible.value = false
    add.value = 'add'
}

function voirForm() {
    if (add.value == 'add') {
        visible.value = true
        add.value = 'remove'
    } else {
        visible.value = false
        add.value = 'add'
    }
}


</script>

<style scoped>
.addcontact-enter-active, .addcontact-leave-active {
    transition: opacity 5s;
}
.addcontact-enter, .addcontact-leave-to  {
    opacity: 0;
}
</style>