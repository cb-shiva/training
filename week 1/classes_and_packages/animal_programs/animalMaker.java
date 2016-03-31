import java.util.*;
import animals.animal;

class animalMaker{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<animal> animalList = new ArrayList<animal>();
		do{
			animal animalObj = new animal();

			//Accepts animal details
			System.out.println("Please enter the details for the animal:- ");
			System.out.print("Name:-  ");
			animalObj.setAnimalName(sc.next());
			System.out.print("Species:-  ");
			animalObj.setSpecies(sc.next());
			System.out.print("No of legs:-  ");
			animalObj.setLegs(sc.nextInt());
			System.out.print("Color:-   ");
			animalObj.setColor(sc.next());

			//Adds animal to animal list
			animalList.add(animalObj);
			System.out.println("Do you want to create another animal?");
		} while(sc.next().charAt(0) == 'y');
	}
}