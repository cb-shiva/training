/*
Create classes animal, mammal & bird and its sub classes for bat, dog, cow, ostrich & parrot. 
You should create instances for these classes based on the user input. 
The movement method should print the mode of locomotion. 
Should use abstract methods, overriding etc. 
You should add the instances to the list and be able to print when asked. 
Should be able to list all the added animals that can fly. 
Similarly, should be able to list all the added animals that are herbivores. 
Use interfaces to mark the traits like herbivorous, can fly, etc.
*/
import java.util.*;

//Interface with animal properties
interface animalProperties{
	public void makesNoise();
	public void movement();
	public void setHerbivorous(boolean _herbivorous);
	public void setFlying(boolean _canFly);
	public void setNocturnal(boolean _nocturnal);
	public void setName(String _name);
	public void setNoOfLegs(int _noOfLegs);
	public boolean isHerbivorous();
	public boolean canFly();
	public int noOfLegs();
};

//Base class animal
abstract class animal implements animalProperties{
	private String name;
	private int noOfLegs;
	private boolean herbivorous;
	private boolean canFly;
	private boolean nocturnal;

	public void description(){
		System.out.println("I am an animal");
	}

	//Functions for setting private instance variables
	public void setHerbivorous(boolean _herbivorous){
		herbivorous = _herbivorous;
	}

	public void setFlying(boolean _canFly){
		canFly = _canFly;
	}

	public void setNocturnal(boolean _nocturnal){
		nocturnal = _nocturnal;
	}

	public void setName(String _name){
		name = _name;
	}

	public void setNoOfLegs(int _noOfLegs){
		noOfLegs = _noOfLegs;
	}

	//Functions to access state variables
	public boolean canFly(){
		return canFly;
	}

	public boolean isHerbivorous(){
		return herbivorous;
	}
	public int noOfLegs(){
		return noOfLegs;
	}
	public String getName(){
		return name;
	}

	//Abstract functions to be implemented by sub classes
	public abstract void makesNoise();
	public abstract void movement();
};


class mammal extends animal{
	public void description(){
		System.out.println("I am a mammal");
	}
	public void movement(){
		System.out.println("Lives on land");
	}
	public void makesNoise(){
		System.out.println("Mammal noise");
	}
};



class bird extends animal{
	bird(){
		setHerbivorous(true);
		setNocturnal(false);
		setFlying(true);
	}
	//Methods overriding base class methods
	public void description(){
		System.out.println("I am a bird");
	}
	public void movement(){
		System.out.println("Lives on trees");
	}
	public void makesNoise(){
		System.out.println("Bird noise");
	}
};

class bat extends mammal{
	bat(String _name){
		setName(_name);
		setNocturnal(true);
		setFlying(true);
		setHerbivorous(false);
	}
	//Methods overriding base class methods
	public void description(){
		System.out.println("I am a bat");
	}
	public void movement(){
		System.out.println("Lives on trees");
	}
	public void makesNoise(){
		System.out.println("... ...!!");
	}
};


class dog extends mammal{
	dog(String _name){
		setName(_name);
		setNocturnal(false);
		setFlying(false);
		setHerbivorous(false);
	}
	//Methods overriding base class methods
	public void description(){
		System.out.println("I am a dog");
	}
	public void movement(){
		System.out.println("Lives on land");
	}
	public void makesNoise(){
		System.out.println("Bow bow!!");
	}

};
class cow extends mammal{
	cow(String _name){
		setName(_name);
		setNocturnal(false);
		setFlying(false);
		setHerbivorous(true);
	}
	//Methods overriding base class methods
	public void description(){
		System.out.println("I am a cow");
	}
	public void movement(){
		System.out.println("Lives on land");
	}
	public void makesNoise(){
		System.out.println("Mooo!!");
	}
};
class ostrich extends bird{
	ostrich(String _name){
		setName(_name);
		setNocturnal(false);
		setFlying(false);
		setHerbivorous(true);
	}
	//Methods overriding base class methods
	public void description(){
		System.out.println("I am an ostrich");
	}
	public void movement(){
		System.out.println("Lives on land");
	}
	public void makesNoise(){
		System.out.println("caaa!!");
	}
};
class parrot extends bird{
	parrot(String _name){
		setName(_name);
		setNocturnal(false);
		setFlying(true);
		setHerbivorous(true);
	}
	//Methods overriding base class methods
	public void description(){
		System.out.println("I am a parrot");
	}
	public void movement(){
		System.out.println("Lives on land");
	}
	public void makesNoise(){
		System.out.println("chip chip!!");
	}
};
public class animalMaker{
	public static void main(String[] args) {
		String nameResponse;
		char userResponse;
		boolean animalFlag = false;

		//Creating a list of animals
		ArrayList<animal> animalList = new ArrayList<animal>(); 
		Scanner sc =  new Scanner(System.in);
		do{
			System.out.println("Do you want to add an animal?");
			userResponse = sc.next().charAt(0);
			if(userResponse == 'y'){
				System.out.println("Choose the type of the animal:- ");
				System.out.println("1.bat\n2.dog\n3.ostrich\n4.parrot\n5.cow");
				userResponse = sc.next().charAt(0);
				System.out.println("Enter the name(species) of your animal:- ");
				sc.nextLine();
				nameResponse = sc.nextLine();
				
				//Creating the animal object based on the response
				switch (userResponse) {
					case '1':{
						bat batObj = new bat(nameResponse);
						System.out.print(nameResponse +" says ");
						batObj.makesNoise();
						animalList.add(batObj);
						break;
					}
					case '2':{
						dog dogObj = new dog(nameResponse);
						System.out.print(nameResponse +" says ");
						dogObj.makesNoise();
						animalList.add(dogObj);
						break;
					}
					case '3':{
						ostrich ostrichObj = new ostrich(nameResponse);
						System.out.print(nameResponse +" says ");
						ostrichObj.makesNoise();
						animalList.add(ostrichObj);
						break;
					}
					case '4':{
						parrot parrotObj = new parrot(nameResponse);
						System.out.print(nameResponse +" says ");
						parrotObj.makesNoise();
						animalList.add(parrotObj);
						break;
					}
					case '5':{
						cow cowObj = new cow(nameResponse);
						System.out.print(nameResponse +" says ");
						cowObj.makesNoise();
						animalList.add(cowObj);
						break;
					}
				}
			}
			else if (userResponse == 'n')
				animalFlag = true;
			else{
				animalFlag = true;
				System.out.println("Invalid response, breaking out");
			}
		}while(!animalFlag);

		//Testing animal objects for properties
		System.out.println("The herbivorous animals are :- ");
		for (animal animalObj : animalList) {
			if(animalObj.isHerbivorous())
				System.out.print(animalObj.getName()+" ");
		}
		System.out.println();

		System.out.println("The animals that can fly are :- ");
		for (animal animalObj : animalList) {
			if (animalObj.canFly()) {
				System.out.print(animalObj.getName()+" ");
			}
		}
		System.out.println();

	}
}

