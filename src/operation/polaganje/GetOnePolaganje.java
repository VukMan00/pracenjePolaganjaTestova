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
public class GetOnePolaganje extends AbstractGenericOperation{

    private Polaganje polaganje;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        polaganje = (Polaganje) repository.getOne((Polaganje)param);
    }
    
    public Polaganje getPolaganje(){
        return polaganje;
    }
    
}
