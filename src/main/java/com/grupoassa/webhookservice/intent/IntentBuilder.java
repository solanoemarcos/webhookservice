/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.intent;

import com.grupoassa.webhookservice.input.FulfillmentRequest;
import com.grupoassa.webhookservice.input.OutputContext;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Marcos
 */
public class IntentBuilder {
    
    /**
     *
     * @param freq
     * @return
     */
    static public Intent IntentCreate(FulfillmentRequest freq){
        Collections.sort((ArrayList<OutputContext>)freq.getQueryResult().getOutputContexts());
        return new ConsultaRecurso(0,"asd");
    }
    
}
