/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Marcos
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
            .withUser("user").password("{noop}jueves").roles("USER")
            .and()
            .withUser("admin").password("{noop}ibm360").roles("USER", "ADMIN");

    }
    
    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            //HTTP Basic authentication
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/action").hasRole("ADMIN")
            .and()
            .csrf().disable()
            .formLogin().disable();
    }
}
