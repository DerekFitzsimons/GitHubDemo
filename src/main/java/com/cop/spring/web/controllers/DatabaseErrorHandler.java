/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author dfitzsimons
 */
@ControllerAdvice
public class DatabaseErrorHandler {

    @ExceptionHandler( DataAccessException.class )
    public String handleDatabaseException( DataAccessException ex ) {
        return "error";
    }
}
