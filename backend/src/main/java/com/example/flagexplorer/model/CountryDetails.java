package com.example.flagexplorer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDetails {
    private String name;
    private int population;
    private String capital;
    private String flag;
}