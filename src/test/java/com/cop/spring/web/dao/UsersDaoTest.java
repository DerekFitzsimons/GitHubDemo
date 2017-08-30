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

    private final User user1 = new User( "Mike", "Michael Mouse", "mike@home.ie", "Hell01", "ROLE_ADMIN", true );

    private final User user2 = new User( "Rob", "Rob Roy", "rob@home.ie", "Hell02", "ROLE_USER" );

    private final User user3 = new User( "John", "John Doe", "john.doe@home.ie", "Hell03", "ROLE_USER", false );

    private final User user4 = new User( "George", "George of The Jungle", "george@home.ie", "Hell03", "ROLE_USER" );

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
        assertEquals( "'username' exists, it shouldn't",expResult, result );

        usersDao.create( user1 );
        usersDao.create( user2 );
        usersDao.create( user3 );
        usersDao.create( user4 );

        expResult = true;
        result = usersDao.exists( user1.getUsername() );
        assertEquals( expResult, result );
        result = usersDao.exists( user2.getUsername() );
        assertEquals( expResult, result );
        result = usersDao.exists( user3.getUsername() );
        assertEquals( expResult, result );
        result = usersDao.exists( user4.getUsername() );
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
        usersDao.create( user1 );
        usersDao.create( user2 );
        usersDao.create( user3 );
        usersDao.create( user4 );

        expResult = new ArrayList<>();
        expResult.add( user1 );
        expResult.add( user2 );
        expResult.add( user3 );
        expResult.add( user4 );
        result = usersDao.getAllUsers();
        assertEquals( expResult.size(), result.size() );

    }

    /**
     * Test of create method, of class UsersDao.
     */
    @Test
    public void testCreate() {
        System.out.println( "testCreate" );
        usersDao.create( user1 );
        usersDao.create( user2 );
        usersDao.create( user3 );
        usersDao.create( user4 );

        assertTrue( usersDao.exists( user1.getUsername() ) );
        assertTrue( usersDao.exists( user2.getUsername() ) );
        assertTrue( usersDao.exists( user3.getUsername() ) );
        assertTrue( usersDao.exists( user4.getUsername() ) );
    }

}
