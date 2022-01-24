package com.imala.imala.description;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DescriptionController {

    @Autowired
    private DescriptionService descriptionService;

    @GetMapping("/checkReport")
    public ModelAndView reportList() {
        return descriptionService.reportList();
    }

    @PostMapping("/showReport")
    public ModelAndView showReport(@Valid @ModelAttribute("searchingAttribute") SearchingAttribute searchingAttribute,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("checkReport");
            return modelAndView;
        } else {
            return descriptionService.showReport(searchingAttribute);
        }
    }

    @GetMapping("/makeReport")
    public ModelAndView makeReport() {
        ModelAndView model=new ModelAndView("report");
        Description newdescription = new Description();
       model.addObject("newdescription", newdescription);
        return model ;
    }

    @PostMapping("/saveReport")
    public String saveReport(@Valid @ModelAttribute("newdescription") Description newdescription,
            BindingResult result) {
        if (result.hasErrors()) {
            return "report";
        } else {
            return descriptionService.saveReport(newdescription);
        }
    }

}