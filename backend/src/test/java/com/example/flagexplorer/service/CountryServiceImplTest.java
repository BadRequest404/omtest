package com.example.flagexplorer.service;

import com.example.flagexplorer.model.Country;
import com.example.flagexplorer.model.CountryDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CountryServiceImplTest {

    private CountryService countryService;

    @BeforeEach
    void setUp() {
        countryService = new CountryServiceImpl();
    }

    @Test
    void getAllCountries_shouldReturnListOfCountries() {
        List<Country> countries = countryService.getAllCountries();

        assertNotNull(countries);
        assertFalse(countries.isEmpty());
    }

    @Test
    void getCountryByName_withExistingName_shouldReturnCountryDetails() {
        Optional<CountryDetails> result = countryService.getCountryByName("United States");

        assertTrue(result.isPresent());
        assertEquals("United States", result.get().getName());
        assertEquals("Washington D.C.", result.get().getCapital());
    }

    @Test
    void getCountryByName_withNonExistingName_shouldReturnEmptyOptional() {
        Optional<CountryDetails> result = countryService.getCountryByName("NonExistingCountry");

        assertFalse(result.isPresent());
    }
}