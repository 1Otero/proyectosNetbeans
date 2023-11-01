/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sockettestdos.resources.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import com.mycompany.sockettestdos.resources.models.Category;
/**
 *
 * @author truji
 */
@Stateless
public class CategoryDao<T> {
    private Class<T> classEn;
    private Class<Category> ClassCategory;
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public CategoryDao(){
        System.out.println("Utilizando clcase dao ");
    }
    public void instaciaFactory(){
       //emf= Persistence.createEntityManagerFactory("serverDos"); 
       emf= Persistence.createEntityManagerFactory("serverUno");
       em= emf.createEntityManager();
    }
    public EntityManager getEntityManager(){
       return em;
    }
    public Category find(){
       Category c= em.find(Category.class, 1);
       return c;
    }
    public void create(Category c){
       c.getlProduct().stream().forEach(p -> System.out.println("Nombre producto " + p.getName() + " Categoria " + p.getCategory().getTipo()));
       em.getTransaction().begin();
       em.persist(c);
       em.getTransaction().commit();
       em.close();
    }
}
