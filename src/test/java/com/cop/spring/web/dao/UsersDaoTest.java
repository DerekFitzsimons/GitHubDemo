/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.dao;

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
    "classpath*:/com/cop/spring/web/config/security-config.xml", "classpath*:/com/cop/spring/web//test/config/dataSource.xml" } )

public class UsersDaoTest{
    
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
        jdbc.execute( "delete from users" );
        jdbc.execute( "delete from authorities" );
    }

    @After
    public void tearDown() {
    }

//    /**
//     * Test of exists method, of class UsersDao.
//     */
//    @Test
//    public void testExists() {
//        System.out.println( "exists" );
//        String username = "";
//        UsersDao instance = new UsersDao();
//        boolean expResult = false;
//        boolean result = instance.exists( username );
//        assertEquals( expResult, result );
//        // TODO review the generated test code and remove the default call to fail.
//        fail( "The test case is a prototype." );
//    }
//
//    /**
//     * Test of getAllUsers method, of class UsersDao.
//     */
//    @Test
//    public void testGetAllUsers() {
//        System.out.println( "getAllUsers" );
//        UsersDao instance = new UsersDao();
//        List<User> expResult = null;
//        List<User> result = instance.getAllUsers();
//        assertEquals( expResult, result );
//        // TODO review the generated test code and remove the default call to fail.
//        fail( "The test case is a prototype." );
//    }
//
//    /**
//     * Test of setDataSource method, of class UsersDao.
//     */
//    @Test
//    public void testSetDataSource() {
//        System.out.println( "setDataSource" );
//        DataSource jdbc = null;
//        UsersDao instance = new UsersDao();
//        instance.setDataSource( jdbc );
//        // TODO review the generated test code and remove the default call to fail.
//        fail( "The test case is a prototype." );
//    }
    
    /**
     * Test of create method, of class UsersDao.
     */
    @Test
    public void testCreate() {
        System.out.println( "create" );
        User user = new User( "username", "email@home.ie", "password", "ROLE_USER" );
        boolean expResult = true;
        boolean result = usersDao.create( user );
        assertEquals( "User created", expResult, result );
    }

}
