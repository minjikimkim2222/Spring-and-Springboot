package com.firstWebApplication.springboot.myfirstWebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	// InMemoryUserDetailsManager
	// InMemoryUserDetailsManager(UserDetails... users)
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		UserDetails userDetails1 = createNewUser("minjiki2", "random");
		UserDetails userDetails2 = createNewUser("Dev", "random2");

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {

		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

		UserDetails userDetails = User.builder()

				.passwordEncoder(passwordEncoder).username(username).password(password).roles("USER", "ADMIN").build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// All URLs are protected
		http.authorizeHttpRequests(
				// 모든 request에 대한 권한 보호 - 람다함수
				auth -> auth.anyRequest().authenticated());

		// A login form is shown for unauthorized requests
		http.formLogin(withDefaults());

		// CSRF disable
		http.csrf().disable();

		// Frames
		http.headers().frameOptions().disable();
		return http.build();

	}
}
