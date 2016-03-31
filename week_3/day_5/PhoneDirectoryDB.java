import java.sql.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;
public class PhoneDirectoryDB{

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/phone_directory?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";
    private Connection con;
    private String inputFileName;
    
    PhoneDirectoryDB(String inputFileName) throws Exception{
        this.inputFileName = inputFileName;
        Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(DB_URL,USER,PASS);
    }

    //Returns the list of csv records in the input csv file 
    private List<CSVRecord> getCsvRecords() throws IOException{
        Reader in = new FileReader(inputFileName);
        CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT.withHeader());
        return parser.getRecords();
    }

    //Adds the csv tuples into the database
    public void createDatabase() throws Exception{  
        List<CSVRecord> csvRecords = getCsvRecords();
        PreparedStatement insertStmt = con.prepareStatement("insert into phone_book values (?,?,?,?,?)");
        for (CSVRecord record : csvRecords) {
            insertStmt.clearParameters();
            insertStmt.setString(1,record.get("name")); 
            insertStmt.setString(2,record.get("address"));
            insertStmt.setString(3,record.get("mobile_number"));
            insertStmt.setString(4,record.get("home_number"));
            insertStmt.setString(5,record.get("work_number"));
            insertStmt.executeUpdate();        
        }
    }

    //Displays all rows which have partial name match
    private void searchByName(String name) throws Exception{
        PreparedStatement nameQuery = con.prepareStatement("Select * from phone_book where name like ?");
        nameQuery.setString(1,"%" + name + "%");
        ResultSet rs = nameQuery.executeQuery();
        while(rs.next()){
            System.out.println("Name:- " + rs.getString("name"));
            System.out.println("Address:- " + rs.getString("address"));
            System.out.println("Mobile number:- " + rs.getString("mobile_number"));
            System.out.println("Home number:- " + rs.getString("home_number"));
            System.out.println("Work number:- " + rs.getString("work_number"));
            System.out.println();
        }
    }

    //Displays all rows which have a number match
    private void searchByNumber(String number) throws Exception{
        PreparedStatement numberQuery = con.prepareStatement("Select * from phone_book where mobile_number like ? or home_number like ? or work_number like ?");
        numberQuery.setString(1,number);
        numberQuery.setString(2,number);
        numberQuery.setString(3,number);
        ResultSet rs = numberQuery.executeQuery();
        while(rs.next()){
            System.out.println("Name:- " + rs.getString("name"));
            System.out.println("Address:- " + rs.getString("address"));
            System.out.println("Mobile number:- " + rs.getString("mobile_number"));
            System.out.println("Home number:- " + rs.getString("home_number"));
            System.out.println("Work number:- " + rs.getString("work_number"));
            System.out.println();
        }
    }

    //Updates the table based on argument values
    private void addNumber(String name,String number,String tag) throws Exception{
        PreparedStatement addStmt;
        if(tag.equals("1")){
            addStmt = con.prepareStatement("update phone_book set mobile_number = ? where name like ?");
        }
        else if (tag.equals("2")) {
            addStmt = con.prepareStatement("update phone_book set home_number = ? where name like ?");
        }
        else if (tag.equals("3")) {
            addStmt = con.prepareStatement("update phone_book set work_number = ? where name like ?");
        }
        else{
            System.out.println("Wrong input");
            return;
        }
        addStmt.setString(1,number);
        addStmt.setString(2,name);
        addStmt.executeUpdate();
    }

	//Console menu for searching by name or number
    private void searchMenu() throws Exception {
        boolean searchFlag = false;
        char userResponse;
        String  nameResponse, phoneNoResponse, tagResponse, tag;
        do{
            System.out.println("-----------------------------------------");
            System.out.println("1.Search by Name\n2.Search by Number:-\n3.Update numbers\n4.Exit");
            userResponse = System.console().readLine().charAt(0);

            if(userResponse == '1'){
                System.out.println("Enter the name:- ");
                nameResponse = System.console().readLine();
                System.out.println("The results are:- ");
                searchByName(nameResponse); 
            }
            else if(userResponse == '2'){
                System.out.println("Enter the number:- ");
                phoneNoResponse = System.console().readLine();
                System.out.println("The results are:- ");
                searchByNumber(phoneNoResponse);
            }
            else if(userResponse == '3'){
                System.out.println("Enter the name:- ");
                nameResponse = System.console().readLine();
                System.out.println("Enter the new number:- ");
                phoneNoResponse = System.console().readLine();
                System.out.println("Enter the tag:-");
                System.out.println("\t1.mobile_number");
                System.out.println("\t2.home_number");
                System.out.println("\t3.work_number");
                tagResponse = System.console().readLine();
                System.out.println(tagResponse);
                addNumber(nameResponse,phoneNoResponse,tagResponse);
                System.out.println("Updated number");
            }
            else if(userResponse == '4'){
                searchFlag = true;
            }
        }while(!searchFlag);
    }

	public static void main(String[] args) throws Exception{
		PhoneDirectoryDB pDB = new PhoneDirectoryDB(args[0]);
        pDB.createDatabase();
        pDB.searchMenu();
	}
}