package com.cognizant.spring_learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }
    
    @GetMapping("/countries{code}")
    public Country getCountry(@PathVariable String code) {
        System.out.println("START getCountry() for code: " + code);
        Country country = countryService.getCountry(code);
        System.out.println("END getCountry()");
        return country;
    }

}
