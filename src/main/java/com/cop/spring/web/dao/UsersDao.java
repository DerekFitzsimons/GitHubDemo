package com.cop.spring.web.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component( "usersDao" )
public class UsersDao {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger( UsersDao.class.getName() );

    @Autowired
    private SessionFactory sessionFactory;

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void create( User user ) {
        session().save( user );
        if( LOGGER.isDebugEnabled() ) {
            LOGGER.debug( "User Created" );
        }
    }

    public boolean exists( String username ) {

        String sql = "select count(*) from users where username=:username";
        boolean output
                = jdbc.queryForObject( sql, new MapSqlParameterSource( "username", username ), Integer.class ) > 0;
        if( LOGGER.isDebugEnabled() ) {
            LOGGER.debug( "User " + username + " exists" );
        }
        return output;

    }

    public List<User> getAllUsers() {
        @SuppressWarnings( "unchecked" )
        List<User> output = session().createQuery( "from users" ).list();
        if( LOGGER.isDebugEnabled() ) {
            LOGGER.debug( "All Users retrieved" );
        }
        return output == null
               ? new ArrayList<>()
               : output;
    }

    @Autowired
    public void setDataSource( DataSource jdbc ) {
        this.jdbc = new NamedParameterJdbcTemplate( jdbc );
        if( LOGGER.isDebugEnabled() ) {
            LOGGER.debug( "Users datasource set" );
        }
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }
}
