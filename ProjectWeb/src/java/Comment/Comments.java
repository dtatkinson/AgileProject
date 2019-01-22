/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comment;

import FileHandling.FileHandling;
import java.io.IOException;

/**
 *
 * @author matthewmchale
 */
public class Comments {
    public String getComment(){
        return "aids";
    }
    public void writeComment(String modCode, String resitCode, String comment) throws IOException{
        FileHandling instance = new FileHandling();
        String commentFile = "comment"+resitCode+".txt" ;
        String path = modCode + "\\2019";
        String fullPath = path+commentFile;
        if(instance.checkIfFileExists(fullPath))
        {         
            instance.appendToFile(path, commentFile, comment);
        }else
        {
            instance.createFile(path, commentFile);
            instance.appendToFile(path, commentFile, comment);
        }
        //need to create servlet to get session, and hence get the username, to get access rights or somethign please send big HELP
        }
    public String[] readComment(){
     return null;
    }
}
