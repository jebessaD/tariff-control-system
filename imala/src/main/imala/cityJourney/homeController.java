package com.imala.imala.cityJourney;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homeController {
    @GetMapping({"/index","/"})
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("index");
        return model;

    }
    @GetMapping("/error")
    public ModelAndView error(){
        ModelAndView model=new ModelAndView("error");
        return model;
    }
}
