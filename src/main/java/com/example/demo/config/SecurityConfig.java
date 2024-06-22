package com.example.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//AUTHENTICATION
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("A").password("B").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("M").password("{noop}N").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("X").password("{noop}Y").authorities("STUDENT");
	}
	
	
	//AUTHORIZATION
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		.antMatchers("/home").permitAll()
		
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/std").hasAuthority("STUDENT")
		
		
		
		.anyRequest().authenticated()
		
		.and()
		
		.formLogin()
		.defaultSuccessUrl("/welcome", true)
		
		.and()
		
		.logout()
		
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		.and()
		
		.exceptionHandling()
		
		.accessDeniedPage("/denied");
		
	}
}
