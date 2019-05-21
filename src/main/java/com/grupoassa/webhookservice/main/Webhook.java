/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 *
 * @author mesolano
 */
@SpringBootApplication
@ComponentScan("com.grupoassa.webhookservice.controller")
@Import(WebhookConfig.class)
public class Webhook {
    
    public static void main(String[] args) {
        SpringApplication.run(Webhook.class, args);
    }
}
