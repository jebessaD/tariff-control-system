package com.imala.imala.crosscountry;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// import lombok.RequiredArgsConstructor;


@Controller
public class CrossController {
    
    @Autowired
    private CrossService crossService;
    


   
    @GetMapping("/crossCountryList")
    public ModelAndView CrossCountryList() {
       return crossService.crossCountryList();
    }

    @GetMapping("/checkBusTariff")
    public ModelAndView departureList() {
        
        return crossService.departureList();

    }

    @PostMapping("/searchBusTariff")
    public ModelAndView showTariff(@Valid @ModelAttribute("searchingAttribute") SearchingAttribute searchingAttribute,BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("bus");
            return modelAndView;
        }
        else{
        return crossService.showTariff(searchingAttribute);
        }
    }

    
    @GetMapping("/addCrossJourney")
    public ModelAndView addCrossCountry() {
        ModelAndView model = new ModelAndView("add_cross_country");
        CrossCountry CrossCountry = new CrossCountry();
        model.addObject("newCrossCountry", CrossCountry);
        return model;
    }

    @PostMapping("/saveCrossCountry")
    public String saveCrossCountry(@Valid @ModelAttribute("newCrossCountry") CrossCountry crossCountry,BindingResult result) {
        if(result.hasErrors()){
            return "add_cross_country";
        }
        else{
            return crossService.saveCrossCountry(crossCountry);
        }
    }

    @GetMapping("/deleteCrossJourney")
    public String deleteCrossCountry(@RequestParam Long crossJourneyId) {
        return crossService.deleteCrossCountry(crossJourneyId);

    }

    @GetMapping("/updateCrossJourney")
    public ModelAndView updateCrossCountry(@RequestParam Long crossJourneyId) {
        return crossService.updateCrossCountry(crossJourneyId);
    }






}
