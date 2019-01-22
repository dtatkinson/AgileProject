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
     * @throws java.io.IOException
     */
    @Test
    public void testCreateFile() throws IOException {
        FileHandling instance = new FileHandling();
        String newFile = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test\\";
        String fileName = "testdir";
        boolean create = instance.createFile(newFile,fileName);
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
         path = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test\\write.txt";
         String write = "write test";
         instance.writeToFile(path,write);
         String check[] = instance.readFromFile(path);
         boolean checkW =false;
         String checks = "";
         for(int i=0;i<check.length;i++){
             checks = checks + check[i];
         }
         if(Objects.equals(checks,write)){
             checkW = true;
         } else {
         }
         assertTrue("The file is write",checkW);    
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
    
    @Test
    /**
     * 
     * Test of appendToFile method, of class FileHandling
     */
    public void testAppendToFile() throws IOException{
        FileHandling instance = new FileHandling();
        String path = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test\\append.txt";
       // boolean created = instance.createFile(path);
        String written = "test";
        String appended = "appended string";
        instance.writeToFile(path,written);
        instance.appendToFile(path,appended);
        String[] check = instance.readFromFile(path);
        boolean append = false;
        String checks = "";
        for(int i=0;i<check.length;i++){
             checks = checks + check[i];
             System.out.println(checks);
         }
         if(Objects.equals(checks,written+appended)){
             append = true;
         } else {
         }
        assertTrue("The file has been appended to", append);
        
        
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
         path = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test\\read.txt";
         String l ="hello";
         instance.writeToFile(path,l);
         String[] check = instance.readFromFile(path);
         boolean read = false;
         String checks = "";
         for(int i=0;i<check.length;i++){
             checks = checks + check[i];
         }
         if(Objects.equals(checks,l)){
             read = true;
         } else {
         }
         assertTrue("The file is read",read);
         
    }

    /**
     * Test of deleteFile method, of class FileHandling.
     * @throws java.io.IOException
     */
    @Test
    public void testDeleteFile() throws IOException {
        FileHandling instance = new FileHandling();
        String newFile = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test\\";
        instance.createFile(newFile, "delete.txt");
        boolean delete = instance.deleteFile(newFile,"delete.txt");
        assertTrue("the File is created",delete);
    }
    
}
