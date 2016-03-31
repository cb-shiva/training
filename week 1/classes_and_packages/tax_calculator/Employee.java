package incomeTax;

//Class for employee objects
class Employee {
	private String name;
	private char gender;
	private double taxableIncome,taxAmount;

	Employee(String _name, char _gender, double _taxableIncome){
		name = _name;
		gender = _gender;
		taxableIncome = _taxableIncome;
	}

	//Functions for retrieving data
	public char getGender(){
		return gender;
	}

	public double getTaxableIncome(){
		return taxableIncome;
	}

	//Functions for setting instance variables
	public void setTaxAmount(double _taxAmount){
		taxAmount = _taxAmount;
	}

	//Function to return the string to display for an employee
	public String toDisplay(){
		return String.format("%s | %c | %.2f | %.2f",name ,gender ,taxableIncome ,taxAmount);
	}
}