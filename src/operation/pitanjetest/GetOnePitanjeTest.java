/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.pitanjetest;

import domain.PitanjeTest;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetOnePitanjeTest extends AbstractGenericOperation{

    private PitanjeTest pitanjeTest;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        pitanjeTest = (PitanjeTest) repository.getOne((PitanjeTest)param);
    }
    
    
    public PitanjeTest getPitanjeTest(){
        return pitanjeTest;
    }
}
