/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveofprogramming.spring.web.controllers.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.validator.routines.EmailValidator;


/**
 *
 * @author Derek
 */
public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {

    private int min;

    @Override
    public void initialize( ValidEmail constraintAnnotation ) {
        ConstraintValidator.super.initialize( constraintAnnotation );
        this.min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid( String email, ConstraintValidatorContext context ) {
        boolean output = true;
        EmailValidator validator = EmailValidator.getInstance(false);
        if(email.length()< min){
            output = false;
        }else if(!validator.isValid( email)){
            output =false;
            
        }
        return output;
    }

}
