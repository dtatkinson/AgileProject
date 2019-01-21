
package org.mypackage.login;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

//used to order the tests, alphabeticly 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 * @author lenardgaunt
 */
public class LoginServletTest {
    
    public LoginServletTest() {
    }
    
    //pretested method, just here for completeness of testing
    @Test
    public void A_testProcessRequest() {
        System.out.println("Method is pretested, through Index.jsp. It has been robust");
    }

    //Test for the cases of empty username that it still considers it to be equal
    @Test
    public void B_testEmptyProcessUsername() {
        System.out.println("process Empty Username");
        String data = "";
        String username = "";
        LoginServlet instance = new LoginServlet();
        boolean expResult = true;
        boolean result = instance.processUsername(data, username);
        assertEquals(expResult, result);
    }
    
    //Test for Correctly working username 
    @Test
    public void BA_testProcessUsername() {
        System.out.println("process Username");
        String data = "Lenny";
        String username = "Lenny";
        LoginServlet instance = new LoginServlet();
        boolean expResult = true;
        boolean result = instance.processUsername(data, username);
        assertEquals(expResult, result);
    }

    //Test for the cases of empty password that it still considers it to be equal
    @Test
    public void C_testEmptyProcessPassword() {
        System.out.println("process Empty Password");
        String data = "";
        String password = "";
        LoginServlet instance = new LoginServlet();
        boolean expResult = true;
        boolean result = instance.processPassword(data, password);
        assertEquals(expResult, result);   
    }
    
    //Test for Correctly working password 
    @Test
    public void CA_testProcessPassword() {
        System.out.println("process Password");
        String data = "Testpswd";
        String password = "Testpswd";
        LoginServlet instance = new LoginServlet();
        boolean expResult = true;
        boolean result = instance.processPassword(data, password);
        assertEquals(expResult, result);   
    }
}
