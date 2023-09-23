/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handler;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import domain.User;
import domain.Student;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuk
 */
public class ProcessClientRequest extends Thread{

    Socket socket;
    Sender sender;
    Receiver receiver;
    Request request = null;
    Response response = null;
    User activeUser;
    
    public ProcessClientRequest(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while(true){
            try {
                request = (Request) receiver.receive();
                response = new Response();
                switch(request.getOperation()){
                    case LOGIN:
                        User user = (User) request.getArgument();
                        response.setResult(Controller.getInstance().login(user));
                        activeUser = user;
                        break;
                    case CREATE:
                        response.setResult(Controller.getInstance().create(request.getArgument()));
                        break;
                    case ADD:
                        response.setResult(Controller.getInstance().add(request.getArgument()));
                        break;
                    case UPDATE:
                        response.setResult(Controller.getInstance().update(request.getArgument()));
                        break;
                    case DELETE:
                        response.setResult(Controller.getInstance().delete(request.getArgument()));
                        break;
                    case GET:
                        response.setResult(Controller.getInstance().getAll(request.getArgument()));
                        break;
                    case GET_ONE:
                        response.setResult(Controller.getInstance().getOne(request.getArgument()));
                        break;
                }
                
            } catch (Exception ex) {
                if(response==null){
                    System.out.println("Nema odgovora!");
                }
                else{
                    System.out.println(ex.getMessage());
                    response.setException(ex);
                }
            }
            
           sender.send(response);
        }
    } 
    
    public User getUser() {
        return activeUser;
    }

    public Socket getSocket() {
        return socket;
    }
}
