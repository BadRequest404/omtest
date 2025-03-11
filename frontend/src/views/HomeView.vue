<template>
  <div>
    <h1>Country Flags</h1>
    <div class="grid">
      <div v-for="country in countries" :key="country.name.common" class="flag-card" @click="goToDetails(country.name.common)">
        <img :src="country.flags.svg" :alt="country.name.common">
        <p>{{ country.name.common }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      countries: []
    };
  },
  async created() {
    try {
      const response = await axios.get('https://restcountries.com/v3.1/all');
      this.countries = response.data;
    } catch (error) {
      console.error("Error fetching countries:", error);
    }
  },
  methods: {
    goToDetails(name) {
      this.$router.push(`/country/${name}`);
    }
  }
};
</script>

<style>
.grid {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
}
.flag-card {
  cursor: pointer;
  text-align: center;
  width: 120px;
}
.flag-card img {
  width: 100px;
  height: auto;
}
</style>
