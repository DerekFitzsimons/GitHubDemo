package com.cop.spring.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    private static final Logger LOGGER = Logger.getLogger( UsersDao.class.getName() );

    
    @Autowired
    private SessionFactory sessionFactory;    
    
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public boolean create( User user ) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue( "username", user.getUsername() );
        params.addValue( "password", passwordEncoder.encode( user.getPassword() ) );
        params.addValue( "email", user.getEmail() );
        params.addValue( "enabled", user.isEnabled() );
        params.addValue( "authority", user.getAuthority() );
        params.addValue( "name", user.getName() );
        StringBuilder sql = new StringBuilder();
        sql.append( "insert into users (username, name,email, password, enabled, authority) " );
        sql.append( "values (:username, :name,:email, :password, :enabled, :authority);");

        boolean output = jdbc.update( sql.toString(), params )>0;
        LOGGER.info( "Creating user" );
        return output;

    }

    public boolean exists( String username ) {

        String sql = "select count(*) from users where username=:username";

        return jdbc.queryForObject( sql, new MapSqlParameterSource( "username", username ), Integer.class ) > 0;

    }

    public List<User> getAllUsers() {
        @SuppressWarnings( "unchecked" )
        List<User> output = session().createQuery( "from users").list();
        return output == null
               ? new ArrayList<>()
               : output;
    }

    @Autowired
    public void setDataSource( DataSource jdbc ) {
        LOGGER.info( "Setting datasource" );
        this.jdbc = new NamedParameterJdbcTemplate( jdbc );
    }

    
    private Session session(){
        return sessionFactory.getCurrentSession();
    }
}
