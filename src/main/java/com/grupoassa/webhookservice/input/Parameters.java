/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.input;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author mesolano
 */
public class Parameters {
    private String resource;
    //resource.original
    @JsonProperty("resource.original")
    private String resourceOriginal;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getResourceOriginal() {
        return resourceOriginal;
    }

    public void setResourceOriginal(String resourceOriginal) {
        this.resourceOriginal = resourceOriginal;
    }
}
