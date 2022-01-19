package com.imala.imala.crosscountry;

import java.util.List;

// import com.imala.imala.crosscountry.CrossCountry.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class CrossService {
    
    @Autowired
    private final CrossRepository crossRepository;
    

    public ModelAndView crossCountryList() {
        ModelAndView model = new ModelAndView("bus");

        List<CrossCountry> crossCountryList = crossRepository.findAll();

        model.addObject("crossCountry", crossCountryList );

        return model;

    }

    public ModelAndView departureList() {
        ModelAndView model = new ModelAndView("bus");
        SearchingAttribute searchingAttribute = new SearchingAttribute();
        List<CrossCountry> crossCountryList = crossRepository.findAll();
        model.addObject("crossCountry", crossCountryList);
        model.addObject("searchingAttribute", searchingAttribute);
        
        return model;

    }



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

    public String saveCrossCountry(@ModelAttribute("newCrossCountry") CrossCountry crossCountry){
        crossRepository.save(crossCountry);
        return "redirect:/addCrossCountry";
    }



    public String deleteCrossCountry(@RequestParam Long crossCountry){
        crossRepository.deleteById(crossCountry);
        return "redirect:/crossCountryList";
    }




    public ModelAndView updateCrossCountry(@RequestParam Long crossCountryId){
        
        ModelAndView model = new ModelAndView("add_cross_country");

        CrossCountry crossCountry = crossRepository.findById(crossCountryId).get();

        model.addObject("newCrossCountry", crossCountry);

        return model;
    }

}
