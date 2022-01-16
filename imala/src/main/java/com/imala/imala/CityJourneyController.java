package com.imala.imala;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    private CityJourneyRepository cityJourneyRepository;



    
    @GetMapping("/cityJourneyList")
    public ModelAndView cityJourneyList(){
        ModelAndView model=new ModelAndView("city_journey_list");

        List<CityJourney> departureList=cityJourneyRepository.findByOrderByDepartureAsc();

        model.addObject("cityJourneys",departureList);

        return model;

    }



    @GetMapping("/checkTariff")
    public ModelAndView departureList(){
        ModelAndView model=new ModelAndView("check_Tariff");

        List<CityJourney> departureList=cityJourneyRepository.findByOrderByDepartureAsc();

        model.addObject("cityJourneys",departureList);

        return model;

    }




    @GetMapping("/checkTariff")
    public ModelAndView checkTariff(){
        ModelAndView model=new ModelAndView("check_Tariff");

        SearchingAttribute searchingAttribute= new SearchingAttribute() ;

        model.addObject("searchingAttribute",searchingAttribute);

        return model;

    }



    @PostMapping(path = "/searchTariff")
    public ModelAndView showTariff(@ModelAttribute SearchingAttribute searchingAttribute){

        ModelAndView model=new ModelAndView("check_Tariff");

        CityJourney cityJourney=cityJourneyRepository.searchTariff(searchingAttribute.getDeparture(),
         searchingAttribute.getDestination());

         if (cityJourney != null){
             model.addObject("departure",searchingAttribute.getDeparture());

             model.addObject("destination", searchingAttribute.getDestination());

             model.addObject("tariff",cityJourney.getTariff() );

         }
         else{
            model.addObject("departure",searchingAttribute.getDeparture());

            model.addObject("destination", searchingAttribute.getDestination());

            model.addObject("tariff","No Match Found" );

         }
         return model ;


    }





    @GetMapping("/addCityJourney")
    public ModelAndView addCityJourney(){

        ModelAndView model=new ModelAndView("add_city_journey_form");

        CityJourney cityJourney=new CityJourney();

        model.addObject("newCityJourney", cityJourney);

        return model;

    }




    @PostMapping("/saveCityJOurney")
    public String saveCityJourney(@ModelAttribute CityJourney cityJourney){

        cityJourneyRepository.save(cityJourney);

        return "redirect:/cityJourneyList";

    }




    @GetMapping("/deleteCityJourney")
    public String deleteCityJourney(@RequestParam Long cityJourneyId){
        cityJourneyRepository.deleteById(cityJourneyId);

        return "redirect:/cityJourneyList";

    }




    @GetMapping("/updateCityJourney")
    public ModelAndView updateCityJourney(@RequestParam Long cityJourneyId){

        ModelAndView model=new ModelAndView("add_city_journey_form");

        CityJourney cityJourney=cityJourneyRepository.findById(cityJourneyId).get();

        model.addObject("cityJourney", cityJourney);

        return model;

    }


    
}
