/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.*;
import domain.User;
import domain.Odgovor;
import domain.Pitanje;
import domain.PitanjeTest;
import domain.Polaganje;
import domain.RezultatPolaganja;
import domain.Student;
import domain.Test;
import form.dialog.odgovor.OdgovorForm;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import validator.ValidatorException;


/**
 *
 * @author Vuk
 */
public class Communication {
    Socket socket;
    Sender sender;
    Receiver receiver;
    Request request;
    Response response;
    private static Communication instance;
    
    private Communication() throws IOException{
        socket = new Socket("localhost",9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);   
    }
    
    public static Communication getInstance() throws IOException{
        if(instance==null){
            instance = new Communication();
        }
        
        return instance;
    }
    
    public Object logIn(String username,String password){
        try {
            User user = new User(username,password);
            request = new Request(Operation.LOGIN,user);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public List<RezultatPolaganja> getRezultatPolaganja(){
        try {
            request = new Request(Operation.GET,new RezultatPolaganja());
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<RezultatPolaganja>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Student createStudent(Student student) {
        try {
            request = new Request(Operation.CREATE,student);
            sender.send(request);
            response = (Response)receiver.receive();
            return (Student) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Object addRezultatPolaganja(RezultatPolaganja rp) {
        try {
            request = new Request(Operation.ADD, rp);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Object updateStudent(Student student) {
        try {
            request = new Request(Operation.UPDATE, student);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean deleteRezultatPolaganja(RezultatPolaganja rp) {
        try {
            request = new Request(Operation.DELETE, rp);
            sender.send(request);
            response = (Response) receiver.receive();
            return (boolean)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public List<Polaganje> getPolaganja() {
        try {
            request = new Request(Operation.GET, new Polaganje());
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Polaganje>) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Object updateRezultatPolaganja(RezultatPolaganja rp) {
        try {
            request = new Request(Operation.UPDATE, rp);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public List<Student> getStudents(){
        try {
            request = new Request(Operation.GET, new Student());
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Student>) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Test> getTests(){
        try {
            request = new Request(Operation.GET, new Test());
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Test>) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
        
        return null;
    }
    
    public Polaganje createPolaganje(Polaganje polaganje){
        try {
            request = new Request(Operation.CREATE, polaganje);
            sender.send(request);
            response = (Response) receiver.receive();
            return (Polaganje) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }

    public Object updatePolaganje(Polaganje polaganje) {
        try {
            request = new Request(Operation.UPDATE, polaganje);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean)response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
    }

    public boolean deleteStudent(Student student) {
        try {
            request = new Request(Operation.DELETE, student);
            sender.send(request);
            response = (Response) receiver.receive();
            return (boolean)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Object updateTest(Test test) {
        try {
            request = new Request(Operation.UPDATE, test);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean)response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Object addPitanjeTest(PitanjeTest pt) {
        try {
            request = new Request(Operation.ADD, pt);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean)response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public List<Pitanje> getPitanja(){
        try {
            request = new Request(Operation.GET, new Pitanje());
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Pitanje>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Odgovor> getOdgovore(){
        try {
            request = new Request(Operation.GET, new Odgovor());
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<Odgovor>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean deletePitanjeTest(PitanjeTest pt) {
        try {
            request = new Request(Operation.DELETE, pt);
            sender.send(request);
            response = (Response) receiver.receive();
            return (boolean) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Test createTest(Test test) {
        try {
            request = new Request(Operation.CREATE, test);
            sender.send(request);
            response = (Response) receiver.receive();
            return (Test) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean deletePitanje(Pitanje pitanje) {
        try {
            request = new Request(Operation.DELETE, pitanje);
            sender.send(request);
            response = (Response) receiver.receive();
            return (boolean) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Object updatePitanje(Pitanje pitanje) {
        try {
            request = new Request(Operation.UPDATE, pitanje);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean)response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Object updatePitanjeTest(PitanjeTest pt) {
        try {
            request = new Request(Operation.UPDATE, pt);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean deleteOdgovor(Odgovor odgovor) {
        try {
            request = new Request(Operation.DELETE, odgovor);
            sender.send(request);
            response = (Response) receiver.receive();
            return (boolean) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Pitanje createPitanje(Pitanje pitanje) {
        try {
            request = new Request(Operation.CREATE, pitanje);
            sender.send(request);
            response = (Response) receiver.receive();
            return (Pitanje) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public PitanjeTest getOnePitanjeTest(PitanjeTest pt){
        try {
            request = new Request(Operation.GET_ONE, pt);
            sender.send(request);
            response = (Response) receiver.receive();
            return (PitanjeTest)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Object updateOdgovor(Odgovor odgovor) {
        try {
            request = new Request(Operation.UPDATE, odgovor);
            sender.send(request);
            response = (Response) receiver.receive();
            if(response.getException()==null){
                return (boolean) response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Odgovor createOdgovor(Odgovor o) {
        try {
            request = new Request(Operation.CREATE, o);
            sender.send(request);
            response = (Response) receiver.receive();
            return (Odgovor)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public List<PitanjeTest> getPitanjaTest(){
        try {
            request = new Request(Operation.GET, new PitanjeTest());
            sender.send(request);
            response = (Response) receiver.receive();
            return (List<PitanjeTest>)response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean deleteTest(Test test) {
        try {
            request = new Request(Operation.DELETE, test);
            sender.send(request);
            response = (Response) receiver.receive();
            return (boolean) response.getResult();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Object addOdgovor(Odgovor odgovor) {
        try {
            request = new Request(Operation.ADD,odgovor);
            sender.send(request);
            response = (Response)receiver.receive();
            if(response.getException()==null){
                return (boolean)response.getResult();
            }
            else{
                return response.getException().getMessage();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
