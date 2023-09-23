/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.odgovor;

import domain.Odgovor;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class DeleteOdgovor extends AbstractGenericOperation{

    private boolean flag = false;
    private String exceptionSadrzaj;
    private String exceptionResenje;
    private String exception="";
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(((Odgovor)param).getSadrzaj()==null){
            exceptionSadrzaj = "Sadrzaj ne sme biti null!";
            exception = exceptionSadrzaj + "," + exception;
        }
        if(((Odgovor)param).getResenje()!=true && ((Odgovor)param).getResenje()!=false){
            exceptionResenje = "Resenje mora biti ili true ili false";
            exception = exceptionResenje + "," + exception;
        }
        
        if(exceptionResenje!=null || exceptionSadrzaj!=null){
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((Odgovor)param);
    }
    
    public boolean confirm(){
        return flag;
    }
    
}
