/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socketweb.resources.controller;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.websocket.Session;
/**
 *
 * @author truji
 */
@ServerEndpoint("/server")
public class Server {
    @OnOpen
    public void onOpen(Session s){
        System.out.println("new client: ".concat(s.getId()));   
    }
    @OnMessage
    public String onMessage(String m, Session s){   
        try{
           System.out.println("new message of client: ".concat(m));
           s.getBasicRemote().sendText("this is message of server!");
        }catch(Exception e){
            System.out.println("Error sended with getBasicRemote().sendText()");
           e.fillInStackTrace();
        }
        return m;
    }
    @OnClose
    public void onClose(Session s){
        System.out.println("Close session: ".concat(s.getId()));
    }
    @OnError
    public void onError(Throwable throwable){
        throwable.fillInStackTrace();
    }
}
