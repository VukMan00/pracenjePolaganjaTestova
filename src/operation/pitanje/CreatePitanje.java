/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.pitanje;

import domain.Pitanje;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class CreatePitanje extends AbstractGenericOperation{

    private Pitanje pitanje;
    private String exception;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(((Pitanje)param).getSadrzaj()==null){
            exception = "Sadrzaj ne sme biti null!!" + " ";
        }
        
        if(exception!=null){
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        pitanje = (Pitanje) repository.create((Pitanje)param);
    }
    
    public Pitanje getCreatedPitanje(){
        return pitanje;
    }
    
}
