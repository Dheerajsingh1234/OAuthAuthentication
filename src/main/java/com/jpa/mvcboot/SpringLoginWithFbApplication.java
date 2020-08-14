package com.jpa.mvcboot;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
public class SpringLoginWithFbApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SpringLoginWithFbApplication.class, args);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().antMatcher("/**").authorizeRequests().antMatchers("/", "/login**").permitAll()
				.anyRequest().authenticated().and().logout().logoutSuccessUrl("/").permitAll();
	}
	
	
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

}
