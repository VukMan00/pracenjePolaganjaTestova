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
public class DeletePitanje extends AbstractGenericOperation{

    private boolean flag = false;
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
        flag = repository.delete((Pitanje)param);
    }
    
    public boolean confirm(){
        return flag;
    }
    
}
