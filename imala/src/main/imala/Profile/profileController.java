package com.imala.imala.Profile;

import java.util.List;

import javax.validation.Valid;

import com.imala.imala.Security.ChangePassword;
import com.imala.imala.Security.User;
import com.imala.imala.Security.UserRepository;
import com.imala.imala.description.Description;
import com.imala.imala.description.DescriptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class profileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DescriptionRepository descriptionRepository;

    @GetMapping("/profile")
    public ModelAndView showProfile(@AuthenticationPrincipal User user) {
        ModelAndView model = new ModelAndView("editProfile");
        model.addObject("user", user);
        return model;
    }

    @PostMapping("/editName")
    public String editName(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "editProfile";
        } else {
            userRepository.save(user);
            return "/editProfile";
        }
    }

    @PostMapping("/changePassword")
    public String changePassword(@Valid @ModelAttribute("editProfileForm") EditProfile editProfile,
            @AuthenticationPrincipal User user, BindingResult result) {

        if ((!result.hasErrors()) && passwordEncoder.matches(editProfile.getOldPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(editProfile.getNewPassword()));
            userRepository.save(user);
            return "redirect:/profile";
        } else {
            return "editProfile";
        }

    }

    @PostMapping("/changeUsername")
    public String changeUsername(@Valid @ModelAttribute EditUserName username,
            @AuthenticationPrincipal User user, BindingResult result) {
        if (result.hasErrors()) {
            return "editProfile";
        } else {
            user.setUsername(username.getUsername());
            userRepository.save(user);
            return "redirect:/profile";
        }
    }

    @PostMapping("/deleteProfile")
    public String deleteProfile(@AuthenticationPrincipal User user) {
        userRepository.delete(user);
        return "redirect:/signup";
    }

    @GetMapping("/changePassword")
    public ModelAndView changePassword() {
        ModelAndView model = new ModelAndView("changePassword");
        ChangePassword changePassword = new ChangePassword();
        model.addObject("changePassword", changePassword);
        return model;

    }

    @PostMapping("/changeMyPassword")
    public String saveChangedPassword(@Valid @ModelAttribute("changePassword") ChangePassword changePassword,
            @AuthenticationPrincipal User user, BindingResult result,Model model) {

        if (result.hasErrors()) {
            return "changePassword";
        }
        if (passwordEncoder.matches(changePassword.getOldPassword(), user.getPassword())) {

            user.setPassword(passwordEncoder.encode(changePassword.getNewPassword()));
            userRepository.save(user);
            return "redirect:/profile";
        } else {
            boolean invalid = true;
            model.addAttribute("invalid", invalid);
            return "changePassword";
        }

    }
}
