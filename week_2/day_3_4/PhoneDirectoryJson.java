/*
Phone Directory. Here instead of the input as multidimensional array, 
construct a Json file with address & phone details and write program to read 
the Json file and load them into collections.
*/
package phonedirectory;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;
import org.json.simple.parser.*;
import org.json.simple.*;

public class PhoneDirectoryJson extends PhoneDirectory{
	private PhoneDirectory pd;
	private String inputFileName;

	PhoneDirectoryJson(String inputFileName){
		pd = new PhoneDirectory();
		this.inputFileName = inputFileName;
	}

	//Function reads the input file into a string
    public static String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void createPhoneBook() throws ParseException{
    	boolean searchFlag = false;
		String nameResponse, phoneNoResponse;
		char userResponse;
		String name, address, number, tag;
		
        //Parsing the json file
		JSONParser parser = new JSONParser();
        String jsonData = readFile(inputFileName);
        Object fullObj = parser.parse(jsonData);
        JSONArray fulljson = (JSONArray) fullObj;
        Iterator<JSONObject> personIter = fulljson.iterator();
        while(personIter.hasNext()){
            JSONObject personObject = personIter.next();
            name = (String) personObject.get("name");
            address = (String) personObject.get("address");
            JSONArray phoneNoArray = (JSONArray) personObject.get("phone_numbers");
            Iterator<JSONObject> phoneNoIter = phoneNoArray.iterator();
            ArrayList<PhoneNo> phoneNoList = new ArrayList<PhoneNo>();
            while(phoneNoIter.hasNext()){
            	JSONObject phoneNoObj = (JSONObject) phoneNoIter.next();
            	number = (String) phoneNoObj.get("Number");
            	tag = (String) phoneNoObj.get("Tag");
            	phoneNoList.add(new PhoneNo(number, tag));
            }
            addPerson(new Person(name,address,phoneNoList));
        }

    }

	public static void main(String[] args) throws ParseException{
		PhoneDirectoryJson pdj = new PhoneDirectoryJson(args[0]);
		pdj.createPhoneBook();
        pdj.searchMenu();
	}
}