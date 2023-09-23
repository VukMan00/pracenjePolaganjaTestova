/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.student;

import domain.Student;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetAllStudents extends AbstractGenericOperation{

    private List<Student> studenti;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        studenti = repository.getAll((Student)param);
    }
    
    public List<Student> getStudents(){
        return studenti;
    }
    
}
