package com.imala.imala.cityJourney;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityJourneyController {

    @Autowired
    CityJourneyService cityJourneyService;

    @GetMapping("/admin/cityJourneyList")
    public ModelAndView cityJourneyList() {
        return cityJourneyService.getCityJourneyList();
    }

    @GetMapping("/checkTariff")
    public ModelAndView departureList() {
        return cityJourneyService.getSearchingAttribute();
    }


    @PostMapping("/searchTarrif")
    public ModelAndView showTariff(@Valid @ModelAttribute("searchingAttribute") SearchingAttribute searchingAttribute,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("check_tariff");
            return modelAndView;
        } else {
            return cityJourneyService.searchTariff(searchingAttribute);
        }
    }

    @GetMapping("/admin/addCityJourney")
    public ModelAndView addCityJourney() {
        ModelAndView model = new ModelAndView("add_city_journey_form");
        CityJourney cityJourney = new CityJourney();
        model.addObject("newCityJourney", cityJourney);
        return model;
    }

    @PostMapping("/admin/saveCityJourney")
    public String saveCityJourney(@Valid @ModelAttribute("newCityJourney") CityJourney cityJourney,
            BindingResult bindingResult) {
        return cityJourneyService.saveJourney(cityJourney, bindingResult);

    }

    
    @GetMapping("/admin/deleteCityJourney")
    public String deleteCityJourney(@RequestParam Long cityJourneyId) {
        return cityJourneyService.deleteJourney(cityJourneyId);
    }

    @GetMapping("/admin/updateCityJourney")
    public ModelAndView updateCityJourney(@RequestParam Long cityJourneyId) {
        return cityJourneyService.updateJourney(cityJourneyId);
    }
}
