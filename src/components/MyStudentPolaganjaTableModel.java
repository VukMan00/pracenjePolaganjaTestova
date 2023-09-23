/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.RezultatPolaganja;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class MyStudentPolaganjaTableModel extends AbstractTableModel{

    List<RezultatPolaganja> rezultatiPolaganja;
    
    public MyStudentPolaganjaTableModel(List<RezultatPolaganja> rezultatiPolaganja){
        this.rezultatiPolaganja = rezultatiPolaganja;
    }
    
    @Override
    public int getRowCount() {
        return rezultatiPolaganja.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RezultatPolaganja rezultatPolaganja = rezultatiPolaganja.get(rowIndex);
        switch(columnIndex){
            case 0:
                return rezultatPolaganja.getPolaganje().getNaziv();
            case 1:
                return rezultatPolaganja.getPolaganje().getDatum();
            case 2:
                return rezultatPolaganja.getPolaganje().getNazivSale();
            case 3:
                return rezultatPolaganja.getPolaganje().getTest();
            case 4:
                return rezultatPolaganja.getBrojPoena();
            case 5:
                return rezultatPolaganja.getOcena();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"Naziv","Datum","Naziv sale","Test","Broj poena","Ocena"};
        return columnNames[column];
    }
    
    
    
    
    
}
