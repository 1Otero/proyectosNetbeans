/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.socketTest.controller;

import java.io.IOException;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 *
 * @author truji
 */
public class meSocket extends TextWebSocketHandler{
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage text){
        try{
         String payload= text.getPayload();
            System.out.println("sended: ".concat(payload));
         session.sendMessage(new TextMessage("Respuesta "+payload));    
        }catch(IOException e){
            System.out.println("error send message");
            System.out.println(e);
        }
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        System.out.println("New connection----> ".concat(session.getId()));
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus close){
      try{
          System.out.println("Connexion websocket closed".concat(session.getId() + " estado: " + close));
      }catch(Exception e){
          System.out.println("Error closed");
          System.out.println(e);
      } 
    }
    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable){
        System.out.println("Error conexion in websocket");     
        throwable.printStackTrace();
    }
}
