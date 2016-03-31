package phonedirectory;
import java.util.*;

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

	//Main class for console input
	public static void main(String[] args) {
		//Creating a PhoneDirectory object
		PhoneDirectory pd = new PhoneDirectory();
		char userResponse,tagResponse;
		String nameResponse,phoneNoResponse,addressResponse,tag;
		//Boolean variables for controlling input loops
		boolean phoneNoFlag = false, personFlag = false, searchFlag = false;
		//Loop for adding people to the phone directory
		do{
			System.out.println("Add People?[y/n]");
			userResponse = System.console().readLine().charAt(0);
			if(userResponse == 'y'){
				System.out.println("Enter the name:-");
				nameResponse = System.console().readLine();
				System.out.println("Enter the address:- ");
				addressResponse = System.console().readLine();
				ArrayList<PhoneNo> phoneNoList = new ArrayList<PhoneNo>();

				//Loop for adding phone nos for each person
				do{
					System.out.println("Add phone numbers?[y/n]");
					userResponse = System.console().readLine().charAt(0);
					if(userResponse == 'y'){
						System.out.print("Enter the number:- ");
						phoneNoResponse = System.console().readLine();
						
						System.out.println("Choose the tag:- ");
						System.out.println("1.Home\n2.Mobile\n3.Work");
						tagResponse = System.console().readLine().charAt(0);
						switch(tagResponse){
							case '1':{
								tag = "Home";
								break;
							}
							case '2':{
								tag = "Mobile";
								break;
							}
							case '3':{
								tag = "Work";
								break;
							}
							default:{
								tag = "Home";
								break;
							}
						}
						PhoneNo phoneObj = new PhoneNo(phoneNoResponse,tag);
						phoneNoList.add(phoneObj);
						
					}
					else{
						phoneNoFlag = true;
					}
				}while(!phoneNoFlag);
				//End of phone number loop
				//Creating a person object and making mappings in the dictionary
				Person personObj = new Person(nameResponse,addressResponse,phoneNoList);
				pd.addPerson(personObj);
			}
			else{
				personFlag = true;
			}
		}while(!personFlag);
		//End of loop for adding people

		//Accepting user input for search criteria
		do{
			System.out.println("-----------------------------------------");
			System.out.println("Search by:- ");
			System.out.println("1.Name\n2.Number\n3.Exit");
			userResponse = System.console().readLine().charAt(0);

			if(userResponse == '1'){
				//Search by name
				System.out.println("Enter the name:- ");
				nameResponse = System.console().readLine();
				pd.searchByName(nameResponse);	
			}
			else if(userResponse == '2'){
				//Search by number
				System.out.println("Enter the number:- ");
				phoneNoResponse = System.console().readLine();
				pd.searchByNumber(phoneNoResponse);
			}
			else if(userResponse == '3'){
				searchFlag = true;
			}
		}while(!searchFlag);
	}
}