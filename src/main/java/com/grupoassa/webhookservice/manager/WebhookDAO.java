/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.webhookservice.manager;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Marcos
 */
public class WebhookDAO{

    private final EntityManagerFactory EMF ;
    private final EntityManager DATASOURCE ;
    
    private static final Logger LOGGER = LogManager.getLogger(WebhookDAO.class);
    
    /**
     * 
     * @param user
     * @param password
     * @param url
     * @param params
     */
    public WebhookDAO(String user, String password, String url, String params){
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.user", user);
        LOGGER.debug(user);
        properties.put("javax.persistence.jdbc.password", password);
        LOGGER.debug(password);
        properties.put("javax.persistence.jdbc.url", url + params);
        LOGGER.debug(url);
        EMF = Persistence.createEntityManagerFactory("com.grupoassa_webhook_persistance",properties);
        DATASOURCE = EMF.createEntityManager();
    }
    /**
     *
     * @param objToPersist
     * @return
     */
    public String persist(Object objToPersist) {
        try {
            DATASOURCE.getTransaction().begin();
            DATASOURCE.persist(objToPersist);
            DATASOURCE.getTransaction().commit();
            return "";
        } catch (PersistenceException e) {
            DATASOURCE.getTransaction().rollback();
            return e.getMessage();
        }
    }

    /**
     *
     * @param objToDelete
     * @return
     */
    public String delete(Object objToDelete) {
        try {
            DATASOURCE.getTransaction().begin();
            DATASOURCE.remove(objToDelete);
            DATASOURCE.getTransaction().commit();
            return "";
        } catch (PersistenceException e) {
            DATASOURCE.getTransaction().rollback();
            return e.getMessage();
        }
    }

    /**
     *
     * @param <T>
     * @param arg0
     * @return
     */
    /*
    public static <T> List<T> selectAll(Class<T> arg0) {
        Query findAllQuery = DATASOURCE.createQuery("from " + arg0.getSimpleName());
        List<T> list = findAllQuery.getResultList();
        return list;
    }
*/
    /**
     * 
     * @param <T>
     * @param arg0
     * @param filters
     * @return 
     */
    /*
    public static <T> List<T> selectOrderBy(Class<T> arg0, GenericFilter... filters){
        /* Create Criteria 
        CriteriaBuilder cb = DATASOURCE.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(arg0);
        Root<T> from = q.from(arg0);
        q.select(from);
        /* Iterate to generate an expression for each filter 
        List <Order> orderList = new ArrayList();
        for (GenericFilter filter : filters) {
            orderList.add(filter.getOrder(arg0,from,cb));
        }
        q.orderBy(orderList);
        /* Return the result 
        
        List<T> result = DATASOURCE.createQuery(q).getResultList();
        return result;
    }
*/

    /**
     *
     * @param <T>
     * @param arg0
     * @param id
     * @return
     */
    public <T> T select(Class<T> arg0, Integer id) {
        return DATASOURCE.find(arg0, id);
    }

    /**
     *
     * @param <T>
     * @param arg0
     * @param p
     * @param id
     * @return
     */
    
    /*
    public static <T extends GenericEntity> String updateById(Class<T> arg0, T p, Integer id) {
        try {
            T objectFound = DATASOURCE.find(arg0, id);
            if (objectFound != null) {
                DATASOURCE.getTransaction().begin();
                p.copyTo(objectFound);
                DATASOURCE.getTransaction().commit();
                return "";
            } else {
                return arg0.getSimpleName() + " not found.";
            }
        } catch (PersistenceException e) {
            return e.getMessage();
        }
    }
    */

    /*
    public static <T extends GenericEntity> String deletebyId(Class<T> arg0, Integer id) {
        T objectFound = DATASOURCE.find(arg0, id);
        if (objectFound != null) {
            return delete(objectFound);
        } else {
            return arg0.getSimpleName() + " not found.";
        }
    }
*/
    
        /**
     *
     * @param <T>
     * @param arg0
     * @param resource
     * @param id
     * @return
     */
    public <T> String selectNoKey(Class<T> arg0, String resource, Integer id) {
        //Create CriteriaBuilder
        CriteriaBuilder criteriaBuilder = DATASOURCE.getCriteriaBuilder();
        CriteriaQuery<Object> query = criteriaBuilder.createQuery();
        //Add From to query
        Root<T> from = query.from(arg0);
        query.select(from.get(resource));
        //Add where to query
        //ParameterExpression<Integer> p = criteriaBuilder.parameter(Integer.class);
        query.where(criteriaBuilder.equal(from.get("id"), 0));
        //Return a single result from query
        Object result = DATASOURCE.createQuery(query).getSingleResult();
        return result.toString();
    }
}