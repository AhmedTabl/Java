/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import coe318.lab7.Node;
import coe318.lab7.Resistor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author atabl
 */
public class ResistorTest {
    
    public ResistorTest() {
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

    /**
     * Test of getNodes method, of class Resistor.
     */
    @Test
    public void testGetNodes() {
        System.out.println("getNodes");
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        
        Node[] expResult = {n1,n2};
        
        Resistor r = new Resistor(13, n1,n2);
        
        Assert.assertArrayEquals(expResult,r.getNodes());
    }

    /**
     * Test of toString method, of class Resistor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Resistor r = new Resistor(25, n1,n2);
        
        String s = "R" + r.getIndividualID() + " " + r.getNodes()[0].toString() + " " + r.getNodes()[1].toString() + " " + r.getResistance();
        Boolean expResult = true;
        Boolean matching = s.equals(r.toString());
        
        assertEquals(expResult,matching);
    }
    
}
