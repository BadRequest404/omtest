package com.example.flagexplorer.service;

import com.example.flagexplorer.model.Country;
import com.example.flagexplorer.model.CountryDetails;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> getAllCountries();
    Optional<CountryDetails> getCountryByName(String name);
}