package com.imala.imala.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null)
                return user;

            throw new UsernameNotFoundException("user Not found");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeRequests()
                .antMatchers("/makeReport","/saveReport").hasAnyRole("USER","TRAFFIC")
                .antMatchers("/checkReport", "/showReport").hasAnyRole("ADMIN","TRAFFIC")
                // .antMatchers("/profile").hasAnyRole("USER","TRAFFIC")
                // .antMatchers( "cityJourneyList", "/checkReport", "/showReport", "/crossCountryList").hasAnyRole("ADMIN,TRAFFIC")
                // .antMatchers("/signUp","/makeReport","/saveReport", "/", "/checkTariff", "/searchTarrif", "/index", "/login", "/checkBusTariff","/searchBusTariff")
                // .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .and()
                .build();
    }
}
