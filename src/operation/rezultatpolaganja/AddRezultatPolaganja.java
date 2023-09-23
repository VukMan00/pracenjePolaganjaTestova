/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.rezultatpolaganja;

import domain.PitanjeTest;
import domain.Polaganje;
import domain.RezultatPolaganja;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.ValidatorException;
import validator.components.BrojPoenaValidator;
import validator.components.NumberValidator;
import validator.components.OcenaValidator;

/**
 *
 * @author Vuk
 */
public class AddRezultatPolaganja extends AbstractGenericOperation{

    private boolean flag=false;
    private IValidator validator;
    private String exception="";
    private String exceptionBrojPoena;
    private String exceptionOcena;
    
    @Override
    protected void preconditions(Object param) throws ValidatorException{
        RezultatPolaganja rp = (RezultatPolaganja)param;
        Polaganje p = rp.getPolaganje();
        BrojPoenaValidator bpv = new BrojPoenaValidator();
        bpv.setMaxBrojPoena(p.getTest().getMaxBrojPoena());
        validator = bpv;
        try {
            validator.validate(Integer.toString(rp.getBrojPoena()));
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionBrojPoena = ex.getMessage();
            exception = exceptionBrojPoena + "," + exception;
        }
        
        validator = new OcenaValidator();
        try {
            validator.validate(Integer.toString(rp.getOcena()));
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionOcena = ex.getMessage();
            exception = exceptionOcena + "," + exception;
        }
        
        if(exceptionOcena!=null || exceptionBrojPoena!=null){
            throw new ValidatorException(exception);
        }
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.add((RezultatPolaganja)param);
    }
    
    
    public boolean confirm(){
        return flag;
    }
    
}
