package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration 
@EnableWebMvcSecurity 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
    @Autowired							
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    // DB Authentication
    	auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from role where username=?");
    }
    
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	
    	http
    	.authorizeRequests()
    	.antMatchers("/admin/*").access("hasRole('ADMIN')")
    	.antMatchers("/user/*").access("hasAnyRole('USER', 'ADMIN')")
    	.and()
	    	.formLogin()
	    	.loginPage("/login") 
	        .loginProcessingUrl("/Login")
	        .successHandler(myAuthenticationSuccessHandler())
	        .usernameParameter("username")
	        .passwordParameter("password")
	        .failureUrl("/401")
        .and()
			.logout().logoutSuccessUrl("/login")
			.logoutUrl("/Logout")
		.and()
            .exceptionHandling().accessDeniedPage("/403")
		.and()
			.csrf();
    	
    }
}