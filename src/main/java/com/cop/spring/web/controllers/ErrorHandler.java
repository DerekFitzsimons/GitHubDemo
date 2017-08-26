/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author dfitzsimons
 */
@ControllerAdvice
public class ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class.getName());
    @ExceptionHandler( DataAccessException.class )
    public String handleDatabaseException( DataAccessException ex ) {
        LOGGER.info( ex.getMessage() );
        return "error";
    }

    @ExceptionHandler( AccessDeniedException.class )
    public String handleAccessException( AccessDeniedException ex ) {
        LOGGER.info( "Access Denied" );
        return "denied";
    }
}
