/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comment;

import java.io.IOException;
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
     * Test of writeComment method, of class Comments.
     */
    @Test
    public void testWriteComment() throws IOException {
        String modCode = "AC3007";
        String resitCode = "";
        String comment = "test comment";
        System.out.println("writeComment");
        Comments instance = new Comments();
        instance.writeComment(modCode,resitCode,comment);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of readComment method, of class Comments.
     */
    @Test
    public void testReadComment() throws IOException {
        String modCode = "AC3007";
        String resitCode = "";
        Comments instance = new Comments();
        instance.readComment(modCode, resitCode);
    }
    
}
