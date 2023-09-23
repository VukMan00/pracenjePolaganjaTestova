/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Odgovor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class MyOdgovorTableModel extends AbstractTableModel{

    List<Odgovor> odgovori;
    
    public MyOdgovorTableModel(List<Odgovor> odgovori){
        this.odgovori = odgovori;
    }
    @Override
    public int getRowCount() {
        return odgovori.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Odgovor odgovor = odgovori.get(rowIndex);
        switch(columnIndex){
            case 0:
                return odgovor.getSadrzaj();
            case 1:
                return odgovor.getResenje();
        }
        
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"Sadrzaj","Resenje"};
        return columnNames[column];
    }
    
    public List<Odgovor> getOdgovori(){
        return odgovori;
    }
    
    public void remove(Odgovor odgovor){
        odgovori.remove(odgovor);
        fireTableDataChanged();
    }
    
}
