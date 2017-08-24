/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author dfitzsimons
 */
public class OfferRowMapper implements RowMapper<Offer> {

    @Override
    public Offer mapRow( ResultSet rs, int rowNum ) throws SQLException {
        User user = new User();
        user.setAuthority( rs.getString( "authority" ) );
        user.setEmail( rs.getString( "authority" ) );
        user.setEnabled( true );
        user.setName( rs.getString( "name" ) );
        user.setUsername( rs.getString( "username" ) );
        Offer offer = new Offer();

        offer.setId( rs.getInt( "id" ) );
        offer.setText( rs.getString( "text" ) );
        offer.setUser( user );
        return offer;
    }

}
