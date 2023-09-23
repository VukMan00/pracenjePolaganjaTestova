/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.pitanjetest;

import domain.PitanjeTest;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllPitanjeTest extends AbstractGenericOperation{

    private List<PitanjeTest> pitanjaTest;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        pitanjaTest = repository.getAll((PitanjeTest)param);
    }
    
    public List<PitanjeTest> getPitanjaTest(){
        return pitanjaTest;
    }
    
}
