package com.example.flagexplorer.service;

import com.example.flagexplorer.model.Country;
import com.example.flagexplorer.model.CountryDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final List<Country> countries = new ArrayList<>();
    private final List<CountryDetails> countryDetails = new ArrayList<>();

    public CountryServiceImpl() {
        countries.add(new Country("United States", "us-flag-url"));
        countries.add(new Country("Canada", "canada-flag-url"));
        countries.add(new Country("Japan", "japan-flag-url"));

        countryDetails.add(new CountryDetails("United States", 331000000, "Washington D.C.", "us-flag-url"));
        countryDetails.add(new CountryDetails("Canada", 38000000, "Ottawa", "canada-flag-url"));
        countryDetails.add(new CountryDetails("Japan", 126000000, "Tokyo", "japan-flag-url"));
    }

    @Override
    public List<Country> getAllCountries() {
        return countries;
    }

    @Override
    public Optional<CountryDetails> getCountryByName(String name) {
        return countryDetails.stream()
                .filter(country -> country.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}