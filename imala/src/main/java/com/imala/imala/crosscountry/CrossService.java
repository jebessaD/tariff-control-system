package com.imala.imala.crosscountry;

import java.util.List;

import com.imala.imala.crosscountry.CrossCountry.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class CrossService {
    
    @Autowired
    private final CrossRepository crossRepository;
    


   
    public List<CrossCountry> getAllCross()
    {
        return crossRepository.findAll();
    }
  
   
    public Double getTariff(){
        CrossCountry cc = crossRepository.findTariff("Addis Ababa", "Yabello", Type.ODA);

        return cc.getTariff();
    }

}
