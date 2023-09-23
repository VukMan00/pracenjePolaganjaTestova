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
public class GetOneTest extends AbstractGenericOperation{

    private Test test;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        test = (Test) repository.getOne((Test)param);
    }
    
    public Test getTest(){
        return test;
    }
    
}
