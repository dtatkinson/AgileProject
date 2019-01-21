/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandling;

import java.io.IOException;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * testDirectory   \\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test\\
 * @author matthewmchale
 */
public class FileHandlingTest {
    
    public FileHandlingTest() {
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
     * Test of createFile method, of class FileHandling.
     */
    @Test
    public void testCreateFile() throws IOException {
        FileHandling instance = new FileHandling();
        String newFile = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test\\Create.txt";
        
        boolean create = instance.createFile(newFile);
        assertTrue("the File is created",create);
     }

    /**
     * Test of writeToFile method, of class FileHandling.
     * @throws java.io.IOException
     */
    @Test
    public void testWriteToFile() throws IOException {
         FileHandling instance = new FileHandling();
         String path;
         path = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test\\kk.txt";
         String write = instance.writeToFile(path);
         boolean check =false;
         if (Objects.equals(instance.readFromFile(path),write)){
             check = true;
         }
         assertTrue("The file is write",check);    
         
         
    }

    /**
     * Test of checkIfFileExists method, of class FileHandling.
     */
    @Test
    public void testCheckIfFileExists() {
        FileHandling instance = new FileHandling();
        String path = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test";
        boolean exist = instance.checkIfFileExists(path);
        assertTrue("The file is Exist", exist);
    }

    /**
     * 
     * Test of readFromFile method, of class FileHandling.
     * @throws java.io.IOException
     */
    @Test
    public void testReadFromFile() throws IOException {
         FileHandling instance = new FileHandling();
         String path;
         path = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test\\kk.txt";
         String check = instance.readFromFile(path);
         boolean read = false;
         if(Objects.equals(check,instance.writeToFile(path))){
             read = true;
         }
         assertTrue("The file is read",read);
         
    }

    /**
     * Test of deleteFile method, of class FileHandling.
     */
    @Test
    public void testDeleteFile() {
        FileHandling instance = new FileHandling();
        String newFile = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test\\Create.txt";
        boolean delete = instance.deleteFile(newFile);
        assertTrue("the File is created",delete);
    }
    
}
