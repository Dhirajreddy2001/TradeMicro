package com.TradeMicro.TAM.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/api/trades/limit").authenticated()
					.requestMatchers("/api/trades/**").hasRole("ADMIN")
					.anyRequest().permitAll()
	      )
			.oauth2Login(oauth -> oauth
					.defaultSuccessUrl("/login-success",true))
			.logout(logout -> logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/logout-success")
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.deleteCookies("JSESSIONID"));
		return http.build();
	}

}
