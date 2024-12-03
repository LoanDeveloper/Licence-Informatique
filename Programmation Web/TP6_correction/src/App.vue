<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <div class="wrapper">
      <nav class="teal lighten-2">
        <h2>TP6 VueJS</h2>
        <ul>
          <li><RouterLink to="/">Home</RouterLink></li>
          <li><RouterLink to="/about">About</RouterLink></li>
        </ul>
      </nav>
    </div>
  </header>

  <RouterView />
  <footer class="page-footer teal lighten-2">
  <p>L2 - informatique</p>
  </footer>
</template>

<style scoped>
nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 5px 50px;
}

footer {
  margin-top: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
