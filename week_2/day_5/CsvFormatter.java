package csvformatter;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;
import org.json.simple.parser.*;
import org.json.simple.*;

public class CsvFormatter {
    private String inputFileName;
    private final Object [] CSVHeaders = {"Customer Id","Subscription Id","Invoice Id","Invoice Date","Start Date",
                            "Amount","Status","Paid On","Next Retry","Refunded Amount","Recurring",
                            "First Invoice","Tax Total","Customer Details"};

    CsvFormatter(String inputFileName){
        this.inputFileName = inputFileName;
    }

    //Returns the list of csv records in the input csv file 
    private List<CSVRecord> getCsvRecords() throws IOException{
        Reader in = new FileReader(inputFileName);
        CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT.withHeader());
        return parser.getRecords();
    }

    //Returns the output file name
    private String getNewFileName(){
        int extensionPosition=inputFileName.lastIndexOf(".");
        String fileNameWithoutExtensions = inputFileName.substring(0, extensionPosition);
        return (fileNameWithoutExtensions + "_formatted.csv");
    }

    //Creates the new output file, with the modified csv records
    public void createOutputFile() throws IOException{
        String firstName, lastName, email, customerCompany;
        BufferedWriter bw = new BufferedWriter(new FileWriter(getNewFileName()));
        CSVPrinter csvFilePrinter = new CSVPrinter(bw, CSVFormat.DEFAULT);
        csvFilePrinter.printRecord(CSVHeaders);

        List<CSVRecord> csvRecords = getCsvRecords();
        for (CSVRecord record : csvRecords) {

            //parsing the csv record
            firstName = record.get("Customer First Name");
            lastName = record.get("Customer Last Name");
            email = record.get("Customer Email");
            customerCompany = record.get("Customer Company");
            List customerRecord = new ArrayList();
            customerRecord.add(record.get("Customer Id"));
            customerRecord.add(record.get("Subscription Id"));
            customerRecord.add(record.get("Invoice Number"));
            customerRecord.add(record.get("Invoice Date"));
            customerRecord.add(record.get("Start Date"));
            customerRecord.add(record.get("Amount"));
            customerRecord.add(record.get("Status"));
            customerRecord.add(record.get("Paid On"));
            customerRecord.add(record.get("Next Retry"));
            customerRecord.add(record.get("Refunded Amount"));
            customerRecord.add(record.get("Recurring"));
            customerRecord.add(record.get("First Invoice"));
            customerRecord.add(record.get("Tax Total"));

            //Creating json string
            JSONObject obj = new JSONObject();
            obj.put("First Name", firstName);
            obj.put("Last Name", lastName);
            obj.put("Email", email);
            obj.put("Company", customerCompany);
            customerRecord.add(obj.toString());
            csvFilePrinter.printRecord(customerRecord);
        }
        bw.close();
        csvFilePrinter.close();
    }


    public static void main(String[] args) throws IOException{
        CsvFormatter cf = new CsvFormatter(args[0]);
        cf.createOutputFile();
    }
}