<template>
  <div id="app">
    <header-menu></header-menu>
    <router-view></router-view>
  </div>
</template>

<script>

import HeaderMenu from './components/HeaderMenu.vue';

export default {
  name: 'App',
  components: {
    HeaderMenu,
  }
}
</script>

<style>

body {
  margin: 0;
  padding: 0;
}

</style>
