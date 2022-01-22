package com.imala.imala.description;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
// import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Service
public class DescriptionService {

    // @Autowired
    // private ReportRepository reportRepository;

    @Autowired
    private DescriptionRepository descriptionRepository;


    // // @PostMapping("/placeOrder")
    // public Report placeOrder(@RequestBody SearchingAttribute reportConfig){

    //     return reportRepository.save(reportConfig.getReport());
    // }

    // // @GetMapping("/findAllOrder")
    // public List<Report> findAllOrders(){

    //     return reportRepository.findAll(); 
    // }



    public ModelAndView reportList() {
        ModelAndView model = new ModelAndView("checkReport");
        SearchingAttribute searchingAttribute = new SearchingAttribute();
        // List<Report> ReportList = reportRepository.findAll();
        // model.addObject("Report", ReportList);
        model.addObject("searchingAttribute", searchingAttribute);
        
        return model;

    }

    public ModelAndView showReport(SearchingAttribute searchingAttribute) {
        ModelAndView model = new ModelAndView("checkReport");
        List<Description> report = descriptionRepository.findByCode(searchingAttribute.getCode());
        int count = descriptionRepository.countReport(searchingAttribute.getCode());
        if (report != null) {
            model.addObject("reports", report);
            model.addObject("count", count);
        } 

        else {
            model.addObject("reports", report);
            model.addObject("count", "No related");
        } 
        return model;

    }
    public String saveReport(Description newdescription){
        // reportRepository.save(new Report(description.getCode()));
        descriptionRepository.save(newdescription);
        return "redirect:/";
    } 
}

