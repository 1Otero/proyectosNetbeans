/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sockettestdos.resources.controllers;

import com.mycompany.sockettestdos.resources.ProductFacade;
import com.mycompany.sockettestdos.resources.models.Category;
import com.mycompany.sockettestdos.resources.models.Product;
import com.mycompany.sockettestdos.resources.services.ProductService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mycompany.sockettestdos.resources.models.Category_Products;
import com.mycompany.sockettestdos.resources.daos.CategoryDao;
/**
 *
 * @author truji
 */
@SessionScoped
@ManagedBean
public class InicioController {
    private String f= "ReLollll";
    /**
     * Creates a new instance of InicioController
     */
    public InicioController() {
        //ProductFacade p = new ProductFacade();
        CategoryDao cd;
        try {
            ProductService ps= new ProductService();
            Product p= new Product();
            p.setName("Hot Dog");
            p.setLastName("Ruso");
            cd= new CategoryDao();
            cd.instaciaFactory();
            Category c= cd.find();
            if(c==null){
            c= new Category();
            c.setTipo("Comida1");
            c.setDescription("Productos de AyB");
            /**/
            c.getlProduct().add(p);
            }
            System.out.println("category a ver " + c.getTipo());
            p.setCategory(c);
            
            Product pr= new Product();
            pr.setName("Perro caliente");
            pr.setLastName("Colombiano");
            c.getlProduct().add(pr);    
            pr.setCategory(c);
            /*c.setlProduct(p);
            p.setName("Perro caliente");
            p.setLastName("Colombiano");
            c.setlProduct(p);*/
            System.out.println("tamaño lista enviar " + c.getlProduct().size());
            Category_Products c_p= new Category_Products();
            c_p.setProduct(pr);
            c_p.setCategory(c);
            //pr.getCategoryProducts().add(c_p);
            //c.getCategoryProducts().add(c_p);
            p.getCategoryProducts().add(c_p);
            c.getCategoryProducts().add(c_p);
            c_p= new Category_Products();
            c_p.setProduct(p);
            c_p.setCategory(c);
            p.getCategoryProducts().add(c_p);
            c.getCategoryProducts().add(c_p);   
            System.out.println("datos category y products ");
            System.out.println(c_p.getCategory().getTipo() + " " + c_p.getProduct().getName() + " " + c_p.getProduct().getCategoryProducts().size() + " " + c_p.getCategory().getCategoryProducts().size());
            ps.guardarProductAndCategory(p, c);
            /*
            //p.instanceFactory();
            Product pr = new Product();
            pr.setName("Manzana");
            pr.setLastName("Verde");
            //p.create(pr);
            //System.out.println("Guardo.... ");
            p.instanceFactory();
            Product prod= p.find(3);
            System.out.println("data product: " + prod.getName() + " " + prod.getLastName());
            p.instanceFactory();
            prod.setLastName("Verde");
            p.edit(prod);
            //p.instanceFactory();
            //Product produ= p.find(8);
            //p.remove(produ); */
        } catch (Exception e) {
            System.out.println("no hay datos " + e);
        }
        System.out.println("inicio inicioController");
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }
    
}
