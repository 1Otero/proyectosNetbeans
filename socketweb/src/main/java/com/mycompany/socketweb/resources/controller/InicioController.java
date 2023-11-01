/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.socketweb.resources.controller;

import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author truji
 */
@SessionScoped
public class InicioController implements Serializable{

    private String lol;
    /**
     * Creates a new instance of InicioController
     */
    public InicioController() {
    }
    public void setLol(String lol){this.lol= lol;}
    public String getLol(){return this.lol;}
}
