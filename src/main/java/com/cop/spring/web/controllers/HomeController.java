/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Derek
 */
@Controller
public class HomeController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger( HomeController.class);

    @RequestMapping( "/" )
    public String showHome( Model model ) {
        
        LOGGER.info( "Showing home page");
        return "home";
    }

}
