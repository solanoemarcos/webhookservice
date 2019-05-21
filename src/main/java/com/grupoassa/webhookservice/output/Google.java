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
public class Google {
    
    @JsonProperty
    private boolean expectUserResponse;
    @JsonProperty
    private RichResponse richResponse;
    
    public Google(){
        this.expectUserResponse = false;
        this.richResponse = new RichResponse();
    }

    public boolean isExpectUserResponse() {
        return expectUserResponse;
    }

    public void setExpectUserResponse(boolean expectUserResponse) {
        this.expectUserResponse = expectUserResponse;
    }

    public RichResponse getRichResponse() {
        return richResponse;
    }

    public void setRichResponse(RichResponse richResponse) {
        this.richResponse = richResponse;
    }

    public void addMessage(String msg){
        //RichResponse rr = new RichResponse();
        Item i = new Item();
        SimpleResponse sr = new SimpleResponse();
        i.setSimpleResponse(sr);
        sr.setTextToSpeech(msg);
        this.richResponse.addItem(i);
    }
}
