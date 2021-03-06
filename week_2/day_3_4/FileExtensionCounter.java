/*
Write a program to scan a directory and its sub directories and print all the file extensions
along with the number of files with that extension.
*/
import java.nio.file.*;
import java.io.*;
import java.util.*;

//ExtensionCounter class
public class FileExtensionCounter {
    //HashMap object for storing the extension counts
    private HashMap<String,Integer> extensionCount;
    private Path inputDirectory;

    //Initializing the HashMap object
    FileExtensionCounter(Path inputDirectory){
        this.inputDirectory = inputDirectory;
        extensionCount = new HashMap<String,Integer>();
        traverse(inputDirectory);
    }

    //Function for adding an extension to the count
    private void add(String key){
        int currentCount;
        if(extensionCount.get(key) != null){
            currentCount = extensionCount.get(key);
            extensionCount.put(key, currentCount + 1);
        }
        else{
            extensionCount.put(key,1);
        }
    }

    //Function for displaying the ExtensionCount HashMap values
    public void displayCount(){
        for(Map.Entry m : extensionCount.entrySet()){
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }

    //Function for recursively traversing the given directory
    private void traverse(Path currentDirectory) {
        try{
            DirectoryStream<Path> stream = Files.newDirectoryStream(currentDirectory);
            for (Path path: stream) {
                if(path.toFile().isDirectory()){
                    traverse(path);
                }
                else{
                    String fileName = path.getFileName().toString(), extension = "no extension";
                    int i = fileName.lastIndexOf('.');
                    if (i >= 0){
                        extension = fileName.substring(i);
                    }
                    add(extension);
                }
            }
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    //Main fuction for taking user input, creating a FileExtensionCounter object, and running the count
    public static void main(String[] args) {
        Path userInput = Paths.get(args[0]).toAbsolutePath();
        FileExtensionCounter f = new FileExtensionCounter(userInput);
        f.displayCount();
    }

}