/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sockettest.resources;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

/**
 *
 * @author truji
 */
/*@ManagedBean
@SessionScoped*/
@ServerEndpoint("/server")
public class serverTest {
    
    public serverTest() {
        System.out.println("relol serverTest");
    }
    @OnOpen
    public void onOpen(Session s){
        System.out.println("open socket");
    }
    @OnMessage
    public String onMessage(String m, Session s){
        System.out.println("message " + m);
        return "Mensaje enviado desde el servidor";
    }
    @OnClose
    public void onClose(Session s){
        System.out.println("close ");
    }
    @OnError
    public void onError(Throwable e){
        System.out.println("error ");
    }
}
