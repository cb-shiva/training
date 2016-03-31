/*Given an input CSV file, write a program to output a new CSV file with all the duplicate lines removed.*/
import org.apache.commons.csv.*;
import java.util.*;
import java.io.*;
public class CsvDuplicateRemover {
    private String inputFileName;
    public ArrayList<String> CSVheaders;

    //Main class constructor
    CsvDuplicateRemover(String inputFileName) throws IOException{
        this.inputFileName = inputFileName;
        CSVheaders = new ArrayList<String>(); 
    }

    public void remove() throws IOException{
        readCsvHeaders();
        removeDuplicates();
    }

    //Reads the headers from the file
    private void readCsvHeaders() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(inputFileName));
        String headerLine = br.readLine();
        for(String header : headerLine.split(",")){
            CSVheaders.add(header);
        }
        br.close();
    }

    //returns the new file's name
    private String getNewFileName(){
        int extensionPosition=inputFileName.lastIndexOf(".");
        String fileNameWithoutExtensions = inputFileName.substring(0, extensionPosition);
        return fileNameWithoutExtensions + "_without_dups.csv";
    }

    //Function to verify if a duplicate of the record exists
    private boolean contains(List<CSVRecord> recordList,CSVRecord recordToCheck){
        //Check each record against the input record
        for(CSVRecord record : recordList){
            //Ignore the case where the record is compared with itself
            if(record != recordToCheck){
                boolean containsFlag = true;
                for(String header : CSVheaders){
                    //If there is a mismatch in any row, set contains to false and break out
                    if(!(record.get(header).equals(recordToCheck.get(header)))) {
                        containsFlag = false;
                        break;
                    }
                }
                //If there is no mismatch return true
                if(containsFlag){
                    return true;
                }
            }
        }
        return false;
    }

    //Function to remove duplicates
    private void removeDuplicates() {
        try{

            BufferedWriter bw = new BufferedWriter(new FileWriter(getNewFileName()));
            CSVPrinter csvFilePrinter = new CSVPrinter(bw, CSVFormat.DEFAULT);
            csvFilePrinter.printRecord(CSVheaders);

            Reader in = new FileReader(inputFileName);
            CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT.withHeader());
            List<CSVRecord> csvRecords = parser.getRecords();
            Iterator<CSVRecord> csvRecordIterator = csvRecords.iterator();
            while(csvRecordIterator.hasNext()){
                CSVRecord record = csvRecordIterator.next();
                if (contains(csvRecords,record)){
                    csvRecordIterator.remove();
                }
                else{
                    csvFilePrinter.printRecord(record);
                }
            }
            bw.close();
            csvFilePrinter.close();
            //createOutputFile(csvRecords);   
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
       
    public static void main(String[] args) throws IOException{
        CsvDuplicateRemover cd = new CsvDuplicateRemover(args[0]);
        cd.remove();
    }
}