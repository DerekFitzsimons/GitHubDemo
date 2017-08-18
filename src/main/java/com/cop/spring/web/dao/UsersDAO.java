package com.cop.spring.web.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component( "usersDao" )
public class UsersDAO {

    /**
     * Logger
     */
    private static final Logger LOGGER = Logger.getLogger(UsersDAO.class.getName() );

    private NamedParameterJdbcTemplate jdbc;

    public boolean exists( String username ) {
        
        String sql = "select count(*) from users where username=:username";
        
        return jdbc.queryForObject( sql,new MapSqlParameterSource("username",username), Integer.class ) > 0;
        
 
    }

    public List<User> getAllUsers() {
        String sql ="select * from users, authorities where users.username = authorities.username";
        return jdbc.query( sql, BeanPropertyRowMapper.newInstance( User.class) );
    }

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
        LOGGER.info( "Creating authority" );
        return output;

    }


}
