import { flushPromises, mount } from '@vue/test-utils';
import { createRouter, createMemoryHistory } from 'vue-router';
import App from '@/App.vue';
import HomeView from '@/views/HomeView.vue';
import CountryDetail from '@/views/CountryDetail.vue';
import axios from 'axios';
import { vi } from 'vitest';

vi.mock('axios');

const router = createRouter({
  history: createMemoryHistory(),
  routes: [
    { path: '/', component: HomeView },
    { path: '/country/:name', component: CountryDetail },
  ],
});

describe('Navigation', () => {
  it('navigates from home to country detail page', async () => {
    axios.get.mockResolvedValue({
      data: [
        { name: { common: 'France' }, flags: { svg: 'https://flagcdn.com/fr.svg' } },
      ],
    });

    router.push('/');
    await router.isReady();

    const wrapper = mount(App, {
      global: {
        plugins: [router],
      },
    });

    // Wait for Vue to finish rendering
    await flushPromises();

    const flagCard = wrapper.find('.flag-card');
    expect(flagCard.exists()).toBe(true); // Ensure it exists before clicking

    await flagCard.trigger('click');

    // Wait for navigation
    await flushPromises();

    expect(wrapper.html()).toContain('France'); // Ensure the detail page loaded
  });
});
