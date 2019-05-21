/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.controller;

import com.grupoassa.webhookservice.entity.User;
import com.grupoassa.webhookservice.input.FulfillmentRequest;
import com.grupoassa.webhookservice.manager.WebhookEntityManager;
import com.grupoassa.webhookservice.output.FulfillmentResponse;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mesolano
 */
@RestController
public class WebhookController {
    
    private static final Logger LOGGER = LogManager.getLogger(WebhookController.class);
    
    @Autowired
    private WebhookEntityManager entManager;
    
    @RequestMapping(name="/action", method=POST)
    public FulfillmentResponse WebhookEntryPoint(@RequestBody FulfillmentRequest request) {
        
        Set<String> resource = request.getQueryResult().getParameters().keySet();
        FulfillmentResponse fs = new FulfillmentResponse();
        User u;
        u = entManager.select(User.class,0);
        LOGGER.info(u.toString());
        fs.addMessage("Su usuario es: "+ u.getEmailaddress());
        return fs;
    }
}
