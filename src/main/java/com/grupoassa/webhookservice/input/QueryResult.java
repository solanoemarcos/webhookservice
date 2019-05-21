/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.input;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author mesolano
 */
public class QueryResult {
    
    private String queryText;
    private Map<String,Object> parameters;
       //"resource": "usuario"
    private boolean allRequiredParamsPresent;
    private String fulfillmentText;
    private ArrayList<FulfillmentMessage> fulfillmentMessages;
    private ArrayList<OutputContexts> outputContexts;
    private Intent intent;
    private Integer intentDetectionConfidence;
    private String languageCode;

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public boolean isAllRequiredParamsPresent() {
        return allRequiredParamsPresent;
    }

    public void setAllRequiredParamsPresent(boolean allRequiredParamsPresent) {
        this.allRequiredParamsPresent = allRequiredParamsPresent;
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

    public ArrayList<OutputContexts> getOutputContexts() {
        return outputContexts;
    }

    public void setOutputContexts(ArrayList<OutputContexts> outputContexts) {
        this.outputContexts = outputContexts;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Integer getIntentDetectionConfidence() {
        return intentDetectionConfidence;
    }

    public void setIntentDetectionConfidence(Integer intentDetectionConfidence) {
        this.intentDetectionConfidence = intentDetectionConfidence;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

}
