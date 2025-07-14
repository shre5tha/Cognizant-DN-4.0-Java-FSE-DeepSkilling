package com.cognizant.spring_learn.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.model.Country;

import java.util.List;

@Service
public class CountryService {
	
	public List<Country> getAllCountries() {
	    return List.of(
	        new Country("IN", "India"),
	        new Country("US", "United States"),
	        new Country("JP", "Japan")
	    );
	}
	
	public Country getCountry(String code) {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        @SuppressWarnings("unchecked")
		List<Country> countries = (List<Country>) context.getBean("countryList");

        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
