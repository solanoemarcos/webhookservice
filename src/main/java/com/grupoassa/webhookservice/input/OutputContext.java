/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.input;

/**
 *
 * @author mesolano
 */
public class OutputContext implements Comparable{
    private String name;
    private Integer lifespanCount;
    private Parameters parameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLifespanCount() {
        return lifespanCount;
    }

    public void setLifespanCount(Integer lifespanCount) {
        this.lifespanCount = lifespanCount;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public int compareTo(Object o) {
        int i = ((OutputContext)o).getLifespanCount().compareTo(this.lifespanCount);
        return i;
    }
    
    public String getRealName(){
        String[] arr = this.name.split("/");
        return arr[arr.length-1];
    }
}
