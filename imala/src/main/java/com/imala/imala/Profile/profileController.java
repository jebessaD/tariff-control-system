package com.imala.imala.Profile;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile")
public class profileController {
    // ,@AuthenticationPrincipal User user

    @GetMapping
    public ModelAndView showProfile(){
        ModelAndView model=new ModelAndView("editProfile");
        EditProfile editProfile=new EditProfile();
        model.addObject("editProfileForm", editProfile);
        return  model;
    }
    
}
