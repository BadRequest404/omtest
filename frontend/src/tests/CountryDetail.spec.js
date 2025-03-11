import { mount } from '@vue/test-utils';
import CountryDetail from '@/views/CountryDetail.vue';
import axios from 'axios';
import { createRouter, createMemoryHistory } from 'vue-router';
import { vi } from 'vitest';

// Mock API response
vi.mock('axios');

const router = createRouter({
  history: createMemoryHistory(),
  routes: [{ path: '/country/:name', component: CountryDetail }],
});

describe('CountryDetail.vue', () => {
  it('fetches and displays country details', async () => {
    axios.get.mockResolvedValue({
      data: [
        { name: { common: 'France' }, population: 67000000, capital: 'Paris', flags: { svg: 'https://flagcdn.com/fr.svg' } },
      ],
    });

    router.push('/country/France');
    await router.isReady();

    const wrapper = mount(CountryDetail, {
      global: {
        plugins: [router],
      },
    });

    await new Promise(setImmediate);

    expect(wrapper.find('h1').text()).toBe('France');
    const paragraphs = wrapper.findAll('p');
    expect(paragraphs[0].text()).toContain('Population: 67000000');
    expect(paragraphs[1].text()).toContain('Capital: Paris');
  });
});
