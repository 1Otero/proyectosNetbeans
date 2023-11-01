/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sockettestdos.resources.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author truji
 */
@Entity
@Table(name= "category")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="IdCategory")
    private int Id;
    @Column(name= "Tipo", unique = true)
    private String Tipo;
    @Column(name= "Description")
    private String Description;
    //@OneToMany(mappedBy= "product", cascade = CascadeType.PERSIST)
    //@OneToMany(mappedBy= "category", cascade= CascadeType.ALL)
    //@OneToMany(fetch= FetchType.LAZY)
    @OneToMany(mappedBy= "category", cascade= CascadeType.PERSIST)
    //@OneToMany
    private List<Product> lProduct= new ArrayList<>();
    //
    //@OneToMany
    @OneToMany(mappedBy= "category", cascade= CascadeType.ALL)
    private List<Category_Products> categoryProducts= new ArrayList<>();
            
    public Category(){} 
    public Category(String tipo, String description){
      this.Tipo= tipo;
      this.Description= description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public List<Product> getlProduct() {
        return lProduct;
    }

    /*public void setlProduct(List<Product> lProduct) {
        this.lProduct = lProduct;
    }*/
    public void setlProduct(Product Product) {
        this.lProduct.add(Product);
        Product.setCategory(this);
    }

    public List<Category_Products> getCategoryProducts() {
        return categoryProducts;
    }

    public void setCategoryProducts(List<Category_Products> categoryProducts) {
        this.categoryProducts = categoryProducts;
    }
        
}
