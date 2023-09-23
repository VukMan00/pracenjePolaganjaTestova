/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.test;

import domain.Test;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllTests extends AbstractGenericOperation{

    private List<Test> testovi;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        testovi = repository.getAll((Test)param);
    }
    
    public List<Test> getTests(){
        return testovi;
    }
    
}
