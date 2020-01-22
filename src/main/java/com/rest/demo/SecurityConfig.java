package com.rest.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Application security configuration.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

   @Override
   protected void configure(HttpSecurity http) throws Exception
   {
	   http
       	   .authorizeRequests()
           .antMatchers("/**").permitAll()
           //.anyRequest().authenticated()
           .anyRequest().permitAll();
           
		  /* super.configure(http);
		   http.headers().frameOptions().disable();
		    http
		    .csrf().disable()
		    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
	        .authorizeRequests()
	        .antMatchers("/**").permitAll()//.hasAnyRole("BM","PM","ADMIN")
	        .anyRequest().permitAll();*/
   }
   
	
}