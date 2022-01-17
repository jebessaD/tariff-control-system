package com.imala.imala.crosscountry;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;


@Controller
public class CrossController {
    
    @Autowired
    private CrossService crossService;
    


   
    @GetMapping("/crossCountryList")
    public ModelAndView cityJourneyList() {
       return crossService.cityJourneyList();
    }

    @GetMapping("/checkBusTariff")
    public ModelAndView departureList() {
        
        return crossService.departureList();

    }

    @PostMapping("/searchBusTariff")
    public ModelAndView showTariff(@ModelAttribute("searchingAttribute") SearchingAttribute searchingAttribute) {

        return crossService.showTariff(searchingAttribute);

    }




}
