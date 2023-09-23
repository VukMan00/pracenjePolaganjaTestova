/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Pitanje;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class MyPitanjeTableModel extends AbstractTableModel{

    private List<Pitanje> pitanja;
    
    public MyPitanjeTableModel(List<Pitanje> pitanja){
        this.pitanja = pitanja;
    }
    @Override
    public int getRowCount() {
        return pitanja.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pitanje pitanje = pitanja.get(rowIndex);
        switch(columnIndex){
            case 0:
                return pitanje.getSadrzaj();
            case 1:
                return pitanje.getOdgovori();
        }
        
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"Sadrzaj","Odgovori"};
        return columnNames[column];
    }
    
    public List<Pitanje> getPitanja(){
        return pitanja;
    }
    
    public void remove(Pitanje pitanje){
        pitanja.remove(pitanje);
        fireTableDataChanged();
    }
   
}
