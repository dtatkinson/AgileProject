/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandling;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to handle all things related to files
 * @author matthewmchale
 */
public class FileHandling {
    
    public boolean createFile(String fileName) throws IOException{
        File f = new File(fileName);
        return f.createNewFile();
    }
    
    public void writeToFile(String fileName,String strToWrite) throws IOException{
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            
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
        String str = null;
        ArrayList<String> lines = new ArrayList<String>();
        while((str = in.readLine()) != null){
            lines.add(str);
        }
        String[] linesArray = lines.toArray(new String[lines.size()]);
        return linesArray;
        
    }
    
    public boolean deleteFile(String fileName){
        File f = new File(fileName);
        return f.delete();
    }
    
}
