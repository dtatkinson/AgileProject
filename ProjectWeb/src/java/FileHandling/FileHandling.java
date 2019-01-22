/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandling;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to handle all things related to files
 * @author matthewmchale
 */
public class FileHandling {
    
    public boolean createFile(String filePath,String fileName) throws IOException{
        String fullPath = filePath + fileName;
        
        if(checkIfFileExists(fullPath)){
            return true;
        }
        else
        {
        System.out.println(fullPath);
        File f = new File(fullPath);
        return f.createNewFile();
        }
    }
    
    public void writeToFile(String filePath,String strToWrite) throws IOException{
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            
            writer.write(strToWrite);
        }
      
    }
    
    public void appendToFile(String path, String strToAppend) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
        writer.newLine();
        writer.write(strToAppend);
        writer.close();
    }
    
    public boolean checkIfFileExists(String path){
        File f = new File(path);
        return f.exists();
    }
    
    public String[] readFromFile(String fileName) throws FileNotFoundException, IOException{
       BufferedReader in = new BufferedReader(new FileReader(fileName));
        String str = "";
        ArrayList<String> lines = new ArrayList<String>();
        while((str = in.readLine()) != null){
            lines.add(str);
        }
        String[] linesArray = lines.toArray(new String[lines.size()]);
        return linesArray;
        
    }
    
    public boolean deleteFile(String filePath, String fileName){
        String fullPath = filePath + fileName;
        File f = new File(fullPath);
        return f.delete();
    }
    
     public void createDirectory(String path) throws IOException
    {
        Files.createDirectories(Paths.get(path));
    }
    
}
    

