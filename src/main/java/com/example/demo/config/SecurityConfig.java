package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

		//authentication
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("A").password("B").authorities("ADMIN");
			auth.inMemoryAuthentication().withUser("M").password("N").authorities("EMPLOYEE");
			auth.inMemoryAuthentication().withUser("K").password("Y").authorities("STUDENT");
		}
		
		//authorization
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			
			.antMatchers("/home").permitAll()
			.antMatchers("/welcome").authenticated()
			
			.antMatchers("/admin").hasAuthority("ADMIN")
			.antMatchers("/emp").hasAuthority("EMPLOYEE")
			.antMatchers("/std").hasAuthority("STUDENT")
			
			.anyRequest().authenticated()
			
			//Login Form Details
			.and()
			.formLogin()
			.defaultSuccessUrl("/welcome", true)
			
			//Logout Details
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			
			// Exception Details
			.and()
			.exceptionHandling()
			.accessDeniedPage("/denied")
			;
		}
}