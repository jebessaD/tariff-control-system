package com.imala.imala.security;

import com.imala.imala.security.User.Role;

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
        User admin=new User("admin","admin",passwordEncoder.encode("abc123!"),"admin@gmail.com",Role.ADMIN);
        userRepository.save(admin);
        
    }
    
}
