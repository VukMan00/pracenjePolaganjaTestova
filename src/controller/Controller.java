/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Odgovor;
import domain.Pitanje;
import domain.PitanjeTest;
import domain.Polaganje;
import domain.RezultatPolaganja;
import domain.Student;
import domain.Test;
import domain.User;
import operation.AbstractGenericOperation;
import operation.login.LogIn;
import operation.odgovor.AddOdgovor;
import operation.odgovor.CreateOdgovor;
import operation.odgovor.DeleteOdgovor;
import operation.odgovor.GetAllOdgovor;
import operation.odgovor.UpdateOdgovor;
import operation.pitanje.CreatePitanje;
import operation.pitanje.DeletePitanje;
import operation.pitanje.GetAllPitanje;
import operation.pitanje.UpdatePitanje;
import operation.pitanjetest.AddPitanjeTest;
import operation.pitanjetest.DeletePitanjeTest;
import operation.pitanjetest.GetAllPitanjeTest;
import operation.pitanjetest.GetOnePitanjeTest;
import operation.pitanjetest.UpdatePitanjeTest;
import operation.polaganje.CreatePolaganje;
import operation.polaganje.DeletePolaganje;
import operation.polaganje.GetAllPolaganje;
import operation.polaganje.UpdatePolaganje;
import operation.rezultatpolaganja.AddRezultatPolaganja;
import operation.rezultatpolaganja.DeleteRezultatPolaganja;
import operation.rezultatpolaganja.GetAllRezultatPolaganja;
import operation.rezultatpolaganja.UpdateRezultatPolaganja;
import operation.student.CreateStudent;
import operation.student.DeleteStudent;
import operation.student.GetAllStudents;
import operation.student.GetOneStudent;
import operation.student.UpdateStudent;
import operation.test.CreateTest;
import operation.test.DeleteTest;
import operation.test.GetAllTests;
import operation.test.GetOneTest;
import operation.test.UpdateTest;

/**
 *
 * @author Vuk
 */
public class Controller {    
    private static Controller controller;    
    private AbstractGenericOperation operation;
    
    public Controller() {
    }
    
    public static Controller getInstance(){
        if(controller == null){
            controller =  new Controller();
        }
        
        return controller;
    }
    
    public Object create(Object object) throws Exception{
        if(object instanceof Odgovor) return createOdgovor(object);
        if(object instanceof Pitanje) return createPitanje(object);
        if(object instanceof Test) return createTest(object);
        if(object instanceof Student) return createStudent(object);
        if(object instanceof Polaganje) return createPolaganje(object);
        
        return null;
    }
    
    public boolean update(Object object) throws Exception{
        if(object instanceof Odgovor) return updateOdgovor(object);
        if(object instanceof Pitanje) return updatePitanje(object);
        if(object instanceof Test) return updateTest(object);
        if(object instanceof Student) return updateStudent(object);
        if(object instanceof Polaganje) return updatePolaganje(object);
        if(object instanceof PitanjeTest) return updatePitanjeTest(object);
        if(object instanceof RezultatPolaganja) return updateRezultatPolaganja(object);
        
        return false;
    }
    
    public boolean add(Object object) throws Exception {
        if(object instanceof Odgovor) return addOdgovor(object);
        if(object instanceof PitanjeTest) return addPitanjeTest(object);
        if(object instanceof RezultatPolaganja) return addRezultatPolaganja(object);
        
        return false;
    }

    public boolean delete(Object object) throws Exception {
        if(object instanceof Odgovor) return deleteOdgovor(object);
        if(object instanceof Pitanje) return deletePitanje(object);
        if(object instanceof Test) return deleteTest(object);
        if(object instanceof Student) return deleteStudent(object);
        if(object instanceof Polaganje) return deletePolaganje(object);
        if(object instanceof PitanjeTest) return deletePitanjeTest(object);
        if(object instanceof RezultatPolaganja) return deleteRezultatPolaganja(object);
        
        return false;
    }

    public Object getAll(Object object) throws Exception {
        if(object instanceof Odgovor) return getOdgovori(object);
        if(object instanceof Pitanje) return getPitanja(object);
        if(object instanceof Test) return getTestovi(object);
        if(object instanceof Student) return getStudenti(object);
        if(object instanceof Polaganje) return getPolaganja(object);
        if(object instanceof PitanjeTest) return getPitanjaTest(object);
        if(object instanceof RezultatPolaganja) return getRezultatiPolaganja(object);
        
        return null;
    }

    public Object getOne(Object object) throws Exception {
        if(object instanceof PitanjeTest) return getPitanjeTest(object);
        if(object instanceof Student) return getOneStudent(object);
        if(object instanceof Test) return getTest(object);
        return null;
    }
    
    
    public Object login(User user) throws Exception{
        operation = new LogIn();
        operation.execute(user);
        return ((LogIn)operation).getLogin();
    }

    public Object createStudent(Object argument) throws Exception{
        operation = new CreateStudent();
        operation.execute(argument);
        return ((CreateStudent)operation).getStudent();
    }

    public Object createPitanje(Object argument) throws Exception {
        operation = new CreatePitanje();
        operation.execute(argument);
        return ((CreatePitanje)operation).getCreatedPitanje();
    }

    public Object createTest(Object argument) throws Exception {
        operation = new CreateTest();
        operation.execute(argument);
        return ((CreateTest)operation).getCreatedTest();
    }

    public Object createOdgovor(Object argument) throws Exception {
        operation = new CreateOdgovor();
        operation.execute(argument);
        return ((CreateOdgovor)operation).getCreatedOdgovor();
    }

