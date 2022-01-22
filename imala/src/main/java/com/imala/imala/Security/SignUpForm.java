package com.imala.imala.Security;

import com.imala.imala.Security.User.Role;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class SignUpForm {

    private String username;
    private String password;
    private String fullName;
    private String email;
    private Role role;

    public User createUser(PasswordEncoder passwordEncoder) {
        return new User(username, fullName, passwordEncoder.encode(password), email,role);

    }

}
