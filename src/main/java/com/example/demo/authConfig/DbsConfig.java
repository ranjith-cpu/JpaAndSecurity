package com.example.demo.authConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.servicey.UserDetailsServicey;

@Configuration
@EnableWebSecurity
public class DbsConfig  extends WebSecurityConfigurerAdapter{
    
    
    @Autowired
    UserDetailsServicey myDBSUserDetailService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.userDetailsService(myDBSUserDetailService);
        
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        
        http.httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers("/admin").hasAuthority("SuperMan")
        .antMatchers("/user").hasAnyAuthority("SuperMan","USER")
        .antMatchers("/home").permitAll()
        //.antMatchers("/register").permitAll()
        .and()
        .headers().frameOptions().disable()
        .and()
        .cors().disable()
        .formLogin();
        
    }
    
    
    
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}


