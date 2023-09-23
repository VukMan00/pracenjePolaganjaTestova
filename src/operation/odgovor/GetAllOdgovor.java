/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.odgovor;

import domain.Odgovor;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllOdgovor extends AbstractGenericOperation{
    
    private List<Odgovor> odgovori;

    @Override
    protected void preconditions(Object param) throws Exception {
        //Nema ogranicenja
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        odgovori = repository.getAll((Odgovor) param);
    }
    
    public List<Odgovor> getOdgovori(){
        return odgovori;
    }
    
}
