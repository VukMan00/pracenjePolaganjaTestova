/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.student;

import domain.Student;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.ValidatorException;
import validator.components.BrojIndeksaValidator;
import validator.components.OpstiValidator;
import validator.components.TextValidator;

/**
 *
 * @author Vuk
 */
public class AddStudent extends AbstractGenericOperation{

    private boolean flag = false;
    private IValidator validator;
    private String exceptionBrojIndeksa;
    private String exceptionIme;
    private String exceptionPrezime;
    private String exception="";
    
    @Override
    protected void preconditions(Object param) throws ValidatorException{
        Student student = (Student)param;
        validator = new BrojIndeksaValidator();
        try {
            validator.validate(student.getBrojIndeksa());
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionBrojIndeksa = ex.getMessage();
            exception = exceptionBrojIndeksa + "," + exception;
        }
        validator = new TextValidator();
        try {
            validator.validate(student.getIme());
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionIme = ex.getMessage();
            exception = exceptionIme + "," + exception;
        }
        try {
            validator.validate(student.getPrezime());
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionPrezime = ex.getMessage();
            exception = exceptionPrezime + "," + exception;
        }
        
        if(exceptionBrojIndeksa!=null || exceptionIme!=null || exceptionPrezime!=null){
            throw new ValidatorException(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.add((Student)param);
    }
    
    
    public boolean confirm(){
        return flag;
    }
    
    
}
