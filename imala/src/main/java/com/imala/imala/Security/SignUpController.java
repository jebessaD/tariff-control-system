package com.imala.imala.Security;

import com.imala.imala.Security.User.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    public UserRepository userRepository;

    @GetMapping
    public String showSignupForm() {
        return "signup";
    }

    @PostMapping
    public String signup(SignUpForm signUpForm) {
        signUpForm.setRole(Role.USER);
        userRepository.save(signUpForm.createUser(passwordEncoder));
        return "redirect:/login";

    }

}
