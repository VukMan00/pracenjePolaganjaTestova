/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.pitanje;

import domain.Pitanje;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.ValidatorException;
import validator.components.OpstiValidator;
import validator.components.TextValidator;

/**
 *
 * @author Vuk
 */
public class AddPitanje extends AbstractGenericOperation{

    private boolean flag = false;
    private String exceptionSadrzaj;
    private IValidator validator;
    
    @Override
    protected void preconditions(Object param) throws ValidatorException {
        Pitanje pitanje = (Pitanje)param;
        validator = new TextValidator();
        try {
            validator.validate(pitanje.getSadrzaj());
        } catch (ValidatorException ex) {
            exceptionSadrzaj = ex.getMessage();
        }
        
        if(exceptionSadrzaj!=null){
            throw new ValidatorException(exceptionSadrzaj);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.add((Pitanje)param);
    }
    
    public boolean confirm(){
        return flag;
    }
    
}
