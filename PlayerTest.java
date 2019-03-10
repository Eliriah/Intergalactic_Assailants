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
    public static final String CLASSNAME = "Player";
    public static final String FILENAME = CLASSNAME + ".java";
    
    
    private void testInterface() 
    {
            String[] instanceVars = {"int x_coordinate", "int y_coordinate", "int width", "int height", "boolean live"};

//		assertTrue("Class should not have the default constructor.", noDefaultConstructor());

    }

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
        testInterface();
        System.out.println("getX_Coordinate");
        Player instance = new Player(700, 500);
        int expResult = 700;
        assertEquals("Expected result is ",expResult, instance.getX_Coordinate());
    }

    /**
     * Test of getY_Coordinate method, of class Player.
     */
    @Test
    public void testGetY_Coordinate() {
        testInterface();
        System.out.println("getY_Coordinate");
        Player instance = new Player(400, 800);
        int expResult = 800;
        assertEquals("Expected value ", expResult, instance.getY_Coordinate());
    }

    /**
     * Test of getLive method, of class Player.
     */
    @Test
    public void testGetLive() {
        testInterface();
        System.out.println("getLive");
        Player instance = new Player(80, 80);
        boolean expResult = true;
        boolean result = instance.getLive();
        assertEquals("Expected result true", expResult, result);
    }



    /**
     * Test of moveRight method, of class Player.
     */
    @Test
    public void testMoveRight() {
        testInterface();
        System.out.println("moveRight");
        Player instance = new Player(80, 80);
        int expResult = 85;
        instance.moveRight();
        assertEquals("Expected x_Coordinate", expResult, instance.getX_Coordinate());
    }

    /**
     * Test of moveLeft method, of class Player.
     */
    @Test
    public void testMoveLeft() {
        testInterface();
        System.out.println("moveLeft");
        Player instance = new Player(100, 120);
        instance.moveLeft();
        assertEquals("Expected x_Coordinate", 95, instance.getX_Coordinate());
    }

    /**
     * Test of setXCoordinate method, of class Player.
     */
    @Test
    public void testSetXCoordinate() {
        testInterface();
        System.out.println("setXCoordinate");
        int a = 150;
        Player instance = new Player(80, 100);
        instance.setXCoordinate(a);
        assertEquals("Expected x_Coordinate", 150, instance.getX_Coordinate());
    }

    /**
     * Test of setYCoordinate method, of class Player.
     */
    @Test
    public void testSetYCoordinate() {
        testInterface();
        System.out.println("setYCoordinate");
        int a = 250;
        Player instance = new Player(100, 100);
        instance.setYCoordinate(a);
        assertEquals("Expected y_Coordinate", 250, instance.getY_Coordinate());
    }

    /**
     * Test of moveDown method, of class Player.
     */
    @Test
    public void testMoveDown() {
        testInterface();
        System.out.println("moveDown");
        Player instance = new Player(100, 200);
        instance.moveDown();
        assertEquals("Expected y_Coordinate", 210, instance.getY_Coordinate());
    }

}
