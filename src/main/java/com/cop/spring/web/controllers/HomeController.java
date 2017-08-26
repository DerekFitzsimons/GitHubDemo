/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.controllers;

import com.cop.spring.web.dao.Offer;
import com.cop.spring.web.service.OffersService;
import java.security.Principal;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Derek
 */
@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger( HomeController.class );

    @Autowired
    private OffersService offersService;

    @RequestMapping( "/" )
    public String showHome( Model model, Principal principal ) {
        List<Offer> offers = offersService.getCurrent();
        model.addAttribute( "offers", offers );

        boolean hasOffer = false;

        if( principal != null ) {
            hasOffer = offersService.hasOffer( principal.getName() );
        }

        model.addAttribute( "hasOffer", hasOffer );

        LOGGER.info( "Showing home page" );
        return "home";
    }

}
