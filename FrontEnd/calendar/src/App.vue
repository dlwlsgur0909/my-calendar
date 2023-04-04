<template>
  <div id="app">
    <header-menu></header-menu>
    <!-- {{loginStatus}} -->
    <router-view></router-view>
  </div>
</template>

<script>

import HeaderMenu from './components/HeaderMenu.vue';

export default {
  name: 'App',
  components: {
    HeaderMenu,
  },
  computed: {
    loginStatus() {
      console.log(this.$store.state.loginStatus);
      return this.$store.state.loginStatus;
    }
  }
}
</script>

<style>

body {
  margin: 0;
  padding: 0;
}

</style>
