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

    @GetMapping("/about")
    public String about() {
        return "about";
       
    }

    @GetMapping("/help")
    public String help() {
        return "help";
       
    } 
}