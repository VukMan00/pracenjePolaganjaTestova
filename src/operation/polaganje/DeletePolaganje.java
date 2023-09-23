/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.polaganje;

import domain.Polaganje;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class DeletePolaganje extends AbstractGenericOperation{

    private boolean flag = false;
    private String exception="";
    private String exceptionNaziv;
    private String exceptionNazivSale;
    private String exceptionDatum;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        Polaganje p = (Polaganje)param;
        if(p.getNaziv()==null){
            exceptionNaziv = "Naziv ne sme biti null!";
            exception = exceptionNaziv + "," + exception;
        }
        if(p.getNazivSale()==null){
            exceptionNaziv = "Naziv sale ne sme biti null!";
            exception = exceptionNazivSale + "," + exception;
        }
        if(p.getDatum()==null){
            exceptionDatum = "Datum ne sme biti nul!";
            exception = exceptionDatum + "," + exception;
        }
        
        if(exceptionNaziv!=null || exceptionDatum!=null || exceptionNazivSale!=null){
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete((Polaganje)param);
    }
    
    public boolean confirm(){
        return flag;
    }
    
}
