/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandling;

import java.io.IOException;
import java.util.List;

import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

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
    public void A_testCreateFile() throws IOException {
        FileHandling instance = new FileHandling();
        String newFile = "test\\";
        String fileName = "testcreate.txt";
        boolean create = instance.createFile(newFile,fileName);
        if(instance.checkIfFileExists(newFile+fileName)){
            assertFalse("The file already Exists",create);
        }else{
        assertTrue("the File is created",create);
        }
       
     }

    /**
     * Test of writeToFile method, of class FileHandling.
     * @throws java.io.IOException
     */
    @Test
    public void B_testWriteToFile() throws IOException {
         FileHandling instance = new FileHandling();
         String path;
         path = "test\\";
         String fileName = "write.txt";
         String write = "write test";
         instance.writeToFile(path,fileName,write);
         String check[] = instance.readFromFile(path,fileName);
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
    public void C_testCheckIfFileExists() {
        FileHandling instance = new FileHandling();
        String path = "test";
        boolean exist = instance.checkIfFileExists(path);
        assertTrue("The file is Exist", exist);
    }
    
    @Test
    /**
     * 
     * Test of appendToFile method, of class FileHandling
     */
    public void D_testAppendToFile() throws IOException{
        FileHandling instance = new FileHandling();
        String path = "test\\";
        String fileName = "append.txt";
       // boolean created = instance.createFile(path);
        String written = "test";
        String appended = "appended string";
        instance.writeToFile(path,fileName,written);
        instance.appendToFile(path,fileName,appended);
        String[] check = instance.readFromFile(path,fileName);
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
    public void E_testReadFromFile() throws IOException {
         FileHandling instance = new FileHandling();
         String path;
         path = "test\\";
         String fileName = "read.txt";
         String toWrite ="hello";
         instance.writeToFile(path,fileName, toWrite);
         String[] check = instance.readFromFile(path,fileName);
         boolean read = false;
         String checks = "";
        for (String check1 : check) {
            checks = checks + check1;
            System.out.println(checks);
        }
         if(Objects.equals(checks,toWrite)){
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
    public void F_testDeleteFile() throws IOException {
        FileHandling instance = new FileHandling();
        String newFile = "test\\";
        instance.createFile(newFile, "delete.txt");
        boolean delete = instance.deleteFile(newFile,"delete.txt");
        assertTrue("the File is created",delete);
    }
    
    @Test
    public void G_testCreateDirectory() throws IOException{
        FileHandling instance = new FileHandling();
        String path = "test\\";
        String folderName = "bigcamobOI";
        instance.createDirectory(path, folderName);
    }
   
   //first test, does it return a list
    @Test
    public void H_test1() throws IOException{
        FileHandling instance = new FileHandling();
        List<String> results = instance.getListofFiles("AC131","2019");
        assertFalse(results.isEmpty());
    }
    
    //hooray we have an empty list
    //now we need to populate it with names of files
    //we can check if the list contains these elements
    
        @Test
    public void H_test2() throws IOException{
        FileHandling instance = new FileHandling();
        List<String> results = instance.getListofFiles("AC131","2019");
        assertTrue(results.contains("comments.txt"));
    }
    
        @Test
    public void H_test3() throws IOException{
        FileHandling instance = new FileHandling();
        List<String> results = instance.getListofFiles("AC131","2019");
        assertTrue(results.contains("AC131.pdf"));
    }
    
        @Test
    public void H_test4() throws IOException{
        FileHandling instance = new FileHandling();
        List<String> results = instance.getListofFiles("AC131","2019");
        assertFalse(results.contains("additonalUploads"));
    }
    
    //great, we have most of what we neede, however we must ensure that we do not mistake directories as files
    //almost there, now we need to take the hardcoding out of our function
    //still one last bit of hard coding to improve upon as it would mess with the webserver
    //the code we wrote only works localhost side
    //there we go
    
    
    
}

