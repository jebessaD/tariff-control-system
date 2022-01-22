package com.imala.imala.security;

import com.imala.imala.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@RequestMapping("/register")
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationController {
    
    @Autowired
    private UserRepository userRepo;

    
    private PasswordEncoder passwordEncoder;


    @GetMapping
    public String registerForm() {
        return "signup";
    }

    @PostMapping
    public String processRegistration(@RequestAttribute("form") RegistrationForm form) {
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
