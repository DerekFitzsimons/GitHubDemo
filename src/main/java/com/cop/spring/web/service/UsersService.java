/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.service;

import com.cop.spring.web.dao.User;
import com.cop.spring.web.dao.UsersDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 *
 * @author Derek
 */
@Service( "usersService" )
public class UsersService {

    private UsersDao usersDao;

    public boolean exists( String username ) {
        return usersDao.exists(username);
    }

    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }

    @Autowired
    public void setOffersDao( UsersDao offersDao ) {
        this.usersDao = offersDao;
    }
    
    
    public void create(User user){
        usersDao.create( user );
    }
}
