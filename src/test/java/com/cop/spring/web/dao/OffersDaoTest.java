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
    "classpath*:/com/cop/spring/web/test/config/dataSource.xml" } )
public class OffersDaoTest {

    @Autowired
    public DataSource dataSource;

    @Autowired
    public OffersDao offersDao;

    @Autowired
    public UsersDao usersDao;

    public OffersDaoTest() {
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

        User user = new User( "username", "name", "email@home.ie", "password", "ROLE_USER" );
        usersDao.create( user );
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getOffers method, of class OffersDao.
     */
    @Test
    public void testGetOffers_0args() {
        System.out.println( "getOffers" );

        List<Offer> expResult = new ArrayList<>();
        List<Offer> result = offersDao.getOffers();
        assertEquals( expResult, result );

        if( usersDao.exists( "username" ) ) {
            Offer offer
                    = new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 1" );
            Offer offer2
                    = new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 2" );

            offersDao.create( offer );
            offersDao.create( offer2 );
        } else {
            assertTrue( "User username does not exist", 1 == 2 );
        }

        expResult = new ArrayList<>();
        expResult.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 1" ) );
        expResult.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 2" ) );
        result = offersDao.getOffers();
        assertEquals( expResult.get( 0 ).getText(), result.get( 0 ).getText() );
        assertEquals( expResult.get( 1 ).getText(), result.get( 1 ).getText() );

    }

    /**
     * Test of update method, of class OffersDao.
     */
    @Test
    public void testUpdate() {
        System.out.println( "update" );
        List<Offer> offers = new ArrayList<>();
        offers.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 1" ) );
        offers.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 2" ) );

        offersDao.create( offers );

        List<Offer> dbOffers = offersDao.getOffers();
        Offer offer = dbOffers.get( 1 );
        offer.setText( "text 3" );
        int id = offer.getId();
        boolean expResult = true;
        boolean result = offersDao.update( offer );
        Offer updatedOffer = offersDao.getOffer( id );
        assertEquals( expResult, result );
        assertEquals( offer.getText(), updatedOffer.getText() );

    }

    /**
     * Test of create method, of class OffersDao.
     */
    @Test
    public void testCreate_Offer() {
        System.out.println( "create" );
        Offer offer = new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text" );
        boolean expResult = true;
        boolean result = offersDao.create( offer );
        assertEquals( expResult, result );

    }

    /**
     * Test of create method, of class OffersDao.
     */
    @Test
    public void testCreate_List() {
        System.out.println( "create" );
        List<Offer> offers = new ArrayList<>();
        offers.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 1" ) );
        offers.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 2" ) );

        int[] expResult = { 1, 1 };
        int[] result = offersDao.create( offers );
        assertArrayEquals( expResult, result );

    }

    /**
     * Test of delete method, of class OffersDao.
     */
    @Test
    public void testDelete() {
        System.out.println( "delete" );

        List<Offer> offers = new ArrayList<>();
        offers.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 1" ) );
        offers.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 2" ) );

        offersDao.create( offers );

        List<Offer> dbOffers = offersDao.getOffers();
        int id = dbOffers.get( 1 ).getId();

        boolean expResult = true;
        boolean result = offersDao.delete( id );
        assertEquals( expResult, result );

        Offer noOffer = offersDao.getOffer( id );
        assertNull( noOffer );
    }

    /**
     * Test of getOffer method, of class OffersDao.
     */
    @Test
    public void testGetOffer() {
        System.out.println( "getOffer" );

        List<Offer> offers = new ArrayList<>();
        offers.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 1" ) );
        offers.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 2" ) );

        offersDao.create( offers );

        List<Offer> dbOffers = offersDao.getOffers();
        int id = dbOffers.get( 1 ).getId();

        Offer expResult = offers.get( 1 );
        Offer result = offersDao.getOffer( id );
        assertEquals( expResult.getText(), result.getText() );

    }

    /**
     * Test of getOffers method, of class OffersDao.
     */
    @Test
    public void testGetOffers_String() {
        System.out.println( "getOffers" );

        List<Offer> offers = new ArrayList<>();
        offers.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 1" ) );
        offers.add( new Offer( new User( "username", "name", "email@home.ie", "password", "ROLE_USER" ), "text 2" ) );

        offersDao.create( offers );

        String userName = "username";
        List<Offer> expResult = offers;
        List<Offer> result = offersDao.getOffers( userName );
        assertEquals( expResult.get( 0 ).getText(), result.get( 0 ).getText() );
        assertEquals( expResult.get( 1 ).getText(), result.get( 1 ).getText() );

    }

}
