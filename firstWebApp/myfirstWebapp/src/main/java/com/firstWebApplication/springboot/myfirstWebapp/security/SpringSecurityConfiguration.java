package com.firstWebApplication.springboot.myfirstWebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

	// InMemoryUserDetailsManager
	// InMemoryUserDetailsManager(UserDetails... users)
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {

		// 람다함수 - input과 output 모두 String
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		// passwordEncoder 함수는 어떤 input이든 내가 빈으로 설정한 passwordEncoder로 input을 인코딩한 다음,
		// 그 사용자의 세부정보 저장할

		UserDetails userDetails = User.builder()
				
				.passwordEncoder(passwordEncoder)
				.username("minjiki2")
				.password("random")
				.roles("USER", "ADMIN")
				.build();

		return new InMemoryUserDetailsManager(userDetails);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
