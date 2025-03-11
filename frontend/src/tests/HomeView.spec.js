import { mount } from '@vue/test-utils';
import HomeView from '@/views/HomeView.vue';
import axios from 'axios';
import { vi } from 'vitest';

// Mock API response
vi.mock('axios');

describe('HomeView.vue', () => {
  it('renders the title', () => {
    const wrapper = mount(HomeView);
    expect(wrapper.find('h1').text()).toBe('Country Flags');
  });

  it('fetches and displays country flags', async () => {
    axios.get.mockResolvedValue({
      data: [
        { name: { common: 'France' }, flags: { svg: 'https://flagcdn.com/fr.svg' } },
      ],
    });

    const wrapper = mount(HomeView);
    await new Promise(setImmediate);

    expect(wrapper.findAll('.flag-card').length).toBe(1);
    expect(wrapper.find('img').attributes('src')).toBe('https://flagcdn.com/fr.svg');
  });
});
