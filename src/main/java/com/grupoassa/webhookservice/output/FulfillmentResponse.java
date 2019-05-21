/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupoassa.webhookservice.input.FulfillmentRequest;
import java.util.ArrayList;

/**
 *
 * @author mesolano
 */
@JsonInclude(Include.NON_EMPTY)
public class FulfillmentResponse {
    /* 
     * fulfillmentText          String              Optional.
     * The text to be shown on the screen. This value is passed directly to QueryResult.fulfillment_text.
     */
    @JsonProperty
    private String fulfillmentText;
    /*
     * fulfillmentMessages[] 	Object (Message)    Optional.
     * The collection of rich messages to present to the user.
     * This value is passed directly to QueryResult.fulfillment_messages.
     */
    @JsonProperty
    private ArrayList<FulfillmentMessage> fulfillmentMessages;
    /*
     * source                   String              Optional.
     * This value is passed directly to QueryResult.webhook_source.
     */
    @JsonProperty
    private String source;
    /*
     * payload                  Object (Struct)     Optional.
     * This value is passed directly to QueryResult.webhook_payload.
     */
    @JsonProperty
    private Payload payload;
    /*
     * outputContexts[] 	Object (Context)    Optional.
     * The collection of output contexts. This value is passed directly to QueryResult.output_contexts.
     */
    
    /*
     * followupEventInput 	Object (EventInput) Optional.   
     * Makes the platform immediately invoke another sessions.detectIntent call internally with the specified event as input.
     */

    public FulfillmentResponse(){
         this.fulfillmentMessages = new ArrayList<>();
         this.payload = new Payload();
    }
    
    public FulfillmentResponse(FulfillmentRequest request){
        this.fulfillmentMessages = new ArrayList<>();
        this.payload = new Payload();
    }

    public void addMessage(String m){
        Google g = new Google();
        g.addMessage(m);
        this.payload.setGoogle(g);
    }

    public String getFulfillmentText() {
        return fulfillmentText;
    }

    public void setFulfillmentText(String fulfillmentText) {
        this.fulfillmentText = fulfillmentText;
    }

    public ArrayList<FulfillmentMessage> getFulfillmentMessages() {
        return fulfillmentMessages;
    }

    public void setFulfillmentMessages(ArrayList<FulfillmentMessage> fulfillmentMessages) {
        this.fulfillmentMessages = fulfillmentMessages;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
    
}
