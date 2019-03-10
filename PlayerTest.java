/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hrithvik
 */
public class PlayerTest {

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    /**
     * Test of getX_Coordinate method, of class Player.
     */
    @Test
    public void testGetX_Coordinate() {
        System.out.println("getX_Coordinate");
        Player instance = new Player(700, 500);
        int expResult = 700;
        int result = instance.getX_Coordinate();
        assertEquals("Expected result is 700" +expResult, instance.getX_Coordinate());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY_Coordinate method, of class Player.
     */
    @Test
    public void testGetY_Coordinate() {
        System.out.println("getY_Coordinate");
        Player instance = new Player(400, 800);
        int expResult = 800;
        assertEquals("Expected value 800" +expResult, instance.getY_Coordinate());
    }

    /**
     * Test of getLive method, of class Player.
     */
    @Test
    public void testGetLive() {
        System.out.println("getLive");
        Player instance = new Player(80, 80);
        boolean expResult = true;
        boolean result = instance.getLive();
        assertEquals("Expected result true" +expResult, result);
    }



    /**
     * Test of moveRight method, of class Player.
     */
    @Test
    public void testMoveRight() {
        System.out.println("moveRight");
        Player instance = new Player(80, 80);
        int expResult = 85;
        instance.moveRight();
        assertEquals("Expected x_Coordinate" +expResult, instance.getX_Coordinate());
    }

    /**
     * Test of moveLeft method, of class Player.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("moveLeft");
        Player instance = new Player(100, 120);
        instance.moveLeft();
        assertEquals("Expected x_Coordinate" +95, instance.getX_Coordinate());
    }

    /**
     * Test of setXCoordinate method, of class Player.
     */
    @Test
    public void testSetXCoordinate() {
        System.out.println("setXCoordinate");
        int a = 150;
        Player instance = new Player(80, 100);
        instance.setXCoordinate(a);
        assertEquals("Expected x_Coordinate" +150, instance.getX_Coordinate());
    }

    /**
     * Test of setYCoordinate method, of class Player.
     */
    @Test
    public void testSetYCoordinate() {
        System.out.println("setYCoordinate");
        int a = 250;
        Player instance = new Player(100, 100);
        instance.setYCoordinate(a);
        assertEquals("Expected y_Coordinate" +250, instance.getY_Coordinate());
    }

    /**
     * Test of moveDown method, of class Player.
     */
    @Test
    public void testMoveDown() {
        System.out.println("moveDown");
        Player instance = new Player(100, 200);
        instance.moveDown();
        assertEquals("Expected y_Coordinate" +190, instance.getY_Coordinate());
    }

}
