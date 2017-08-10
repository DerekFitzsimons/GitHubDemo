package com.caveofprogramming.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDAO {

    /**
     * Logger
     */
    private static final Logger LOGGER = Logger.getLogger( OffersDAO.class.getName() );
            
    private NamedParameterJdbcTemplate jdbc;   
    
    @Autowired
    public void setDataSource( DataSource jdbc ) {
        LOGGER.info( "Setting datasource");
        this.jdbc = new NamedParameterJdbcTemplate( jdbc );
    }

    @SuppressWarnings("Convert2Lambda")
    public List<Offer> getOffers() {
        List<Offer> output = jdbc.query( "select * from OFFERS", new RowMapper<Offer>() {

            @Override
            public Offer mapRow( ResultSet rs, int rowNum ) throws SQLException {
                Offer offer = new Offer();

                offer.setId( rs.getInt( "id" ) );
                offer.setName( rs.getString( "name" ) );
                offer.setText( rs.getString( "text" ) );
                offer.setEmail( rs.getString( "email" ) );

                return offer;
            }

        } );
        
        LOGGER.info( "Getting offers");
        return output;
    }

    public boolean update( Offer offer ) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource( offer );
        boolean output = jdbc.update( "update OFFERS set name=:name, text=:text, email=:email where id=:id", params ) == 1;
        LOGGER.info( "Update offer" );
        return output;
    }

    public boolean create( Offer offer ) {

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource( offer );

        boolean output =jdbc.update( "insert into OFFERS (name, text, email) values (:name, :text, :email)", params ) == 1;
        LOGGER.info( "Create offer");
        return output;
        
    }

    @Transactional
    public int[] create( List<Offer> offers ) {

        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch( offers.toArray() );

        System.out.println( "Create offers");
        return jdbc.batchUpdate( "insert into OFFERS (id, name, text, email) values (:id, :name, :text, :email)", params );
    }

    public boolean delete( int id ) {
        MapSqlParameterSource params = new MapSqlParameterSource( "id", id );

        return jdbc.update( "delete from OFFERS where id=:id", params ) == 1;
    }

    @SuppressWarnings("Convert2Lambda")
    public Offer getOffer( int id ) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue( "id", id );

        return jdbc.queryForObject( "select * from OFFERS where id=:id", params,
                new RowMapper<Offer>() {

            @Override
            public Offer mapRow( ResultSet rs, int rowNum )
                    throws SQLException {
                Offer offer = new Offer();

                offer.setId( rs.getInt( "id" ) );
                offer.setName( rs.getString( "name" ) );
                offer.setText( rs.getString( "text" ) );
                offer.setEmail( rs.getString( "email" ) );

                return offer;
            }

        } );
    }

}
