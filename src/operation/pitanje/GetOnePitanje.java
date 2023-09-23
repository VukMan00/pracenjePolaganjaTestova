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
public class GetOnePitanje extends AbstractGenericOperation{
    
    private Pitanje pitanje;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        pitanje = (Pitanje) repository.getOne((Pitanje)param);
    }
    
    public Pitanje getPitanje(){
        return pitanje;
    }
    
}
