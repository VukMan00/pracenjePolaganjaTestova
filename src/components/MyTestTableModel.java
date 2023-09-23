/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Test;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vuk
 */
public class MyTestTableModel extends AbstractTableModel{

    private List<Test> testovi;
    
    public MyTestTableModel(List<Test> testovi){
        this.testovi = testovi;
    }
    @Override
    public int getRowCount() {
        return testovi.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Test test = testovi.get(rowIndex);
        switch(columnIndex){
            case 0:
                return test.getNaziv();
            case 1:
                return test.getAutor();
            case 2:
                return test.getMaxBrojPoena();
            case 3:
                return test.getPitanja();
        }
        
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        String[] columns = {"Naziv","Autor","MaxBrojPoena","Pitanja"};
        return columns[column];
    }
    
    public List<Test> getTestovi(){
        return testovi;
    }
    
    public void remove(Test t){
        testovi.remove(t);
        fireTableDataChanged();
    }

   
    
    
    
    
}
