package com.imala.imala.Security;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.imala.imala.Security.User.Role;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class SignUpForm {
    @NotBlank
    private String username;

    @Pattern(regexp = "(?=.*?[0-9])(?=.*?[!@#&()-[{}]:;',?/*~$^+=<>])(?=.*?[a-z]).{6,10}",message = "Password must contain digit,alphabet and special character and shuold be 6 to 10 cahraters long")
    private String password;

    @NotBlank
    private String fullName;
    
    @Email
    private String email;
   
    private Role role;

    public User createUser(PasswordEncoder passwordEncoder) {
        return new User(username, fullName, passwordEncoder.encode(password), email,role);

    }

}
