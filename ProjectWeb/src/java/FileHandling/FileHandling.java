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
        String[] doc = {""};
        int counter = 0;
        String line;
        try (Scanner scan = new Scanner(new File(fileName))) {
            while(scan.hasNextLine()){
            line = scan.nextLine();
            doc[counter] = line;
            counter ++;
            }
        }
        return doc;
    }
    
    public boolean deleteFile(String fileName){
        File f = new File(fileName);
        return f.delete();
    }
    
}
