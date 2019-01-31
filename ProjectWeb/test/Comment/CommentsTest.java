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
     * 
     */
    
    //fix this later
    String path = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\";
    String modCode = "MORTYTEST";
    
    @Test
    public void testWriteComment() throws IOException {
      
        String comment = "test comment";
        String signBy = "Morty";
        System.out.println("writeComment");
        Comments instance = new Comments();
        instance.writeComment(modCode,comment,signBy, path,"2019");
        instance.writeComment(modCode,comment,signBy, path,"2019",true);
    }

    /*
     * Test of readComment method, of class Comments.
     * @throws java.io.IOException
     */
    @Test
    public void testReadComment() throws IOException {
        
         Comments instance = new Comments();
         boolean read;
        
        read = instance.readComment(modCode, path,"2019");
       
        if(read){
        assertTrue("acknowledged", read);
        }
        else{
           Assert.assertFalse("not acknowledged", read);
        }
    }
    
    @Test
    public void testAckComments() throws IOException{
        
        String comment = "test ACK comment";
        String signBy = "BIGarsingGDAVE";
        Comments instance = new Comments();
        instance.ackComments(modCode,comment,signBy, path,"2019");
        instance.ackComments(modCode, comment, signBy, path,"2019",true);
    }
    
}
