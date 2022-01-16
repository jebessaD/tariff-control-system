package com.imala.imala;

// import java.lang.System.Logger;
import java.util.List;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CityJourneyController {

    @Autowired
    private CityJourneyRepository cityJourneyRepository;

    @GetMapping("/cityJourneyList")
    public ModelAndView cityJourneyList() {
        ModelAndView model = new ModelAndView("city_journey_list");

        List<CityJourney> departureList = cityJourneyRepository.findByOrderByDepartureAsc();

        model.addObject("cityJourneys", departureList);

        return model;

    }

    @GetMapping("/checkTariff")
    public ModelAndView departureList() {
        ModelAndView model = new ModelAndView("check_tariff");

        SearchingAttribute searchingAttribute = new SearchingAttribute();

        List<CityJourney> departureList = cityJourneyRepository.findByOrderByDepartureAsc();

        model.addObject("cityJourneys", departureList);
        model.addObject("searchingAttribute", searchingAttribute);

        return model;

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

        ModelAndView model = new ModelAndView("check_Tariff");

        CityJourney cityJourney = cityJourneyRepository.search(searchingAttribute.getDeparture(),
                searchingAttribute.getDestination());
        log.error("{}", cityJourney);
        if (cityJourney != null) {
            model.addObject("departure", cityJourney.getDeparture());

            model.addObject("destination", cityJourney.getDestination());

            model.addObject("tariff", cityJourney.getTariff());

        } else {
            model.addObject("departure", searchingAttribute.getDeparture());

            model.addObject("destination", searchingAttribute.getDestination());

            model.addObject("tariff", "No Match Found");

        }
        return model;

    }

    @GetMapping("/index")
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("index");
        return model;

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
        
        cityJourneyRepository.save(cityJourney);
        return "redirect:/addCityJourney";
    }

    @GetMapping("/deleteCityJourney")
    public String deleteCityJourney(@RequestParam Long cityJourneyId) {
        cityJourneyRepository.deleteById(cityJourneyId);

        return "redirect:/cityJourneyList";

    }

    @GetMapping("/updateCityJourney")
    public ModelAndView updateCityJourney(@RequestParam Long cityJourneyId) {

        ModelAndView model = new ModelAndView("add_city_journey_form");

        CityJourney cityJourney = cityJourneyRepository.findById(cityJourneyId).get();

        model.addObject("cityJourney", cityJourney);

        return model;

    }

}
