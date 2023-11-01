/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sockettestdos.resources.services;
import com.mycompany.sockettestdos.resources.ProductFacade;
import javax.persistence.EntityManager;
import com.mycompany.sockettestdos.resources.models.Product;
import com.mycompany.sockettestdos.resources.daos.CategoryDao;
import com.mycompany.sockettestdos.resources.models.Category;
/**
 *
 * @author truji
 */
public class ProductService {
    ProductFacade pf;
    public ProductService(){
      //pf= new ProductFacade();   
    }
    public String guardarProductAndCategory(Product p, Category c){
     CategoryDao cd= new CategoryDao();   
     pf= new ProductFacade();   
     //pf= new ProductFacade();
     pf.instanceFactory();
     //cd.instaciaFactory();
     EntityManager emProduct= pf.getEntityManager();   
     //EntityManager emCategoy= cd.getEntityManager();
     emProduct.getTransaction().begin();
     /*emProduct.persist(p);
     emCategoy.persist(c);*/
     pf.create(p);
     //cd.create(c);
     emProduct.getTransaction().commit();
     emProduct.close();
     System.out.println("Guarda datos");
     return "";
    }
}
