/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.pitanje;

import domain.Odgovor;
import domain.Pitanje;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;
import operation.odgovor.GetAllOdgovor;

/**
 *
 * @author Vuk
 */
public class GetAllPitanje extends AbstractGenericOperation{

    private List<Pitanje> pitanja;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        pitanja = repository.getAll((Pitanje)param);
        List<Odgovor> odgovori = repository.getAll(new Odgovor());
        for(Pitanje pitanje: pitanja){
            List<Odgovor> noviOdgovori = new ArrayList<>();
            for(Odgovor odgovor: odgovori){
                if(pitanje.getPitanjeId().equals(odgovor.getPitanje().getPitanjeId())){
                    noviOdgovori.add(odgovor);
                }
            }
        pitanje.setOdgovori(noviOdgovori);
        }
    }
    
    public List<Pitanje> getPitanja(){
        return pitanja;
    }
    
}
