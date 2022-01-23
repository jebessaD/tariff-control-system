package com.imala.imala.vallidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.imala.imala.Security.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;


public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    @Autowired
    private UserRepository userRepository;



    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        boolean valid=userRepository.existsByUsername(username);
        return !valid ;
    }

    
}
