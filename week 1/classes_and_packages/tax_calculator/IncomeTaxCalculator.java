package incomeTax;
import java.util.*;

//Class for calculating income tax
class IncomeTaxCalculator {

	private double taxRateMale;
	private double taxRateFemale;

	IncomeTaxCalculator(double _taxRateMale,double _taxRateFemale){
		taxRateMale = _taxRateMale;
		taxRateFemale = _taxRateFemale;
	}

	//Calculates income tax and sets them to the employee objects
	public double calculateIncomeTax(Employee _employeeObj, double _taxRateMale, double _taxRateFemale){
		char employeeGender = _employeeObj.getGender();
		double employeeTaxableIncome = _employeeObj.getTaxableIncome(), employeeTaxAmount;

		//Calculating tax based on gender
		if(employeeGender == 'm')
			employeeTaxAmount = employeeTaxableIncome * _taxRateMale;
		else if(employeeGender == 'f')
			employeeTaxAmount = employeeTaxableIncome * _taxRateFemale;
		else{
			System.out.println("Wrong Gender name used for employee, using default as male...");
			employeeTaxAmount = employeeTaxableIncome * _taxRateMale;
		}
		//Setting tax amount to the employee object
		return employeeTaxAmount;
	}
	


	public static void main(String[] args) {
		String employeeNameResponse;
		double employeeTaxableIncomeResponse,incomeTaxRateMaleResponse,incomeTaxRateFemaleResponse,employeeTaxAmount;
		char userResponse,employeeGenderResponse;
		Scanner sc = new Scanner(System.in);

		//Creating a list for employees
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		boolean employeeFLag = false;

		//Accepting income tax rate
		System.out.println("Enter the income tax rate for males :- ");
		incomeTaxRateMaleResponse = sc.nextDouble();
		System.out.println("Enter the income tax rate for females :- ");
		incomeTaxRateFemaleResponse = sc.nextDouble();

		//Creating an IncomeTaxCalculator object, with the accepted rate
		IncomeTaxCalculator incomeTaxCalculatorObj = new IncomeTaxCalculator(incomeTaxRateMaleResponse, incomeTaxRateFemaleResponse);

		//Accepting Employee details
		do{
			System.out.println("Do you want to add employees?");
			userResponse = sc.next().charAt(0);
			if(userResponse == 'y'){
				System.out.println("Enter the name:- ");
				sc.nextLine();//Dummy scan to capture newline after previous scan
				employeeNameResponse = sc.nextLine();
				System.out.println("Enter the gender of the employee:- ");
				employeeGenderResponse = sc.next().charAt(0);
				System.out.println("Enter the taxable income of the employee:- ");
				employeeTaxableIncomeResponse = sc.nextDouble();

				//Creating an employee object, calculating tax and adding it to the employee list
				Employee employeeObj = new Employee(employeeNameResponse , employeeGenderResponse , employeeTaxableIncomeResponse);
				employeeTaxAmount = incomeTaxCalculatorObj.calculateIncomeTax(employeeObj , incomeTaxRateMaleResponse, incomeTaxRateFemaleResponse);
				employeeObj.setTaxAmount(employeeTaxAmount);
				employeeList.add(employeeObj);
				System.out.println("Created employee!");

			}
			else
				employeeFLag = true;
		}while(!employeeFLag);

		//Displaying employee details, after income tax calculation
		System.out.println("The Employee details are:- ");
		for(Employee employeeObj : employeeList){
			System.out.println(employeeObj.toDisplay());
		}
	}

}