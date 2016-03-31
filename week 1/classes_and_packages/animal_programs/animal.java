package animals;
public class animal{	
	int noOfLegs;
	String species;
	String animalName;
	String color;

	public animal(){
		noOfLegs = 2;
		species = "homo sapiens";
		animalName = "Man";
		color = "skin";
	}

	public void setLegs(int _noOfLegs){
		noOfLegs=_noOfLegs;
	}

	public void setSpecies(String _species){
		species=_species;
	}

	public void setAnimalName(String _animalName){
		animalName=_animalName;
	}

	public void setColor(String _color){
		color=_color;
	}
}