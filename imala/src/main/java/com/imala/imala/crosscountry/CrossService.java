package com.imala.imala.crosscountry;

import java.util.List;

// import com.imala.imala.crosscountry.CrossCountry.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class CrossService {
    
    @Autowired
    private final CrossRepository crossRepository;
    


   
    // public List<CrossCountry> getAllCross()
    // {
    //     return crossRepository.findAll();
    // }
  
   
    // public Double getTariff(){
    //     CrossCountry cc = crossRepository.findTariff("Addis Ababa", "Yabello", Type.ODA);

    //     return cc.getTariff();
    // }


    // @GetMapping("/cityJourneyList")
    public ModelAndView cityJourneyList() {
        ModelAndView model = new ModelAndView("bus");

        List<CrossCountry> crossCountryList = crossRepository.findAll();

        model.addObject("crossCountry", crossCountryList );

        return model;

    }

    // @GetMapping("/checkTariff")
    public ModelAndView departureList() {
        ModelAndView model = new ModelAndView("bus");
        SearchingAttribute searchingAttribute = new SearchingAttribute();
        List<CrossCountry> crossCountryList = crossRepository.findAll();
        model.addObject("crossCountry", crossCountryList);
        model.addObject("searchingAttribute", searchingAttribute);
        
        return model;

    }


    // @PostMapping("/searchTarrif")
    public ModelAndView showTariff(@ModelAttribute("searchingAttribute") SearchingAttribute searchingAttribute) {

        ModelAndView model = new ModelAndView("bus");

        CrossCountry crossCountry = crossRepository.findTariff(searchingAttribute.getDeparture(),
                searchingAttribute.getDestination(), searchingAttribute.getBus());
        if (crossCountry != null) {

            model.addObject("departure", crossCountry.getDeparture());

            model.addObject("destination",crossCountry.getDestination());

            model.addObject("bus",crossCountry.getBus());

            model.addObject("tariff", crossCountry.getTariff());

        } else {
            model.addObject("departure", searchingAttribute.getDeparture());

            model.addObject("destination", searchingAttribute.getDestination());

            model.addObject("bus", searchingAttribute.getBus());

            model.addObject("tariff", "No Match Found");

        }
        return model;

    }

}
