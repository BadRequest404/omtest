<template>
  <div v-if="country">
    <h1>{{ country.name.common }}</h1>
    <img :src="country.flags.svg" :alt="country.name.common">
    <p><strong>Population:</strong> {{ country.population }}</p>
    <p><strong>Capital:</strong> {{ country.capital }}</p>
    <router-link to="/">Back to Home</router-link>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      country: null
    };
  },
  async created() {
    const name = this.$route.params.name;
    try {
      const response = await axios.get(`https://restcountries.com/v3.1/name/${name}`);
      this.country = response.data[0];
    } catch (error) {
      console.error("Error fetching country details:", error);
    }
  }
};
</script>
