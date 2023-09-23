/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.login;

import domain.Student;
import domain.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import operation.AbstractGenericOperation;
import operation.student.GetAllStudents;
import validator.IValidator;
import validator.ValidatorException;
import validator.components.OpstiValidator;
import validator.components.TextValidator;

/**
 *
 * @author Vuk
 */
public class LogIn extends AbstractGenericOperation{
    
    private IValidator validator;
    private String exception = "";
    private String exceptionUsername;
    private String exceptionPassword;
    private Object login;

    @Override
    protected void preconditions(Object param) throws ValidatorException{
        User user = (User)param;
        validator = new OpstiValidator();
        try {
            validator.validate(user.getUsername());
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionUsername = ex.getMessage();
            exception = exceptionUsername + "," + exception;
        }
        try {
            validator.validate(user.getPassword());
            exception = " " + "," + exception;
        } catch (ValidatorException ex) {
            exceptionPassword = ex.getMessage();
            exception = exceptionPassword + "," + exception;
        }
        
        if(exceptionUsername!=null || exceptionPassword!=null){
            System.out.println(exception);
            throw new ValidatorException(exception);
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        System.out.println("DOSAO SAM DO OVDE");
        User user = (User)param;
        if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
            login = user;
        }
        else{
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            AbstractGenericOperation ago = new GetAllStudents();
            ago.execute(new Student());
            List<Student> students = ((GetAllStudents)ago).getStudents();

            for(Student student:students){
                String brojIndeksa = student.getBrojIndeksa();
                String[] indeksi = brojIndeksa.split("-");
                String godina = indeksi[0];
                System.out.println(godina);
                String broj = indeksi[1];
                System.out.println(broj);
                String ime = student.getIme().toLowerCase();
                String prezime = student.getPrezime().toLowerCase();

                String korisnickoImeStudenta = ime.charAt(0) + "" + prezime.charAt(0) + "" + godina + "" + broj;
                System.out.println(korisnickoImeStudenta);
                String sifraStudenta = brojIndeksa;

                if(korisnickoImeStudenta.equals(user.getUsername()) && sifraStudenta.equals(user.getPassword())){
                    login = student;
                    break;
                }
                else{
                    login = new Student();
                }
            }
        }        
    }
    
    public Object getLogin(){
        return login;
    }
    
}
