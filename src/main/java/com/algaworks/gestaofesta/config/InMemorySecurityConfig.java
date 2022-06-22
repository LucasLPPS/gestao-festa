package com.algaworks.gestaofesta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

// para que essa classe funcione, a dependência security do spring deve estar no pom.xml
@Configuration
public class InMemorySecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("pinheiro").password("{noop}1234").roles("USER")
			.and()
			.withUser("lucas").password("{noop}1234").roles("USER")
			.and()
			.withUser("daniel").password("{noop}1234").roles("USER");
	}
}
