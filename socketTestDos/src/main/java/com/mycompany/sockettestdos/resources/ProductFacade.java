/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sockettestdos.resources;

import com.mycompany.sockettestdos.resources.models.Product;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;

/**
 *
 * @author truji
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {

    //@PersistenceContext(unitName = "serverUno")
    //@PersistenceContext(unitName= "serverDos")
    
    private EntityManagerFactory efactory= Persistence.createEntityManagerFactory("serverUno");
    private EntityManager em;

    public void instanceFactory(){
       this.em= efactory.createEntityManager();
    }
    @Override
    public EntityManager getEntityManager() {
        System.out.println("Dato entity manager factory");
        System.out.println(em); 
        try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
}
