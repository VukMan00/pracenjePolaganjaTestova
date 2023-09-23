/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.student;

import domain.Student;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class CreateStudent extends AbstractGenericOperation{

    private Student student;
    private String exceptionBrojIndeksa;
    private String exceptionIme;
    private String exceptionPrezime;
    private String exceptionDatumRodjenja;
    private String exceptionPol;
    private String exception="";
    
    @Override
    protected void preconditions(Object param) throws Exception {
        Student s = (Student)param;
        if(s.getBrojIndeksa()==null){
            exceptionBrojIndeksa = "Broj indeksa ne sme biti null!";
            exception = exceptionBrojIndeksa + "," + exception;
        }
        if(s.getIme()==null){
            exceptionIme = "Ime ne sme biti null!";
            exception = exceptionIme + "," + exception;
        }
        if(s.getPrezime()==null){
            exceptionPrezime = "Prezime ne sme biti null";
            exception = exceptionPrezime + "," + exception;
        }
        if(s.getDatumRodjenja()==null){
            exceptionDatumRodjenja = "Datum rodjenja ne sme biti null";
            exception = exceptionDatumRodjenja + "," + exception;
        }
        if(s.getPol()==null){
            exceptionPol = "Pol ne sme biti null";
            exception = exceptionPol + "," + exception;
        }
        
        if(exceptionBrojIndeksa!=null || exceptionIme!=null || exceptionPrezime!=null || exceptionDatumRodjenja!=null || exceptionPol!=null){
            throw new Exception(exception);
        } 
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        student = (Student) repository.create((Student)param);
    }
    
    public Student getStudent(){
        return student;
    }
    
}
