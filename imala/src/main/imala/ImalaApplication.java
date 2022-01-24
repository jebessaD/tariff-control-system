package com.imala.imala;

import com.imala.imala.Security.User;
import com.imala.imala.Security.UserRepository;
import com.imala.imala.Security.User.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ImalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImalaApplication.class, args);
	}

	@Bean
	public CommandLineRunner adminCreater(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if ((userRepository.countByRole(Role.ADMIN) != 0)) {
				return;
			} else {
				userRepository.save(
						new User("admin", "admin", passwordEncoder.encode("abc123!"), "admin@gmail.com", Role.ADMIN));
				return;
			}

		};
	}

}
