/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.polaganje;

import domain.Polaganje;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllPolaganje extends AbstractGenericOperation{

    private List<Polaganje> polaganja;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        polaganja = repository.getAll((Polaganje)param);
    }
    
    public List<Polaganje> getPolaganje(){
        return polaganja;
    }
    
}
