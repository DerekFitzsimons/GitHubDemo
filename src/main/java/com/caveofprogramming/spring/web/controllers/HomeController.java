/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveofprogramming.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Derek
 */
@Controller
public class HomeController {

    @RequestMapping( "/home" )
    public String showHome( Model model ) {
        return "home";
    }
}
