/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.student;

import domain.Student;
import operation.AbstractGenericOperation;

/**
 *
 * @author Vuk
 */
public class GetOneStudent extends AbstractGenericOperation{

    private Student student;
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        student = (Student) repository.getOne((Student)param);
    }
    
    public Student getStudent(){
        return student;
    }
}
