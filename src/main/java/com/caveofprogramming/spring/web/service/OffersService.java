/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caveofprogramming.spring.web.service;

import com.caveofprogramming.spring.web.dao.Offer;
import com.caveofprogramming.spring.web.dao.OffersDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Derek
 */
@Service( "offersService" )
public class OffersService {

    private OffersDAO offersDao;

    @Autowired
    public void setOffersDao( OffersDAO offersDao ) {
        this.offersDao = offersDao;
    }

    public List<Offer> getCurrent() {
        return offersDao.getOffers();
    }

    public void createOffer( Offer offer ) {
        offersDao.create( offer );
    }

    public void throwTestException() {
        offersDao.getOffer( 9999 );
    }
}
