package com.imala.imala.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
public class WebConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeRequests()
            .antMatchers("/makeReport", "/checkReport").access("hasRole('USER')")
            .antMatchers("/", "/**").access("permitAll()")
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/makeReport")
            .usernameParameter("user")
            .passwordParameter("pwd")

            .and()
            .build();
}
    
}
