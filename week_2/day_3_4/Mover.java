/*
Write a program to scan a directory and its sub directories and move all the files 
into a separate single directory. If a file with the same name is already present, 
the file name should be appended with the incremented number, eg, a.txt, a-1.txt, a-2.txt
*/
import java.nio.file.*;
import java.io.*;
import java.util.*;

//Mover class
public class Mover {
    Path sourceDirectory, destinationDirectory;

    //Initializing values for the object using constructor
    Mover(Path sourceDirectory, Path destinationDirectory){
        this.sourceDirectory = sourceDirectory;
        this.destinationDirectory = destinationDirectory;
    }

    //Calls move function with the initial directory
    public void moveFiles(){
        move(sourceDirectory);
    }

    //Move function recursively traverses the source directory, moving all files to the destination directory
    private void move(Path currentDirectory){
        try{
            DirectoryStream<Path> stream = Files.newDirectoryStream(currentDirectory);
            for (Path path: stream) {
                if(path.toFile().isDirectory()){
                    //A path in a directory is, itself a directory, then recursively traverse
                    move(path);
                }
                else{
                    //A path is a file
                    String fileName = path.getFileName().toString();
                    File baseDirectoryFile = new File(destinationDirectory.toString());
                    File newFile = new File(baseDirectoryFile,fileName);

                    //Test if a file with the same name exists in the destination folder
                    if(!newFile.exists()){
                        //If name does not exist, simply move the file
                        Files.move(path, destinationDirectory.resolve(fileName));
                    }
                    else{
                        boolean movedFile = false;
                        //Initially, number of files with the same name found is 1
                        int noOfFiles = 1;
                        do{
                            int extensionPosition=fileName.lastIndexOf(".");
                            if(extensionPosition == -1){
                                extensionPosition = fileName.length();
                            }
                            System.out.println(extensionPosition);
                            String fileNameWithoutExtensions = fileName.substring(0, extensionPosition);
                            
                            String extension = fileName.substring(extensionPosition);
                            int countPosition = fileNameWithoutExtensions.lastIndexOf("-");

                            //Test if the filename already has an incremented value
                            if(countPosition == -1){
                                //If it does not, create a new filename
                                fileName = fileNameWithoutExtensions + "-" + noOfFiles + extension;
                            }
                            else{
                                //If it already has an incremented value, increment it by 1,and create a new filename
                                noOfFiles = Integer.parseInt(fileNameWithoutExtensions.substring(countPosition + 1)) + 1;
                                fileName = fileNameWithoutExtensions.substring(0,countPosition) + "-" + noOfFiles + extension;
                            }
                            
                            //Test if the new filname exists
                            File newFile2 = new File(baseDirectoryFile,fileName);
                            if(!newFile2.exists()){
                                Files.move(path, destinationDirectory.resolve(fileName));
                                movedFile = true;
                            }
                            
                            //If filename does not exists the loop repeats , with the new filename
                        }while(!movedFile);
                    }       
                }
            }
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Path sourceDirectory = Paths.get(args[0]).toAbsolutePath(), destinationDirectory = Paths.get(args[1]).toAbsolutePath();
        Mover m = new Mover(sourceDirectory, destinationDirectory);
        m.moveFiles();
    }
}