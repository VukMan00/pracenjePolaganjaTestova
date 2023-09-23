/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.test;

import domain.Test;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class CreateTest extends AbstractGenericOperation{

    private Test test;
    private String exceptionNaziv;
    private String exceptionAutor;
    private String exceptionMaxBrojPoena;
    private String exception="";
    
    @Override
    protected void preconditions(Object param) throws Exception {
        Test t = (Test)param;
        if(t.getNaziv()==null){
            exceptionNaziv = "Naziv ne sme biti null!";
            exception = exceptionNaziv + "," + exception;
        }
        if(t.getAutor()==null){
            exceptionAutor = "Autor ne sme biti null!";
            exception = exceptionAutor + "," + exception;
        }
        if(t.getMaxBrojPoena()==null || t.getMaxBrojPoena()<0){
            exceptionMaxBrojPoena = "Broj poena ne sme biti null ili biti manje od 0";
            exception = exceptionMaxBrojPoena + "," + exception;
        }
        
        if(exceptionNaziv!=null || exceptionAutor!=null || exceptionMaxBrojPoena!=null){
            throw new Exception(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        test = (Test) repository.create((Test)param);
    }
    
    public Test getCreatedTest(){
        return test;
    }
    
}
