/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.rezultatpolaganja;

import domain.RezultatPolaganja;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllRezultatPolaganja extends AbstractGenericOperation{

    private List<RezultatPolaganja> rezultatiPolaganja;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        rezultatiPolaganja = repository.getAll((RezultatPolaganja)param);
    }
    
    public List<RezultatPolaganja> getRezultatePolaganja(){
        return rezultatiPolaganja;
    }
    
}
