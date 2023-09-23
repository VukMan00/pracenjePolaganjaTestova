/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator.components;

import validator.IValidator;
import validator.ValidatorException;

/**
 *
 * @author Vuk
 */
public class BrojPoenaValidator implements IValidator{
    
    private int maxBrojPoenaTest;

    @Override
    public void validate(String value) throws ValidatorException {
        Integer brojPoena = Integer.parseInt(value);
        
        if(brojPoena<0){
            throw new ValidatorException("Broj poena ne sme biti manji od 0");
        }
        
        if(brojPoena>maxBrojPoenaTest){
            throw new ValidatorException("Student ne moze imati broj poena veci od maksimuma!!!");
        }
    }
    
    
    public void setMaxBrojPoena(Integer maxBrojPoena){
        this.maxBrojPoenaTest = maxBrojPoena;
    }
    
}
