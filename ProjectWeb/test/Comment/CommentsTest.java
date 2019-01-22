/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comment;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matthewmchale
 */
public class CommentsTest {
    
    public CommentsTest() {
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
     * Test of getComment method, of class Comments.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        Comments instance = new Comments();
        String expResult = "";
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeComment method, of class Comments.
     */
    @Test
    public void testWriteComment() {
        
        System.out.println("writeComment");
        Comments instance = new Comments();
        instance.writeComment();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readComment method, of class Comments.
     */
    @Test
    public void testReadComment() {
        System.out.println("readComment");
        Comments instance = new Comments();
        String[] expResult = null;
        String[] result = instance.readComment();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
