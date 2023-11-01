/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author truji
 */
public class DB {
    
 private Connection cnn; 

 
 public Connection getConnection(){
   if(Objects.isNull(this.cnn)){
      instanceConnection();
   }
   return this.cnn;
 }
 
 public void instanceConnection(){
  try{
   Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
   this.cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
      System.out.println("Instancio");
   }catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e){
      System.out.println("Error sql connection: ".concat(e.toString()));
  };    
 }
 
}
