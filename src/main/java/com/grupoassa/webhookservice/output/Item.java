/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.output;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Marcos
 */
public class Item {
    
    @JsonProperty
    private SimpleResponse simpleResponse;
    
    public Item(){
        this.simpleResponse = new SimpleResponse();
    }

    public SimpleResponse getSimpleResponse() {
        return simpleResponse;
    }

    public void setSimpleResponse(SimpleResponse simpleResponse) {
        this.simpleResponse = simpleResponse;
    }
    
    
}
