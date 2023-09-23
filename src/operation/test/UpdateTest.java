/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.test;

import domain.Test;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.ValidatorException;
import validator.components.NumberValidator;
import validator.components.OpstiValidator;
import validator.components.TextValidator;

/**
 *
 * @author Vuk
 */
public class UpdateTest extends AbstractGenericOperation{

    private boolean flag = false;
    private IValidator validator;
    private String exceptionNaziv;
    private String exceptionAutor;
    private String exceptionMaxBrojPoena;
    private String exception="";

    @Override
    protected void preconditions(Object param) throws ValidatorException{
        Test test = (Test)param;
        validator = new OpstiValidator();
        try {
            validator.validate(test.getNaziv());
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionNaziv = ex.getMessage();
            exception = exceptionNaziv + "," + exception;
        }
        validator = new TextValidator();
        try {
            validator.validate(test.getAutor());
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionAutor = ex.getMessage();
            exception = exceptionNaziv + "," + exception;
        }
        
        validator = new NumberValidator();
        try {
            validator.validate(Integer.toString(test.getMaxBrojPoena()));
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionMaxBrojPoena = ex.getMessage();
            exception=exceptionMaxBrojPoena + "," + exception;
        }
        
        if(exceptionNaziv!=null || exceptionAutor!=null || exceptionMaxBrojPoena!=null){
            throw new ValidatorException(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.update((Test)param);
    }
    
    public boolean confirm(){
        return flag;
    }
    
}
