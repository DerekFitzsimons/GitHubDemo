/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.controllers;

import com.cop.spring.web.dao.Offer;
import com.cop.spring.web.dao.User;
import com.cop.spring.web.service.UsersService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dfitzsimons
 */
@Controller
public class LoginController {

    private UsersService usersService;

    @Autowired
    public void setUsersService( UsersService usersService ) {
        this.usersService = usersService;
    }

    @RequestMapping( "/login" )
    public String showLogin() {
        return "login";
    }

    @RequestMapping( "/newAccount" )
    public String showCreateAccount( Model model ) {

        model.addAttribute( "user", new User() );
        return "createAccount";
    }

    @RequestMapping( value = "/createAccount", method = RequestMethod.POST )
    public String createAccount( @Valid User user, BindingResult result ) {
        String output;
        System.out.println( user );
        if( !result.hasErrors() ) {
            output = "accountCreated";
            user.setEnabled( true );
            user.setAuthority( "user");
            usersService.create( user );
        } else {
            output = "createAccount";
        }

        return output;
    }

}
