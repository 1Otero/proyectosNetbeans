/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sockettestdos.resources.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author truji
 */
@Entity
@Table(name= "category_products")
public class Category_Products {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int IdCategoryProduct;
    @ManyToOne
    //@ManyToOne(cascade= CascadeType.ALL)
    //@ManyToOne(fetch= FetchType.LAZY)
    //@ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;
    @ManyToOne
    //@ManyToOne(cascade= CascadeType.ALL)
    //@ManyToOne(fetch= FetchType.LAZY)
    //@ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
}
