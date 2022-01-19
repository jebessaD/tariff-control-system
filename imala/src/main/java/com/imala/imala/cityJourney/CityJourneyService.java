package com.imala.imala.cityJourney;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Service
public class CityJourneyService {

    @Autowired
    private CityJourneyRepository cityJourneyRepository;




    public ModelAndView getCityJourneyList(){
        ModelAndView model = new ModelAndView("city_journey_list");
        List<CityJourney> cityJourneyList = cityJourneyRepository.findByOrderByDepartureAsc();
        model.addObject("cityJourneys", cityJourneyList);
        return model;
    }


    public ModelAndView getSearchingAttribute(){
        ModelAndView model = new ModelAndView("check_tariff");
        SearchingAttribute searchingAttribute = new SearchingAttribute();
        List<CityJourney> distinctDeparture = cityJourneyRepository.findByOrderByDepartureAsc();
        List<CityJourney> distinctDestination = cityJourneyRepository.findByOrderByDestinationAsc();
        model.addObject("distnictDeparture",distinctDeparture );
        model.addObject("distnictDestination",distinctDestination);
        model.addObject("searchingAttribute", searchingAttribute);
        return model;
    }

    public ModelAndView searchTariff(@ModelAttribute("searchingAttribute") SearchingAttribute searchingAttribute){
        ModelAndView model = new ModelAndView("check_Tariff");

        CityJourney cityJourney = cityJourneyRepository.search(searchingAttribute.getDeparture(),
                searchingAttribute.getDestination());
     
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
     
    

    
    public String saveJourney(CityJourney cityJourney,BindingResult bindingResult){

        CityJourney redundancyCheck=cityJourneyRepository.search(cityJourney.getDeparture(),cityJourney.getDestination());
       if(bindingResult.hasErrors()){
           return "add_city_journey_form";
       }
       else{
        if (redundancyCheck==null) {
            cityJourneyRepository.save(cityJourney);
            return "redirect:/addCityJourney";
        }
        else{
            
            CityJourney newCityJourney=cityJourneyRepository.findById(redundancyCheck.getId()).get();
            newCityJourney.setTariff(cityJourney.getTariff());
            cityJourneyRepository.save(newCityJourney);
            return "redirect:/addCityJourney";
        }
       
    }
        
        
    }



    public String deleteJourney(Long cityJourneyId){
        cityJourneyRepository.deleteById(cityJourneyId);
        return "redirect:/cityJourneyList";
    }




    public ModelAndView updateJourney(Long cityJourneyId){
        
        ModelAndView model = new ModelAndView("add_city_journey_form");

        CityJourney cityJourney = cityJourneyRepository.findById(cityJourneyId).get();

        model.addObject("newCityJourney", cityJourney);

        return model;
    }
}
