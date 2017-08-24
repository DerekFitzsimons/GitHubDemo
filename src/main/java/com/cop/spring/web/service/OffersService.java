/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.service;

import com.cop.spring.web.dao.Offer;
import com.cop.spring.web.dao.OffersDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 *
 * @author Derek
 */
@Service( "offersService" )
public class OffersService {

    private OffersDao offersDao;

    @Autowired
    public void setOffersDao( OffersDao offersDao ) {
        this.offersDao = offersDao;
    }

    public List<Offer> getCurrent() {
        return offersDao.getOffers();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public void createOffer( Offer offer ) {
        offersDao.create( offer );
    }
}
