package com.imala.imala.description;

import java.util.HashMap;
import java.util.List;

import com.imala.imala.Security.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class DescriptionService {

    private DescriptionRepository descriptionRepository;

    public ModelAndView reportList() {
        ModelAndView model = new ModelAndView("checkReport");
        SearchingAttribute searchingAttribute = new SearchingAttribute();
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

    public String saveReport(Description newdescription, User user) {
        newdescription.setUser(user);
        descriptionRepository.save(newdescription);
        return "redirect:/";
    }
}
