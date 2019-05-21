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
public class Button {
    
    @JsonProperty
    private String text;
    @JsonProperty
    private String postback;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPostback() {
        return postback;
    }

    public void setPostback(String postback) {
        this.postback = postback;
    }
}
