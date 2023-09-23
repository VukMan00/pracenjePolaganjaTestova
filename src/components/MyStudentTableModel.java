/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import domain.Polaganje;
import domain.Student;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import session.LocalStorage;

/**
 *
 * @author Vuk
 */
public class MyStudentTableModel extends AbstractTableModel{
   
    List<Student> students;
    LocalStorage localStorage = LocalStorage.getInstance();

    public MyStudentTableModel() {
    }
    
    
    
    public MyStudentTableModel(List<Student> students){
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return student.getBrojIndeksa();
            case 1:
                return student.getIme();
            case 2:
                return student.getPrezime();
            case 3:
                return student.getPol();
            case 4:
                return student.getDatumRodjenja();
          
        }
        
        return "n/a";
    }
    
    @Override
    public String getColumnName(int column) {
        String[] columns = {"Broj indeksa", "Ime", "Prezime", "Pol", "Datum rodjenja"};
        return columns[column];
    }

    
    public List<Student> getStudents(){
        return students;
    }
    
    public void remove(Student student){
        students.remove(student);
        fireTableDataChanged();
    }
}
