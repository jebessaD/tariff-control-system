package com.imala.imala.crosscountry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CrossController {
    
    @Autowired
    private final CrossService crossService;
    


    @GetMapping("api/v1/crosscountry")
    public List<CrossCountry> getAllNotes()
    {
        return crossService.getAllCross();
    }
  
    @GetMapping("api/v1/crosscountry/tariff")
    public Double getTariff(){
       

        return crossService.getTariff();
    }

}
