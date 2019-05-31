/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.intent;

import com.grupoassa.webhookservice.entity.User;
import com.grupoassa.webhookservice.output.FulfillmentResponse;

/**
 *
 * @author Marcos
 */
public class ConsultaRecurso extends Intent{

    private Integer id;
    private String resourceName;
    private final Class entityClass;

    public ConsultaRecurso(Integer id, String resourceName) {
        this.id = 0;
        this.resourceName = resourceName;
        //TODO validar la clase
        this.entityClass = User.class;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

//    @Override
//    public FulfillmentResponse Do() {
//        super.entManager.select(this.entityClass, id);
//        return null;
//    }

    @Override
    public FulfillmentResponse Do() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
