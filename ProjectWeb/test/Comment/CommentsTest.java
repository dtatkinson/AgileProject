/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comment;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
     * @throws java.io.IOException
     */
    @Test
    public void testWriteComment() throws IOException {
        String modCode = "CommentsTestModule";
        String comment = "test comment";
        String signBy = "Morty";
        System.out.println("writeComment");
        Comments instance = new Comments();
        instance.writeComment(modCode,comment,signBy);
    }

    /*
     * Test of readComment method, of class Comments.
     * @throws java.io.IOException
     */
    @Test
    public void testReadComment() throws IOException {
        String modCode = "CommentsTestModule";
         Comments instance = new Comments();
         boolean read;
        read = instance.readComment(modCode);
        if(read){
        assertTrue("acknowledged", read);
        }
        else{
           Assert.assertFalse("not acknowledged", read);
        }
    }
    
    @Test
    public void testAckComments() throws IOException{
        String modCode = "CommentsTestModule";
        String comment = "test ACK comment";
        String signBy = "BIGarsingGDAVE";
        Comments instance = new Comments();
        instance.ackComments(modCode,comment,signBy);
    }
    
}
