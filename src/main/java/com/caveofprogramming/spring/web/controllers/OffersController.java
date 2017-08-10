package com.caveofprogramming.spring.web.controllers;

import com.caveofprogramming.spring.web.dao.Offer;
import com.caveofprogramming.spring.web.service.OffersService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OffersController {

    private OffersService offersService;

    @Autowired
    public void setOffersService( OffersService offersService ) {
        this.offersService = offersService;
    }

    @RequestMapping("/offers")
    public String showOffers( Model model ) {

        List<Offer> offers = offersService.getCurrent();
        model.addAttribute( "offers", offers );

        return "offers";
    }

    @RequestMapping("/createOffer")
    public String createOffer( Model model ) {
        model.addAttribute( "offer", new Offer() );
        return "createOffer";
    }

    @RequestMapping(value = "/doCreate", method = RequestMethod.POST)
    public String doCreate( Model model, @Valid Offer offer, BindingResult result ) {
        String output;
        System.out.println( offer );
        if ( !result.hasErrors() ) {
            output = "offerCreated";
            
            offersService.createOffer(offer);
        } else {
            output = "createOffer";
        }

        return output;
    }

}
