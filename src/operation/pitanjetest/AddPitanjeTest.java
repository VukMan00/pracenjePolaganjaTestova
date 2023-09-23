/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.pitanjetest;

import domain.Pitanje;
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
public class AddPitanjeTest extends AbstractGenericOperation{

    private boolean flag = false;
    private String exceptionBrojPoena;
    private IValidator validator;
    
    @Override
    protected void preconditions(Object param) throws ValidatorException {
        PitanjeTest pt = (PitanjeTest)param;
        validator = new NumberValidator();
        try {
            validator.validate(Integer.toString(pt.getBrojPoena()));
        } catch (ValidatorException ex) {
            exceptionBrojPoena = ex.getMessage();
        }
        
        if(exceptionBrojPoena!=null){
            throw new ValidatorException(exceptionBrojPoena);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.add((PitanjeTest)param);
    }
    
    public boolean confirm(){
        return flag;
    }
    
}
