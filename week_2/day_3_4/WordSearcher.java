/*
Search and Write program. Write a program that would take in a text file and a search word as input. 
The program should write an output file with the line number and the start indices of the search term 
in that line in the format <line-no>:<start-index-1>,<start-index-2>.
 The name of the output file should be the <search-word>.locations.
*/
import java.io.*;
import java.util.*;

//Word searcher class
public class WordSearcher {
    private String inputWord, inputFileName;

    //Initializing values for the object using constructor
    WordSearcher(String inputFileName, String inputWord){
        this.inputWord = inputWord;
        this.inputFileName = inputFileName;
        searchAndWritePerfectMatch();
    }

    //Looks for the word in the line by splitting a line into a list of words seperated by spaces
    private void searchAndWritePerfectMatch(){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(inputWord+".locations"),false);
            BufferedReader br = new BufferedReader(new FileReader(inputFileName));
            String line = br.readLine();
            int lineCount = 1, wordSize = inputWord.length();
            while (line != null) {
                int indexCount = 0;
                String[] lineWords = line.split(" ");
                pw.write("Line: "+lineCount + " ");
                for(String word : lineWords){
                    if(word.trim().equals(inputWord)){
                        pw.write(indexCount+",");
                    }
                    indexCount = indexCount + word.length() + 1;
                }
                pw.write("\n");
                lineCount = lineCount + 1;
                line = br.readLine();
            }
            pw.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WordSearcher wc = new WordSearcher(args[0], args[1]);   
    }
}