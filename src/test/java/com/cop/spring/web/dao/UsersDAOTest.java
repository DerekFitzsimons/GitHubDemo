/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cop.spring.web.dao;

import java.util.List;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author dfitzsimons
 */
@ActiveProfiles( "test" )
@ContextConfiguration( locations = { "../config/dao-context.xml",
    "../config/security-config.xml", "../test/config/dataSource.xml" } )
@RunWith(SpringJUnit4ClassRunner.class)
public class UsersDAOTest {
    
    public UsersDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testDummy(){
        System.out.println( "Dummy test" );
    }
    
//    /**
//     * Test of exists method, of class UsersDAO.
//     */
//    @Test
//    public void testExists() {
//        System.out.println( "exists" );
//        String username = "";
//        UsersDAO instance = new UsersDAO();
//        boolean expResult = false;
//        boolean result = instance.exists( username );
//        assertEquals( expResult, result );
//        // TODO review the generated test code and remove the default call to fail.
//        fail( "The test case is a prototype." );
//    }
//
//    /**
//     * Test of getAllUsers method, of class UsersDAO.
//     */
//    @Test
//    public void testGetAllUsers() {
//        System.out.println( "getAllUsers" );
//        UsersDAO instance = new UsersDAO();
//        List<User> expResult = null;
//        List<User> result = instance.getAllUsers();
//        assertEquals( expResult, result );
//        // TODO review the generated test code and remove the default call to fail.
//        fail( "The test case is a prototype." );
//    }
//
//    /**
//     * Test of setDataSource method, of class UsersDAO.
//     */
//    @Test
//    public void testSetDataSource() {
//        System.out.println( "setDataSource" );
//        DataSource jdbc = null;
//        UsersDAO instance = new UsersDAO();
//        instance.setDataSource( jdbc );
//        // TODO review the generated test code and remove the default call to fail.
//        fail( "The test case is a prototype." );
//    }
//
//    /**
//     * Test of create method, of class UsersDAO.
//     */
//    @Test
//    public void testCreate() {
//        System.out.println( "create" );
//        User user = null;
//        UsersDAO instance = new UsersDAO();
//        boolean expResult = false;
//        boolean result = instance.create( user );
//        assertEquals( expResult, result );
//        // TODO review the generated test code and remove the default call to fail.
//        fail( "The test case is a prototype." );
//    }
    
}
