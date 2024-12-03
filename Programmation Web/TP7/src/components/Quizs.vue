<template>
  
  <div class="home">
    <img src="../assets/quiz.f4c7e189.png" />
    <div data-v-26442b8c="" class="container"><div data-v-26442b8c="" class="card"><!---->
      <header data-v-26442b8c="" class="card-header"><div data-v-26442b8c="">Choisissez un quiz</div></header>
      <div data-v-26442b8c="" class="card-body"><!----><!----><div data-v-26442b8c="" class="list-group">
        <button data-v-26442b8c="" type="button" class="list-group-item list-group-item-action">Culture générale</button>
        <button data-v-26442b8c="" type="button" class="list-group-item list-group-item-action"> Informatique
      </button><button data-v-26442b8c="" type="button" class="list-group-item list-group-item-action">
        Technique
      </button></div></div><!----><!----></div></div>
  </div>
  <section>
    <ul>
      <li v-for="(item,index) in store.data.quizs" :key="index">
        <router-link :to="{name: 'quiz', params: {num: index}}">{{ item.nom }}</router-link>
      </li>
    </ul>
  </section>

  <link src="../assets/app.e3c888d6.css" rel="stylecheet"/>
</template>

<script setup>
import { useDefaultStore } from '@/stores';

const store = useDefaultStore()

</script>

<style>


</style>