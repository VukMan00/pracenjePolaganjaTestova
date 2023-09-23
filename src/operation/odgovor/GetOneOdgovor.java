/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.odgovor;

import domain.Odgovor;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetOneOdgovor extends AbstractGenericOperation{

    private Odgovor odgovor;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        //Nema ogranicenja
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        odgovor = (Odgovor) repository.getOne((Odgovor)odgovor);
    }
    
    public Odgovor getOdgovor(){
        return odgovor;
    }
    
}
