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
public class OcenaValidator implements IValidator{

    @Override
    public void validate(String value) throws ValidatorException {
        Integer ocena = Integer.parseInt(value);
        
        if(ocena<5 || ocena>10){
            throw new ValidatorException("Ocena mora biti u intervalu od 5 do 10");
        }
    }
    
}
