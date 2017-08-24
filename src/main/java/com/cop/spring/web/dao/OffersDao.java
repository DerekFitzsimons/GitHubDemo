package com.cop.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component( "offersDao" )
public class OffersDao {

    /**
     * Logger
     */
    private static final Logger LOGGER = Logger.getLogger( OffersDao.class.getName() );

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource( DataSource jdbc ) {
        LOGGER.info( "Setting datasource" );
        this.jdbc = new NamedParameterJdbcTemplate( jdbc );
    }

    @SuppressWarnings( "Convert2Lambda" )
    public List<Offer> getOffers() {
        List<Offer> output = jdbc.query( "select * from offers, users where offers.username= users.username",
                new RowMapper<Offer>() {

            @Override
            public Offer mapRow( ResultSet rs, int rowNum ) throws SQLException {

                User user = new User();
                user.setAuthority( rs.getString( "authority" ) );
                user.setEmail( rs.getString( "authority" ) );
                user.setEnabled( rs.getBoolean( "enabled" ) );
                user.setName( rs.getString( "name" ) );
                user.setUsername( rs.getString( "username" ) );

                Offer offer = new Offer();
                offer.setId( rs.getInt( "id" ) );
                offer.setText( rs.getString( "text" ) );
                offer.setUser( user );

                return offer;
            }

        } );

        if( output == null ) {
            output = new ArrayList<>();
        }
        LOGGER.info( "Getting offers" );
        return output;
    }

    public boolean update( Offer offer ) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource( offer );
        boolean output
                = jdbc.update( "update offers set text=:text where id=:id", params ) == 1;
        LOGGER.info( "Update offer" );
        return output;
    }

    public boolean create( Offer offer ) {

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource( offer );

        boolean output
                = jdbc.update( "insert into offers (username,text ) values (:username, :text)", params ) == 1;
        LOGGER.info( "Create offer" );
        return output;

    }

    @Transactional
    public int[] create( List<Offer> offers ) {

        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch( offers.toArray() );

        System.out.println( "Create offers" );
        return jdbc.
                batchUpdate( "insert into offers (username,text ) values (:username, :text)", params );
    }

    public boolean delete( int id ) {
        MapSqlParameterSource params = new MapSqlParameterSource( "id", id );

        return jdbc.update( "delete from offers where id=:id", params ) == 1;
    }

    @SuppressWarnings( "Convert2Lambda" )
    public Offer getOffer( int id ) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue( "id", id );
        Offer output;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append( "select * from offers, users " );
            sql.append( "where offers.username=users.username and users.enabled=true and id=:id" );
            output = jdbc.queryForObject( sql.toString(), params,
                    new RowMapper<Offer>() {

                @Override
                public Offer mapRow( ResultSet rs, int rowNum )
                        throws SQLException {
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

            } );
        } catch( EmptyResultDataAccessException ex ) {
            output = null;
        }
        return output;
    }

}
