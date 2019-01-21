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

/**
 * Class to handle all things related to files
 * @author matthewmchale
 */
public class FileHandling {
    
    public boolean createFile(String fileName) throws IOException{
        File f = new File(fileName);
        return f.createNewFile();
    }
    
    public String writeToFile(String fileName) throws IOException{
        String str = "hello";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            
            writer.write(str);
        }
        return str;
    }
    
    public void appendToFile(){
        return;
    }
    
    public boolean checkIfFileExists(String path){
        File f = new File(path);
        return f.exists();
    }
    
    public String readFromFile(String fileName) throws FileNotFoundException, IOException{
        String line;
        try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
            line = read.readLine();
        }
        System.out.println("line is this " + " " + line);
        return line;
    }
    
    public boolean deleteFile(String fileName){
        File f = new File(fileName);
        return f.delete();
    }
    
}
