/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comment;

import FileHandling.FileHandling;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author matthewmchale
 * reviewed by LenardGaunt
 */
public class Comments {
   
   /**
    * Method to write comments
    * @param modCode 
    * @param comment
    * @param signBy
    * @throws IOException 
    */
    public void writeComment(String modCode,String comment, String signBy) throws IOException{
        FileHandling instance = new FileHandling();
        String commentFile = "comments.txt" ;
        String path = modCode + "\\2019\\";
        String fullPath = path+commentFile;
        String commentR = "c." + comment;
        
        if(instance.checkIfFileExists(fullPath))
        {         
            instance.appendToFile(path, commentFile, commentR);
            instance.appendToFile(path, commentFile, signBy);
        }else if(!instance.checkIfFileExists(fullPath))
        {
            instance.createFile(path, commentFile);
            instance.writeToFile(path, commentFile, commentR);
            instance.appendToFile(path, commentFile, signBy);
        }
        
    }
   
    /**
     * Method to read comments and check if all comments have been acknowledged
     * @param modCode
     * @return
     * @throws IOException 
     */
    public boolean readComment(String modCode) throws IOException{
        String[] comment = null;
        FileHandling file = new FileHandling();
        String commentFile = "comments.txt" ;
        String path = modCode + "\\2019\\";
        String fullPath = path+commentFile;
        if(file.checkIfFileExists(fullPath))
        {
            comment = file.readFromFile(path, commentFile);
            System.out.println(Arrays.toString(comment));
        }
        int cmmt = 0;
        int ack = 0;
        String line;
        for(int i = 0; i < comment.length; i++)
        {
           try{
            line = Character.toString(comment[i].charAt(0));
           if(line.equals("c")){
               cmmt++;
           }else if (line.equals("a"))
           {
               ack++;
           }
           }catch(StringIndexOutOfBoundsException e)
           {
               //do nothing, move on to next line
           }
        }
        if(cmmt == ack){
            return true;
        }
        return false;
    }
    
   /**
    * Method to write acknowledgement comments
    * @param modCode
    * @param comment
    * @param signBy
    * @throws IOException 
    */
    public void ackComments(String modCode,String comment,String signBy) throws IOException{
        FileHandling file = new FileHandling();
        String commentFile = "comments.txt" ;
        String path = modCode + "\\2019\\";
        String fullPath = path+commentFile;
        String commentR = "a." + comment;
        
        if(file.checkIfFileExists(fullPath))
        {         
            file.appendToFile(path, commentFile, commentR);
            file.appendToFile(path, commentFile, signBy);
        }else if(!file.checkIfFileExists(fullPath))
        {
            file.createFile(path, commentFile);
            file.writeToFile(path, commentFile, commentR);
            file.appendToFile(path, commentFile, signBy);
        }
    }
}

