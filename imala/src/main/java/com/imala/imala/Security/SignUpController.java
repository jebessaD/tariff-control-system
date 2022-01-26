package com.imala.imala.security;

import javax.validation.Valid;

import com.imala.imala.security.User.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class SignUpController {

    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    public UserRepository userRepository;

    @GetMapping("/signup")
    public ModelAndView showSignupForm() {
        ModelAndView model=new ModelAndView("signup");
        model.addObject("signUpForm", new SignUpForm());
        return model;
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute SignUpForm signUpForm,BindingResult result) {
        if(result.hasErrors()){
            return "signup";
        }
        else{
        signUpForm.setRole(Role.USER);
        userRepository.save(signUpForm.createUser(passwordEncoder));
        return "redirect:/login";
        }

    }

   
}
