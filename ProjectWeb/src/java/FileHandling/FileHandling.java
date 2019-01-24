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
 * Reviewed by DavidAtkinson
 */
public class FileHandling {
    //default file path
    String defaultPath = "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\";
    
   /**
    * Method to create file
    * @param filePath
    * @param fileName
    * @return
    * @throws IOException 
    */
    public boolean createFile(String filePath,String fileName) throws IOException{
        String fullPath = defaultPath + filePath + fileName;
        String path = filePath + fileName;
        //need to make some sort of catch if file already exists
        if(checkIfFileExists(path)){
            return false;
        }
        else
        {
        System.out.println(fullPath);
        File f = new File(fullPath);
        return f.createNewFile();
        }
    }
    
    /**
     * Method to write to file
     * @param filePath
     * @param fileName
     * @param strToWrite
     * @throws IOException 
     */
    public void writeToFile(String filePath, String fileName, String strToWrite) throws IOException{
        
        String fullPath = defaultPath + filePath + fileName;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))) {
            
            writer.write(strToWrite);
        }
      
    }
    
    /**
     * Method to append to file
     * @param path 
     * @param fileName
     * @param strToAppend
     * @throws IOException 
     */
    public void appendToFile(String path, String fileName, String strToAppend) throws IOException{
        String fullPath = defaultPath + path + fileName;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath,true))) {
            writer.newLine();
            writer.write(strToAppend);
        }
    }
    
    /**
     * Method to check if a file exists
     * @param path
     * @return 
     */
    public boolean checkIfFileExists(String path){
        String fullPath = defaultPath + path;
        File f = new File(fullPath);
        return f.exists();
    }
    
    /**
     * Method to read from file
     * @param path
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
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
    
    /**
     * Method to delete a file
     * @param filePath
     * @param fileName
     * @return 
     */
    public boolean deleteFile(String filePath, String fileName){
        String fullPath = defaultPath + filePath + fileName;
        File f = new File(fullPath);
        return f.delete();
    }
    
    /**
     * Method to create a directory
     * @param path
     * @param folderName
     * @throws IOException 
     */
     public void createDirectory(String path, String folderName) throws IOException
    {
        String fullPath = defaultPath + path + folderName;
        Files.createDirectories(Paths.get(fullPath));
    }
    
}
    