    public Object createPolaganje(Object argument) throws Exception {
        operation = new CreatePolaganje();
        operation.execute(argument);
        return ((CreatePolaganje)operation).getCreatedPolaganje();
    }

    public boolean updateOdgovor(Object argument) throws Exception {
        operation = new UpdateOdgovor();
        operation.execute(argument);
        return ((UpdateOdgovor)operation).confirm();
    }

    public boolean updatePitanje(Object argument) throws Exception {
        operation = new UpdatePitanje();
        operation.execute(argument);
        return ((UpdatePitanje)operation).confirm();
    }

    public boolean updateTest(Object argument)throws Exception {
        operation = new UpdateTest();
        operation.execute(argument);
        return ((UpdateTest)operation).confirm();
    }

    public boolean updateStudent(Object argument) throws Exception {
        operation = new UpdateStudent();
        operation.execute(argument);
        return ((UpdateStudent)operation).confirm();
    }

    public boolean updatePolaganje(Object argument) throws Exception {
        operation = new UpdatePolaganje();
        operation.execute(argument);
        return ((UpdatePolaganje)operation).confirm();
    }

    public boolean updatePitanjeTest(Object argument) throws Exception {
        operation = new UpdatePitanjeTest();
        operation.execute(argument);
        return ((UpdatePitanjeTest)operation).confirm();
    }

    public boolean updateRezultatPolaganja(Object argument) throws Exception {
        operation = new UpdateRezultatPolaganja();
        operation.execute(argument);
        return ((UpdateRezultatPolaganja)operation).confirm();
    }

    public boolean addPitanjeTest(Object argument) throws Exception {
        operation = new AddPitanjeTest();
        operation.execute(argument);
        return ((AddPitanjeTest)operation).confirm();
    }

    public boolean addRezultatPolaganja(Object argument) throws Exception {
        operation = new AddRezultatPolaganja();
        operation.execute(argument);
        return ((AddRezultatPolaganja)operation).confirm();
    }

    public boolean deleteOdgovor(Object argument) throws Exception {
        operation = new DeleteOdgovor();
        operation.execute(argument);
        return ((DeleteOdgovor)operation).confirm();
    }

    public boolean deletePitanje(Object argument) throws Exception {
        operation = new DeletePitanje();
        operation.execute(argument);
        return ((DeletePitanje)operation).confirm();
    }

    public boolean deleteTest(Object argument) throws Exception {
        operation = new DeleteTest();
        operation.execute(argument);
        return ((DeleteTest)operation).confirm();
    }

    public boolean deleteStudent(Object argument) throws Exception {
        operation = new DeleteStudent();
        operation.execute(argument);
        return ((DeleteStudent)operation).confirm();
    }

    public boolean deletePolaganje(Object argument) throws Exception {
        operation = new DeletePolaganje();
        operation.execute(argument);
        return ((DeletePolaganje)operation).confirm();
    }

    public boolean deletePitanjeTest(Object argument) throws Exception {
        operation = new DeletePitanjeTest();
        operation.execute(argument);
        return ((DeletePitanjeTest)operation).confirm();
    }

    public boolean deleteRezultatPolaganja(Object argument) throws Exception {
        operation = new DeleteRezultatPolaganja();
        operation.execute(argument);
        return ((DeleteRezultatPolaganja)operation).confirm();
    }

    public Object getOdgovori(Object argument) throws Exception {
        operation = new GetAllOdgovor();
        operation.execute(argument);
        return ((GetAllOdgovor)operation).getOdgovori();
    }

    public Object getPitanja(Object argument) throws Exception {
        operation = new GetAllPitanje();
        operation.execute(argument);
        return ((GetAllPitanje)operation).getPitanja();
    }

    public Object getTestovi(Object argument) throws Exception {
        operation = new GetAllTests();
        operation.execute(argument);
        return ((GetAllTests)operation).getTests();
    }

    public Object getStudenti(Object argument) throws Exception {
        operation = new GetAllStudents();
        operation.execute(argument);
        return ((GetAllStudents)operation).getStudents();
    }

    public Object getPolaganja(Object argument) throws Exception {
        operation = new GetAllPolaganje();
        operation.execute(argument);
        return ((GetAllPolaganje)operation).getPolaganje();
    }

    public Object getPitanjaTest(Object argument) throws Exception {
        operation = new GetAllPitanjeTest();
        operation.execute(argument);
        return ((GetAllPitanjeTest)operation).getPitanjaTest();
    }

    public Object getRezultatiPolaganja(Object argument) throws Exception {
        operation = new GetAllRezultatPolaganja();
        operation.execute(argument);
        return ((GetAllRezultatPolaganja)operation).getRezultatePolaganja();
    }

    public Object getPitanjeTest(Object argument) throws Exception {
        operation = new GetOnePitanjeTest();
        operation.execute(argument);
        return ((GetOnePitanjeTest)operation).getPitanjeTest();
    }

    public boolean addOdgovor(Object argument) throws Exception {
        operation = new AddOdgovor();
        operation.execute(argument);
        return ((AddOdgovor)operation).confirm();
    }

    private Object getOneStudent(Object argument) throws Exception {
        operation = new GetOneStudent();
        operation.execute(argument);
        return ((GetOneStudent)operation).getStudent();
    }

    private Object getTest(Object argument) throws Exception {
        operation = new GetOneTest();
        operation.execute(argument);
        return ((GetOneTest)operation).getTest();
    }
    
    
}
