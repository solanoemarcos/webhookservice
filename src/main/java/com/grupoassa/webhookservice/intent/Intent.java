/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.intent;

import com.grupoassa.webhookservice.output.FulfillmentResponse;

/**
 *
 * @author Marcos
 */
public abstract class Intent{
    
    
    public abstract FulfillmentResponse Do();
    
}
