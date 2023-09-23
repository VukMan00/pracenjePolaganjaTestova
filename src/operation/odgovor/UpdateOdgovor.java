/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.odgovor;

import domain.Odgovor;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.ValidatorException;
import validator.components.OpstiValidator;
import validator.components.TextValidator;

/**
 *
 * @author Vuk
 */
public class UpdateOdgovor extends AbstractGenericOperation{

    private boolean flag=false;
    private IValidator validator;
    private String exceptionSadrzaj;
    
    @Override
    protected void preconditions(Object param) throws ValidatorException{
        Odgovor odgovor = (Odgovor)param;
        validator = new TextValidator();
        try {
            validator.validate(odgovor.getSadrzaj());
        } catch (ValidatorException ex) {
            exceptionSadrzaj = ex.getMessage();
        }
        
        if(exceptionSadrzaj!=null){
            throw new ValidatorException(exceptionSadrzaj);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.update((Odgovor)param);
    }
    
    public boolean confirm(){
        return flag;
    }
    
    public String getExceptionText(){
        return exceptionSadrzaj;
    }
    
}
