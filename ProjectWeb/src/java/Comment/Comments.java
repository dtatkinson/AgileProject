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
 */
public class Comments {
   
    public void writeComment(String modCode,String comment, String signBy) throws IOException{
        FileHandling instance = new FileHandling();
        String commentFile = "comments.txt" ;
        String path = modCode + "\\2019\\";
        String fullPath = path+commentFile;
        
        if(instance.checkIfFileExists(fullPath))
        {         
            instance.appendToFile(path, commentFile, comment);
            instance.appendToFile(path, commentFile, signBy);
        }else if(!instance.checkIfFileExists(fullPath))
        {
            instance.createFile(path, commentFile);
            instance.writeToFile(path, commentFile, comment);
            instance.appendToFile(path, commentFile, signBy);
        }
        //need to create servlet to get session, and hence get the username, to get access rights or somethign please send big HELP
    }
    /*public void readComment(String modCode) throws IOException{
        String[] comment;
        FileHandling instance = new FileHandling();
        String commentFile = "comment.txt" ;
        String path = modCode + "\\2019\\";
        String fullPath = path+commentFile;
        if(instance.checkIfFileExists(fullPath))
        {
            comment = instance.readFromFile(path, commentFile);
            System.out.println(Arrays.toString(comment));
        }
    **/
        
}

