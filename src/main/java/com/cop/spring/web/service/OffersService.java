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

    @Secured( { "ROLE_USER", "ROLE_ADMIN" } )
    public void createOffer( Offer offer ) {
        offersDao.create( offer );
    }

    public void delete( int id ) {
        offersDao.delete( id );
    }

    public List<Offer> getCurrent() {
        return offersDao.getOffers();
    }

    public Offer getOffer( String username ) {
        Offer output = null;
        if( username != null && !username.isEmpty() ) {
            List<Offer> offers = offersDao.getOffers( username );
            if( !offers.isEmpty() ) {
                output = offers.get( 0 );
            }
        }
        return output;
    }

    @Autowired
    public void setOffersDao( OffersDao offersDao ) {
        this.offersDao = offersDao;
    }

    public boolean hasOffer( String name ) {
        boolean output = true;
        if( name == null || name.isEmpty() ) {
            output = false;
        } else {
            List<Offer> offers = offersDao.getOffers( name );
            if( offers.isEmpty() ) {
                output = false;
            }
        }
        return output;
    }

    public void saveOrUpdateOffer( Offer offer ) {
        if( offer.getId() != 0 ) {
            offersDao.update( offer );
        } else {
            offersDao.create( offer );
        }
    }

}
