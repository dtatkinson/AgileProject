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
    String defaultPath = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\";
    
   
    public boolean createFile(String filePath,String fileName) throws IOException{
        String fullPath = defaultPath + filePath + fileName;
        String path = filePath + fileName;
        
        if(checkIfFileExists(path)){
            return true;
        }
        else
        {
        System.out.println(fullPath);
        File f = new File(fullPath);
        return f.createNewFile();
        }
    }
    
    public void writeToFile(String filePath, String fileName, String strToWrite) throws IOException{
        
        String fullPath = defaultPath + filePath + fileName;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))) {
            
            writer.write(strToWrite);
        }
      
    }
    
    public void appendToFile(String path, String fileName, String strToAppend) throws IOException{
        String fullPath = defaultPath + path + fileName;
        BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath,true));
        writer.newLine();
        writer.write(strToAppend);
        writer.close();
    }
    
    public boolean checkIfFileExists(String path){
        String fullPath = defaultPath + path;
        File f = new File(fullPath);
        return f.exists();
    }
    
    public String[] readFromFile(String path, String fileName) throws FileNotFoundException, IOException{
       String fullPath = defaultPath + path + fileName;
        BufferedReader in = new BufferedReader(new FileReader(fullPath));
        String str = "";
        ArrayList<String> lines = new ArrayList<String>();
        while((str = in.readLine()) != null){
            lines.add(str);
        }
        String[] linesArray = lines.toArray(new String[lines.size()]);
        return linesArray;
        
    }
    
    public boolean deleteFile(String filePath, String fileName){
        String fullPath = defaultPath + filePath + fileName;
        File f = new File(fullPath);
        return f.delete();
    }
    
     public void createDirectory(String path, String folderName) throws IOException
    {
        String fullPath = defaultPath + path + folderName;
        Files.createDirectories(Paths.get(fullPath));
    }
    
}
    

