package com.imala.imala.description;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.imala.imala.Security.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DescriptionController {

    @Autowired
    private DescriptionService descriptionService;

    @Autowired
    private DescriptionRepository descriptionRepository;

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
            BindingResult result,@AuthenticationPrincipal User user) {
        if (result.hasErrors()) {
            return "report";
        } else {
            
            return descriptionService.saveReport(newdescription,user);
        }
    }
   @GetMapping("/admin/editReport")
   public ModelAndView editReport(){
       return descriptionService.editReport();

   }
   @GetMapping("/deleteReportByCode")
   public String deleteReportByCode(@RequestParam("code") String code){
     return descriptionService.deleteByCode(code);
   }

   @GetMapping("/myReports")
   public ModelAndView myReports(@AuthenticationPrincipal User user){
      return descriptionService.myReports(user);
   }

   @GetMapping("/deleteReport")
   public String deleteReport(@RequestParam("reportId")Long id){
       return descriptionService.deleteById(id);
   }

   @GetMapping("/updateMyReport")
   public ModelAndView updateMyReport(@RequestParam("reportId")Long id){
       ModelAndView model=new ModelAndView("editMyReport");
       Description newDescription=descriptionRepository.findById(id).get();
       model.addObject("newdescription",newDescription );
       return model;
 
   }
 



}