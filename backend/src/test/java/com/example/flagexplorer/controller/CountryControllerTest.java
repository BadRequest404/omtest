package com.example.flagexplorer.controller;

import com.example.flagexplorer.model.Country;
import com.example.flagexplorer.model.CountryDetails;
import com.example.flagexplorer.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Test
    void getAllCountries_shouldReturnCountriesList() throws Exception {
        when(countryService.getAllCountries()).thenReturn(Arrays.asList(
                new Country("United States", "us-flag-url"),
                new Country("Canada", "canada-flag-url")
        ));

        mockMvc.perform(get("/countries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("United States"))
                .andExpect(jsonPath("$[1].name").value("Canada"));
    }

    @Test
    void getCountryByName_withExistingName_shouldReturnCountryDetails() throws Exception {
        when(countryService.getCountryByName("United States")).thenReturn(
                Optional.of(new CountryDetails("United States", 331000000, "Washington D.C.", "us-flag-url"))
        );

        mockMvc.perform(get("/countries/United States")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("United States"))
                .andExpect(jsonPath("$.capital").value("Washington D.C."))
                .andExpect(jsonPath("$.population").value(331000000));
    }

    @Test
    void getCountryByName_withNonExistingName_shouldReturnNotFound() throws Exception {
        when(countryService.getCountryByName("NonExistingCountry")).thenReturn(Optional.empty());

        mockMvc.perform(get("/countries/NonExistingCountry")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}