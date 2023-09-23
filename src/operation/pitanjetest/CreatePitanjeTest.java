/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.pitanjetest;

import domain.PitanjeTest;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.ValidatorException;
import validator.components.NumberValidator;

/**
 *
 * @author Vuk
 */
public class CreatePitanjeTest extends AbstractGenericOperation{

    private PitanjeTest pitanjeTest;
    private String exception;
    private IValidator validator;
    
    @Override
    protected void preconditions(Object param) throws ValidatorException{
        PitanjeTest pt = (PitanjeTest)param;
        validator = new NumberValidator();
        try {
            validator.validate(Integer.toString(pt.getBrojPoena()));
        } catch (ValidatorException ex) {
            exception = ex.getMessage();
        }
        
        if(exception!=null){
            throw new ValidatorException(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        pitanjeTest = (PitanjeTest) repository.create((PitanjeTest)param);
    }
    
    public PitanjeTest getCreatedPitanjeTest(){
        return pitanjeTest;
    }
    
}
