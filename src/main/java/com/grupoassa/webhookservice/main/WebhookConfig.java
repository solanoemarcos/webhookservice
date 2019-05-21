/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.main;

import com.grupoassa.webhookservice.entity.User;
import com.grupoassa.webhookservice.manager.WebhookEntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Marcos
 */
@Configuration
public class WebhookConfig {
    
    private static final Logger LOGGER = LogManager.getLogger(WebhookConfig.class);
    
    @Value("${postgre-db-user}")
    private String user;
    @Value("${postgre-db-password}")
    private String password;
    @Value("${postgre-db-url}")
    private String url;
    @Value("${postgre-db-param}")
    private String params;
    
    /**
     *
     * @return
     */
    @Bean
    public WebhookEntityManager webhookEntityManager(){
        LOGGER.debug(user);
        LOGGER.debug(password);
        LOGGER.debug(url);
        return new WebhookEntityManager(user,password,url,params);
    }
    
}
