/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author dfitzsimons
 */
@ActiveProfiles( "test" )
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "classpath*:/com/cop/spring/web/config/dao-context.xml",
    "classpath*:/com/cop/spring/web/config/security-config.xml",
    "classpath*:/com/cop/spring/web/config/dataSource.xml" } )
public class UsersDaoTest {

    @Autowired
    public DataSource dataSource;

    @Autowired
    public UsersDao usersDao;

    public UsersDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        JdbcTemplate jdbc = new JdbcTemplate( dataSource );
        jdbc.execute( "delete from offers" );
        jdbc.execute( "delete from users" );
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of exists method, of class UsersDao.
     */
    @Test
    public void testExists() {
        System.out.println( "exists" );

        String username = "username";
        boolean expResult = false;
        boolean result = usersDao.exists( username );
        assertEquals( expResult, result );

        User user = new User( "username", "name","email@home.ie", "password", "ROLE_USER" );
        usersDao.create( user );

        expResult = true;
        result = usersDao.exists( username );
        assertEquals( expResult, result );
    }

    /**
     * Test of getAllUsers method, of class UsersDao.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println( "getAllUsers" );
        List<User> expResult = new ArrayList<>();
        List<User> result = usersDao.getAllUsers();
        assertEquals( expResult, result );
        assertEquals( expResult.size(), result.size() );

        User user = new User( "username", "name","email@home.ie", "password", "ROLE_USER" );
        usersDao.create( user );

        expResult = new ArrayList<>();
        expResult.add( new User( "username", "name","email@home.ie", "password", "ROLE_USER" ) );
        result = usersDao.getAllUsers();
        assertEquals( expResult, result );

    }

    /**
     * Test of create method, of class UsersDao.
     */
    @Test
    public void testCreate() {
        System.out.println( "create" );
        User user = new User( "username", "name","email@home.ie", "password", "ROLE_USER" );
        boolean expResult = true;
        boolean result = usersDao.create( user );
        assertEquals( "User created", expResult, result );
    }

}
