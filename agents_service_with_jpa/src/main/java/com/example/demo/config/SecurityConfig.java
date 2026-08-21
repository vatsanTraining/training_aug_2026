package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	
	
	@Bean
	BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	UserDetailsService  users(BCryptPasswordEncoder encoder) {
		
		UserDetails adminUser =User.builder()
				.username("india").password(encoder.encode("india"))
				  .roles("ADMIN").build();

		UserDetails guestUser =User.builder()
				.username("nepal").password(encoder.encode("nepal"))
				  .roles("GUEST").build();

		
		return new InMemoryUserDetailsManager(adminUser,guestUser);
	}
	
	@Bean
	SecurityFilterChain  filterChain(HttpSecurity http) throws Exception{
		
		
		http.csrf(cust -> cust.disable())
		.authorizeHttpRequests(auth -> 
		  auth.requestMatchers(HttpMethod.GET, 
				  "/api/v1/agents/**","/h2-console/**",
	                "/swagger-ui.html",
	                "/swagger-ui/**",
	                "/v3/api-docs/**")
		  .permitAll()
	      .requestMatchers("/api/v1/agents/**").hasRole("ADMIN")
		  .anyRequest().authenticated())
		  .httpBasic(Customizer.withDefaults());
		
		http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));
		
		return http.build();
	}
}


