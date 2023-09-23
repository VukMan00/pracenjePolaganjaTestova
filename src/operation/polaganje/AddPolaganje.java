/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.polaganje;

import domain.Polaganje;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.ValidatorException;
import validator.components.OpstiValidator;
import validator.components.TextValidator;

/**
 *
 * @author Vuk
 */
public class AddPolaganje extends AbstractGenericOperation{

    private boolean flag = false;
    private IValidator validator;
    private String exceptionNaziv;
    private String exceptionNazivSale;
    private String exceptionTest;
    private String exception="";
    
    @Override
    protected void preconditions(Object param) throws ValidatorException{
        Polaganje polaganje = (Polaganje)param;
        validator = new OpstiValidator();
        try {
            validator.validate(polaganje.getNaziv());
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionNaziv = ex.getMessage();
            exception = exceptionNaziv + "," + exception;
        }
        try {
            validator.validate(polaganje.getNazivSale());
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionNazivSale=ex.getMessage();
            exception = exceptionNazivSale+","+exception;
        }
        
        if(polaganje.getTest()==null){
            exceptionTest="Morate izabrati test!";
            exception = exceptionTest + "," + exception;
        }
        else{
            exception = " " + "," + exception;
        }
        
        if(exceptionNaziv!=null || exceptionNazivSale!=null || exceptionTest!=null){
            throw new ValidatorException(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.add((Polaganje)param);
    }
    
    public boolean confirm(){
        return flag;
    }
    
}
