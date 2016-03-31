package phonedirectory;
import java.util.*;
import java.io.*;
import org.json.simple.parser.*;
import org.json.simple.*;
//Class ModifiedHashMap , used because multiple values per key need to be stored in the hash table
class ModifiedHashMap{
	private HashMap<String,ArrayList<Person>> map;

	ModifiedHashMap(){
		map = new HashMap<String,ArrayList<Person>>();
	}

	public ArrayList<Person> get(String name){
		return map.get(name);
	}

	public void put(String key, Person value){
		ArrayList<Person> list = map.get(key);
		if(list == null){
			list = new ArrayList<Person>();
			list.add(value);
		}
		else {
			list.add(value);
		}
		map.put(key,list);
	}
};

//Main class PhoneDirectory
public class PhoneDirectory{
	private ModifiedHashMap nameMap, phoneNoMap;

	//Constructor for initializing instance variables
	PhoneDirectory(){
		nameMap = new ModifiedHashMap();
		phoneNoMap = new ModifiedHashMap();
	}

	//Function to create necessary mappings
	public void addPerson(Person personObj){
		//Adding name mapping
		for (String partialName : personObj.getName().split(" ")) {
			nameMap.put(partialName, personObj);
		}
		//Adding phone number mapping
		ArrayList<PhoneNo> phoneNoList = personObj.getPhoneNoList();
		for (PhoneNo phoneNo : phoneNoList) {
			phoneNoMap.put(phoneNo.getNumber(),personObj);
		}
	}

	public void searchByName(String name){
		for(String partialName : name.split(" ")){
			ArrayList<Person> matchList = nameMap.get(partialName);
			if(matchList != null){
				for(Person p: matchList){
					System.out.println(p.toDisplay());
				}
			}
			else{
				System.out.println("No result found!!!");
			}
		}
	}

	public void searchByNumber(String number){
		ArrayList<Person> matchList = phoneNoMap.get(number);
		if(matchList != null){
			for(Person p: matchList){
				System.out.println(p.toDisplay());
			}
		}
		else{
			System.out.println("No result found!!!");
		}
	}

    //Console menu for searching by name or number
    public void searchMenu(){
        boolean searchFlag = false;
        char userResponse;
        String  nameResponse, phoneNoResponse;
        do{
            System.out.println("-----------------------------------------");
            System.out.println("Search by:- ");
            System.out.println("1.Name\n2.Number\n3.Exit");
            userResponse = System.console().readLine().charAt(0);

            if(userResponse == '1'){
                System.out.println("Enter the name:- ");
                nameResponse = System.console().readLine();
                searchByName(nameResponse); 
            }
            else if(userResponse == '2'){
                System.out.println("Enter the number:- ");
                phoneNoResponse = System.console().readLine();
                searchByNumber(phoneNoResponse);
            }
            else if(userResponse == '3'){
                searchFlag = true;
            }
        }while(!searchFlag);
    }

}