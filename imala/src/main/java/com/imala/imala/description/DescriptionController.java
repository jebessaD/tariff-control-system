package com.imala.imala.description;

import javax.validation.Valid;

// import java.util.List;

// import com.imala.imala.description.SearchingAttribute;
// import com.imala.imala.description.Description;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
// import lombok.RequiredArgsConstructor;

@Controller
@AllArgsConstructor
public class DescriptionController {
    
    @Autowired
    private DescriptionService descriptionService;



    // @PostMapping("/placeOrder")
    // public Report placeOrder(@RequestBody SearchingAttribute reportConfig){

    //     return descriptionService.placeOrder(reportConfig);
    // }

    // @GetMapping("/findAllOrder")
    // public List<Report> findAllOrders(){

    //     return descriptionService.findAllOrders(); 
    // }



    @GetMapping("/checkReport")
    public ModelAndView reportList() {
        return descriptionService.reportList();
    }


    @PostMapping("/showReport")
    public ModelAndView showReport(@Valid @ModelAttribute("searchingAttribute") SearchingAttribute searchingAttribute,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("checkReport");
            return modelAndView;
        }
        else{
        return descriptionService.showReport(searchingAttribute);
        }
    }

    @GetMapping("/makeReport")
    public ModelAndView makeReport() {
        ModelAndView model = new ModelAndView("report");
        Description newdescription = new Description();
        model.addObject("newdescription", newdescription);
        return model;
    }


    @PostMapping("/saveReport")
    public String saveReport(@Valid @ModelAttribute("newdescription") Description newdescription,BindingResult result){
        if(result.hasErrors()){
            return "report";
        }
        else{
       return descriptionService.saveReport(newdescription);
        }
    }



}