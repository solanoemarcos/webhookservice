/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.output;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author mesolano
 */
public class FulfillmentMessage {
    
    @JsonProperty
    private Card card;
    
    public FulfillmentMessage(){
        this.card = new Card();
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
