/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.controller;

import com.grupoassa.webhookservice.entity.User;
import com.grupoassa.webhookservice.input.FulfillmentRequest;
import com.grupoassa.webhookservice.input.OutputContext;
import com.grupoassa.webhookservice.manager.WebhookDAO;
import com.grupoassa.webhookservice.output.FulfillmentResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mesolano
 */
@RestController
public class WebhookController {
    
    private static final Logger LOGGER = LogManager.getLogger(WebhookController.class);
    
    @Autowired
    protected WebhookDAO webhookDAO;
    
    @PostMapping("/action")
    public ModelAndView WebhookEntryPoint(ModelMap model, @RequestBody FulfillmentRequest request) {
        //Obtengo Parametros
        Map<String,String> mapaParametros = request.getQueryResult().getParameters();
        Set<String> paramNames = mapaParametros.keySet();
        paramNames.forEach((ps) -> {
            model.addAttribute(ps, mapaParametros.get(ps));
        });
        //Obtengo Intent Name
        ArrayList<OutputContext> intents = request.getQueryResult().getOutputContexts();
        Collections.sort(intents);
        String intentName = intents.get(0).getRealName();
        return new ModelAndView("redirect:/"+intentName, model);
    }
    
    
    @GetMapping("/consulta_recurso")
    public FulfillmentResponse ConsultaRecurso(ModelMap model, @RequestParam("resource") String resource){
        String selectResult = this.webhookDAO.selectNoKey(User.class, resource, 0);
        
        FulfillmentResponse fs = new FulfillmentResponse();
        fs.addMessage("Su " + resource +" es: "+ selectResult.trim());
        return fs;
    }
    
    @GetMapping("/turno")
    public FulfillmentResponse altaTurno(ModelMap model){
        //String selectResult = this.webhookDAO.selectNoKey(User.class, resource, 0);
        
        FulfillmentResponse fs = new FulfillmentResponse();
        fs.addMessage("Se ha generado el nuevo turno.");
        return fs;
    }
    
    
    @GetMapping("/cancelar")
    public FulfillmentResponse bajaTurno(ModelMap model, @RequestParam("resource") String resource){
        //String selectResult = this.webhookDAO.selectNoKey(User.class, resource, 0);
        
        FulfillmentResponse fs = new FulfillmentResponse();
        fs.addMessage("Su turno se ha cancelado.");
        return fs;
    }
    
    
    @GetMapping("/modificacion")
    public FulfillmentResponse modificaTurno(ModelMap model, @RequestParam("resource") String resource){
        //String selectResult = this.webhookDAO.selectNoKey(User.class, resource, 0);
        
        FulfillmentResponse fs = new FulfillmentResponse();
        fs.addMessage("Su turno se ha modificado.");
        return fs;
    }
}
