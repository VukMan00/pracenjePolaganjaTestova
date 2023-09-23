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
public class BrojIndeksaValidator implements IValidator{

    @Override
    public void validate(String value) throws ValidatorException {
        if(value.isEmpty()){
            throw new ValidatorException("Polje je obavezno");
        }
           
        if(!value.matches("[1-9][0-9]{3}-[0-9]{4}")){
            throw new ValidatorException("Neispravan unos broja indeksa");
        }
        
    }
    
}
