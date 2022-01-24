package com.imala.imala.Security;

import com.imala.imala.Security.User.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultAdmin implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.existsByRole(Role.ADMIN)){
            return;
        }
        else{
        User admin=new User("admin","admin",passwordEncoder.encode("abc123!"),"admin@gmail.com",Role.ADMIN);
        userRepository.save(admin);
        }
        
    }
    
}
