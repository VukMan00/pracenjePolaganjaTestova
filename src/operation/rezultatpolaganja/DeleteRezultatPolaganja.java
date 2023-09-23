/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.rezultatpolaganja;

import domain.RezultatPolaganja;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.ValidatorException;
import validator.components.NumberValidator;
import validator.components.OcenaValidator;

/**
 *
 * @author Vuk
 */
public class DeleteRezultatPolaganja extends AbstractGenericOperation{

    private boolean flag = false;
    private String exceptionBrojPoena;
    private String exceptionOcena;
    private String exception="";
    private IValidator validator;
    
    @Override
    protected void preconditions(Object param) throws ValidatorException {
        RezultatPolaganja rp = (RezultatPolaganja)param;
        
        validator = new NumberValidator();
        try {
            validator.validate(Integer.toString(rp.getBrojPoena()));
        } catch (ValidatorException ex) {
            exceptionBrojPoena = ex.getMessage();
            exception = exceptionBrojPoena + "," + exception;
        }
        
        validator = new OcenaValidator();
        try {
            validator.validate(Integer.toString(rp.getOcena()));
        } catch (ValidatorException ex) {
            exceptionOcena = ex.getMessage();
            exception = exceptionOcena + "," + exception;
        }
        
        if(exceptionBrojPoena!=null || exceptionOcena!=null){
            throw new ValidatorException(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((RezultatPolaganja)param);
    }
    
    public boolean confirm(){
        return flag;
    }
    
}
