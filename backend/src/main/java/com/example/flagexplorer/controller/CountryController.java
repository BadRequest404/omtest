package com.example.flagexplorer.controller;

import com.example.flagexplorer.model.Country;
import com.example.flagexplorer.model.CountryDetails;
import com.example.flagexplorer.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("/{name}")
    public ResponseEntity<CountryDetails> getCountryByName(@PathVariable String name) {
        return countryService.getCountryByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}