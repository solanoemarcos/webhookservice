/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author mesolano
 */

@JsonInclude(Include.NON_EMPTY)
public class Payload {

    @JsonProperty
    private Google google;
    
    @JsonProperty
    private Facebook facebook;
    
    @JsonProperty
    private Slack slack;
    
    public Payload(){
        this.facebook = new Facebook();
        this.google = new Google();
        this.slack = new Slack();
    }

    public Google getGoogle() {
        return google;
    }

    public void setGoogle(Google google) {
        this.google = google;
    }

    public Facebook getFacebook() {
        return facebook;
    }

    public void setFacebook(Facebook facebook) {
        this.facebook = facebook;
    }

    public Slack getSlack() {
        return slack;
    }

    public void setSlack(Slack slack) {
        this.slack = slack;
    }
}
