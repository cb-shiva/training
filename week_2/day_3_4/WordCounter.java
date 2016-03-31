/*
Write a program which reads a text file. List all the words in alphabetical order 
with number of occurrence for each word and write the list into another text file 
in the format [word]:[number of times it occurred].
*/
import java.io.*;
import java.util.*;

//WordCounter class
public class WordCounter {
    private HashMap<String,Integer> count;
    private String inputFileName;

    //Initializing values for the object using constructor
    WordCounter(String inputFileName){
        this.inputFileName = inputFileName;
        count = new HashMap<String,Integer>();
        count();
        writeCount();
    }

    //Function adds a word to the dictionary, and increments the count if the word already exists
    private void addWord(String key){
        int currentCount;
        if(count.get(key) != null){
            currentCount = count.get(key);
            count.put(key, currentCount + 1);
        }
        else{
            count.put(key,1);
        }
    }

    //Function scans the input file, and counts each word in the file
    private void count(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFileName));
            String line = br.readLine();
            while (line != null) {
                String[] lineWords = line.split(" ");
                for(String word : lineWords){
                    addWord(word);
                }
                line = br.readLine();
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Testing function which displays the dictionary
    private void displayCount(){
        for(Map.Entry m : count.entrySet()){
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }

    //Writes the word count in a file with the name appended with '_word_count_log'
    private void writeCount(){
        try {
            int extensionPosition = inputFileName.lastIndexOf(".");
            String fileNameWithoutExtensions = inputFileName.substring(0, extensionPosition);
            String extension = inputFileName.substring(extensionPosition);
            PrintWriter pw = new PrintWriter(new FileWriter(fileNameWithoutExtensions + "_word_count_log" + extension),false);
            SortedSet<String> keys = new TreeSet<String>(count.keySet());
            for(String key : keys){
                pw.write("[" + key + "]:[" + count.get(key) +"]\n");
            }
            pw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Main function
    public static void main(String[] args) {
        String inputFileName = args[0];
        WordCounter wc = new WordCounter(inputFileName);
    }
}