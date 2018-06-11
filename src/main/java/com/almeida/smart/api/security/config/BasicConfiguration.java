package com.almeida.smart.api.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class BasicConfiguration  extends WebSecurityConfigurerAdapter{
    
	public void configure ( WebSecurity web ) throws Exception {
		web.ignoring().anyRequest() ;

	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("user")
            .password("password")
            .roles("USER")
            .and()
          .withUser("admin")
            .password("admin")
            .roles("USER", "ADMIN");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();
    }

}
