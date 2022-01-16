package com.imala.imala.crosscountry;

import com.imala.imala.crosscountry.CrossCountry.Type;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrossConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(CrossRepository crossRepository){
        return args -> {

            crossRepository.save(new CrossCountry("Addis Ababa", "Yabello", 500, Type.ODA));
			crossRepository.save(new CrossCountry("Addis Ababa", "Moyale", 650, Type.SELAM));
			crossRepository.save(new CrossCountry("Addis Ababa", "Bule Hora", 450, Type.GHION));
        };
    }
}
