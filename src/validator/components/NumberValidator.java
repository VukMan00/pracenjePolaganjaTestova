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
public class NumberValidator implements IValidator{

    @Override
    public void validate(String value) throws ValidatorException {
        if(value == null || value.isEmpty()){
            throw new ValidatorException("Polje je obavezno!");
        }
        
        if(value.matches("[a-zA-Z]+")){
            throw new ValidatorException("Polje mora da sadrzi samo brojeve");
        }
        
        if(Integer.parseInt(value)<0){
            throw new ValidatorException("Broj poena ne moze da bude manji od 0");
        }
    }
    
    
}
