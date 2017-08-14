/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveofprogramming.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dfitzsimons
 */
@Controller
public class loginController {

    @RequestMapping( "/login" )
    public String showLogin() {
        return "login";
    }

}
