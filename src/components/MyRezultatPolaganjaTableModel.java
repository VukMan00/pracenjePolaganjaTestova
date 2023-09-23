/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.RezultatPolaganja;
import form.dialog.polaganje.RezultatiPolaganja;
import form.util.FormView;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class MyRezultatPolaganjaTableModel extends AbstractTableModel{

    List<RezultatPolaganja> rezultatiPolaganja;
    
    public MyRezultatPolaganjaTableModel(List<RezultatPolaganja> rezultatiPolaganja){
        this.rezultatiPolaganja = rezultatiPolaganja;
    }
    
    @Override
    public int getRowCount() {
        return rezultatiPolaganja.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RezultatPolaganja rezultatPolaganja = rezultatiPolaganja.get(rowIndex);
        switch(columnIndex){
            case 0:
                return rezultatPolaganja.getStudent().getBrojIndeksa();
            case 1:
                return rezultatPolaganja.getStudent().getIme();
            case 2:
                return rezultatPolaganja.getStudent().getPrezime();
            case 3:
                return rezultatPolaganja.getBrojPoena();
            case 4:
                return rezultatPolaganja.getOcena();
        }
        
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columnNames = {"Broj indeksa","Ime","Prezime","Broj poena","Ocena"};
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==3 || columnIndex==4){
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        RezultatPolaganja rp = rezultatiPolaganja.get(rowIndex);
        
        switch(columnIndex){
            case 3:
                rp.setBrojPoena(Integer.parseInt((String) aValue));
                break;
            case 4:
                rp.setOcena(Integer.parseInt((String)aValue));
                break;
        }
    }
    
    public List<RezultatPolaganja> getRezultatPolaganja(){
        return rezultatiPolaganja;
    }
    
    
    
    
    
    
}
