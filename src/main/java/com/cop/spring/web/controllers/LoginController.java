/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.controllers;

import com.cop.spring.web.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dfitzsimons
 */
@Controller
public class LoginController {

    @RequestMapping( "/login" )
    public String showLogin() {
        return "login";
    }
    
    @RequestMapping( "/newAccount" )
    public String showCreateAccount(Model model) {
        
        model.addAttribute( "user", new User());
        return "createAccount";
    }
    
    @RequestMapping( "/createAccount" )
    public String createAccount() {
        return "accountCreated";
    }

}
