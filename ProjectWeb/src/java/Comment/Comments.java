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
     * @param lenardsPath
     * @param year
    * @throws IOException 
    */
    public void writeComment(String modCode,String comment, String signBy, String lenardsPath, String year) throws IOException{
        FileHandling instance = new FileHandling();
        //hard coded value okay for the comments file, however year will need to be dealt with during sprint2
        String commentFile = "comments.txt" ;
        String path = modCode + "\\"+year+"\\";
        String fullPath = path+commentFile;
        String commentR = "c." + comment;
        //this code eventually had to be refactored to another method "ackComments" to accomodate for the difference in comments by
        //a moderator and an acknowledgement from an exam setter
        instance.defaultPath = lenardsPath;
        
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
     * @param lenardPath
     * @param year
     * @return
     * @throws IOException 
     */
    public boolean readComment(String modCode, String lenardPath,String year) throws IOException{
        //this entire method was refactored as during the orignal development me sort of lost sight of what the goal
        //of the method was supposed to do, now the name is not quite accurate as the method is actually more of 
        //a check as to whether or not all the comments made by moderators have an acknowledgment comment
        //this is done by checking the number of c.comments verses a.acknowledgements in comments.txt
        //simply done by checking the first character of the string for an 'a' or a 'c'
        String[] comment = null;
        FileHandling file = new FileHandling();
        file.defaultPath = lenardPath;
        String commentFile = "comments.txt" ;
        String path = modCode + "\\"+year+"\\";
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
     * @param lenardPath
    * @throws IOException 
    */
    //refactored code to write acknowledgement comments instead of normal comments
    public void ackComments(String modCode,String comment,String signBy, String lenardPath,String year) throws IOException{
       
        
        FileHandling file = new FileHandling();
        file.defaultPath = lenardPath;
        
        String commentFile = "comments.txt" ;
       
        String path = modCode + "\\"+year+"\\";
        
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

