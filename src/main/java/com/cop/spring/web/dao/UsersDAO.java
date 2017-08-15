package com.cop.spring.web.dao;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component( "usersDao" )
public class UsersDAO {

    /**
     * Logger
     */
    private static final Logger LOGGER = Logger.getLogger(UsersDAO.class.getName() );

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource( DataSource jdbc ) {
        LOGGER.info( "Setting datasource" );
        this.jdbc = new NamedParameterJdbcTemplate( jdbc );
    }

    @Transactional
    public boolean create( User user ) {

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource( user );
        String sql1 ="insert into users (username, email, password, enabled) values (:username, :email, :password, :enabled)";
      
        String sql2 ="insert into authorities (username, authority) values (:username, :authority)";
        
        jdbc.update( sql1, params );
        LOGGER.info( "Creating user" );
        boolean output = jdbc.update( sql2, params ) == 1;
        LOGGER.info( "Creatin authority" );
        return output;

    }


}
