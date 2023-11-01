/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sockettestdos.resources;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Null;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
//import javax.annotation.Nullable;
//import org.jetbrains.annotations.Nullable;


/**
 *
 * @author truji
 */
@ServerEndpoint("/server")
public class serverSocket {
    private static final Map<String,Session> sessions= new ConcurrentHashMap<>();
    public serverSocket(){
        System.out.println("Visto serverSocket ");
    }
    @OnOpen
    public void onOpen(Session s){
        String newId= s.getId();
        sessions.put(newId, s);
        System.out.println("Inicio session:# " + s.getId());
    }
    @OnMessage
    public String onMessage(String m, Session s){
        /*Session RecuperaSession= (Session) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap()
                .get("websocketSession"); */
        //System.out.println("Session recuperada. " + RecuperaSession.getId());
        String IdUsuario= s.getId();
        System.out.println("Cli >>> " + IdUsuario + " <#> " + m);
        /*try{
           s.getBasicRemote().sendText("fffff");
        }catch(Exception e){
            System.out.println("error message ");
        }*/
        this.servirMessage(m, IdUsuario);
        return "Enviado desde onMessage. " + m;
    }
    @OnClose
    public String onClose(Session s){
        System.out.println("Usuario saliendo >>> " + s.getId());
        return "Cerro exitosamente ";
    }
    public void servirMessage(String message, String id){
        System.out.println(this.sessions.size());
        this.sessions.values()
                .stream()
                .filter(session-> !session.getId().equals(id))
                .forEach(session-> {
                   try{
                       session.getBasicRemote().sendText("Enviado desde servirMessage >>> " + message);
                       //session.getBasicRemote().setText("");
                   }catch(Exception e){
                       System.out.println("Error enviando message / ServirMessage ");
                   }
                });
    }
    @OnError
    public void onError(Throwable t){
        System.out.println("Error server socket");
    }
}
