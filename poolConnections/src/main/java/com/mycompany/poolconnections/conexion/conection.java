/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poolconnections.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author truji
 */
public class conection {
    Connection cnn=  null;
    public conection(){
    
    }
    public Connection defaultConn(){
        try{
            Class.forName("com.mysql.cj.Driver").newInstance();
            this.cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas?user=root;");
        }catch(SQLException e){
            System.out.println("error... conn" + e);
        }catch(ClassNotFoundException e){
            System.out.println("error conn" + e);
        }catch(InstantiationException e){
            System.out.println("error instanciando " + e);
        }catch(IllegalAccessException e){
            System.out.println("Access error " + e);
        }
        return cnn;
    }
    
}
