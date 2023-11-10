package com.te.lmsp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	private final JwtAuthenticationFilter filter;
	private static final String[] WHITE_LIST_URL = {"/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"};
	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {    

			http
			.authorizeRequests(requests -> requests
	        .requestMatchers(WHITE_LIST_URL).permitAll());
	        http
		    .authorizeRequests(requests -> requests
	        .requestMatchers("/employee/requests","/employee/employee","/update-employee").hasAnyRole("EMPLOYEE","ADMIN"));
	        http
		    .authorizeRequests(requests -> requests
	        .requestMatchers(HttpMethod.POST,"/employee/updatepassword").hasAnyRole("EMPLOYEE", "ADMIN", "MENTOR"));
	        http
		    .authorizeRequests(requests -> requests
	        .requestMatchers("/employee/**","/admin/**").hasRole("ADMIN"));
	        http
		    .authorizeRequests(requests -> requests
	        .requestMatchers("/mentor/**").hasAnyRole("MENTOR","ADMIN"));	         
	        http
		    .authorizeRequests(requests -> requests
	        .requestMatchers("/auth/**").permitAll()
	        .anyRequest().authenticated());
	       
	    http.cors().disable();
	    http.csrf(csrf -> csrf.disable());
	    http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
}
