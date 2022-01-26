package com.imala.imala.description;

import java.util.HashMap;
import java.util.List;

import com.imala.imala.security.User;
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

    public ModelAndView editReport(){
        ModelAndView model=new ModelAndView("editReport");
        HashMap<String,Integer> reportMap=new HashMap<>();
        List<String> codes=descriptionRepository.findDistinctByCode();
        for (String code: codes) {
          reportMap.put(code, descriptionRepository.countByCode(code)) ;
        }
        model.addObject("reportMap", reportMap);
        model.addObject("codes",codes);
        return model;
        
    }
    public String deleteByCode(String code){
//    log.error("Delete report by code {}",code);
        List<Description> list=descriptionRepository.findByCode(code);
        for (Description description : list) {
            descriptionRepository.deleteById(description.getId());;
            
        }
        // descriptionRepository.deleteAllByCode(code);
        return "redirect:/editReport";
    }

}
