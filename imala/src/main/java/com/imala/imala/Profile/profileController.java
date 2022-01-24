package com.imala.imala.Profile;

import java.util.List;

import com.imala.imala.Security.User;
import com.imala.imala.Security.UserRepository;
import com.imala.imala.description.Description;
import com.imala.imala.description.DescriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class profileController {
    // ,@AuthenticationPrincipal User user
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DescriptionRepository descriptionRepository;

    @GetMapping("/profile")
    public ModelAndView showProfile(@AuthenticationPrincipal User user) {
        ModelAndView model = new ModelAndView("editProfile");
        List<Description> myreports = descriptionRepository.findByUser(user);
        EditProfile editProfile = new EditProfile();
        model.addObject("myreports", myreports);
        model.addObject("editProfileForm", editProfile);
        return model;
    }

    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute("editProfileForm") EditProfile editProfile,
            @AuthenticationPrincipal User user) {
        if (passwordEncoder.matches(editProfile.getOldPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(editProfile.getNewPassword()));
            userRepository.save(user);
        }
        return "redirect:/profile";
    }

    @PostMapping("/changeUsername")
    public String changeUsername(@ModelAttribute("editProfileForm") EditProfile editProfileForm,
            @AuthenticationPrincipal User user) {
        user.setUsername(editProfileForm.getUsername());
        userRepository.save(user);
        return "redirect:/profile";
    }

    @PostMapping("/deleteProfile")
    public String deleteProfile(@AuthenticationPrincipal User user) {
        userRepository.delete(user);
        return "redirect:/signup";
    }

    
}
