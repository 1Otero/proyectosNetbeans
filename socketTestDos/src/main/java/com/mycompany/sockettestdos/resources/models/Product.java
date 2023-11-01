/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sockettestdos.resources.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Entity
@Table(name="product")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdProduct")
    //private Long Id;
    private int Id;
    @Column(name="Firts_names")
    private String name;
    @Column(name="Last_names")
    private String lastName;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@Column(name= "IdCategory")
    //@JoinColumn(name= "IdCategory")
    //@ManyToOne(cascade= CascadeType.PERSIST)
    //@ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne
    private Category category;
    //nuevo catego
    //@OneToMany
    @OneToMany(mappedBy = "Product", cascade= CascadeType.PERSIST, fetch = FetchType.LAZY)
    //@OneToMany
    private List<Category_Products> categoryProducts= new ArrayList<>();
    
    public Product(){
    
    }
    public Product(String name, String lastName, Category category){
      this.name= name;
      this.lastName= lastName;
      this.category= category;
    }
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        System.out.println("dato de categoria: " + category.getTipo());
        System.out.println("dato de categoria: " + category.getDescription());
    }

    public List<Category_Products> getCategoryProducts() {
        return categoryProducts;
    }

    public void setCategoryProducts(List<Category_Products> categoryProducts) {
        this.categoryProducts = categoryProducts;
    }
        
}
