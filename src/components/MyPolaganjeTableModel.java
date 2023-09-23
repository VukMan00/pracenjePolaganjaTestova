/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Polaganje;
import domain.Student;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class MyPolaganjeTableModel extends AbstractTableModel{
    List<Polaganje> polaganja;
    
    public MyPolaganjeTableModel(List<Polaganje> polaganja){
        this.polaganja = polaganja;
    }

    @Override
    public int getRowCount() {
        return polaganja.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Polaganje polaganje = polaganja.get(rowIndex);
        switch(columnIndex){
            case 0:
                return polaganje.getNaziv();
            case 1:
                return polaganje.getDatum();
            case 2:
                return polaganje.getNazivSale();
            case 3:
                return polaganje.getStudenti();
            case 4:
                return polaganje.getTest();
        }
        
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columns = {"Naziv","Datum","Naziv sale","Studenti","Test"};
        return columns[column];
    }
    
    
    public List<Polaganje> getPolaganja(){
        return polaganja;
    }
    
    
    
    
}
