//Calculates the simple and compound interes, given the amount, rate and time
import java.util.Scanner;
class interestCalculator{
	public static void main(String[] args) {
		int amount,noOfYears;
		double rateOfInterest,simpleInterest,compoundInterest;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount:- " );
		amount = sc.nextInt();
		System.out.println("Enter the number of years:- ");
		noOfYears = sc.nextInt();
		System.out.println("Enter the interest rate:- ");
		rateOfInterest = sc.nextFloat();
		simpleInterest = (amount*rateOfInterest*noOfYears)/(float)100;
		System.out.println("Simple interest is :- "+simpleInterest);
		compoundInterest = amount*Math.pow((1 + rateOfInterest/(float)100),noOfYears);
		System.out.println("Compound interest is :-  "+compoundInterest);
	}
}