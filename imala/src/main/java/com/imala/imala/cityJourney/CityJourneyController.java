package com.imala.imala.cityJourney;

// import java.lang.System.Logger;
// import java.util.List;

// import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


 
@Controller
public class CityJourneyController {
    
    
    @Autowired
    CityJourneyService cityJourneyService;



    @GetMapping("/cityJourneyList")
    public ModelAndView cityJourneyList() {  
        return cityJourneyService.getCityJourneyList();
    }

    @GetMapping("/checkTariff")
    public ModelAndView departureList() {
        return cityJourneyService.getSearchingAttribute();
    }

    // @GetMapping("/checkTariff")
    // public ModelAndView checkTariff(){
    // ModelAndView model=new ModelAndView("check_Tariff");

    // // SearchingAttribute searchingAttribute= new SearchingAttribute() ;

    // // model.addObject("searchingAttribute",searchingAttribute);

    // return model;

    // }

    @PostMapping("/searchTarrif")
    public ModelAndView showTariff(@ModelAttribute("searchingAttribute") SearchingAttribute searchingAttribute) {

       return cityJourneyService.searchTariff(searchingAttribute);

    }

    

    @GetMapping("/addCityJourney")
    public ModelAndView addCityJourney() {
        ModelAndView model = new ModelAndView("add_city_journey_form");
        CityJourney cityJourney = new CityJourney();
        model.addObject("newCityJourney", cityJourney);
        return model;
    }

    @PostMapping("/saveCityJourney")
    public String saveCityJourney(@ModelAttribute("newCityJourney") CityJourney cityJourney) {
        return cityJourneyService.saveCityJourney(cityJourney);
        
    }

    @GetMapping("/deleteCityJourney")
    public String deleteCityJourney(@RequestParam Long cityJourneyId) {
        return deleteCityJourney(cityJourneyId);

    }

    @GetMapping("/updateCityJourney")
    public ModelAndView updateCityJourney(@RequestParam Long cityJourneyId) {

        return cityJourneyService.updateCityJourney(cityJourneyId);
    }

}
