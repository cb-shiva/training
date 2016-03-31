//Factorial program using nested classes and implementing the iterable class
import java.util.*;
public class Factorial{
	private int lowerLimit, upperLimit;

	//Constructor sets the instance variable values
	Factorial(int lowerLimit, int upperLimit){
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	//Helper function that returns the factorial of the input number
	public int findFactorial(int num){
		int fact = 1;
		for(int i = num; i > 0; i--){
			fact = fact * i;
		}
		return fact;
	}

	//Function that returns the string to be displayed for the factorial object
	public String toString(){
		String factString = "";
		Iterator<Integer> numRangeIterator = iterator();
		while(numRangeIterator.hasNext()){
			factString = factString + findFactorial(numRangeIterator.next().intValue()) + ",";
		}
		return factString;
	}

	//Function that returns an iterator of an iterable created using nested classes
	public Iterator iterator(){

		//Inner class that implements the iterable interface
		class Range implements Iterable{	
			public List<Integer> list;

			//Constructor creates a custom iterable
			Range(int lowerLimit, int upperLimit){
				list = new ArrayList<Integer>();
				for(int i = lowerLimit; i < upperLimit; i++){
					list.add(i);
				}
			}

			//Function returns the iterator of the iterable
			public Iterator<Integer> iterator(){
				return list.iterator();
			}
		} 
		
		//Creates an iterable, with the required arguments
		Range numRange = new Range(lowerLimit,upperLimit);
		//returning the iterator of the created iterable
		return numRange.iterator();
	}


	public static void main(String[] args) {
		int lowerLimitResponse, upperLimitResponse;
		
		//Taking user input
		System.out.println("Enter the lower limit:- ");
		lowerLimitResponse = Integer.parseInt(System.console().readLine());
		System.out.println("Enter the upper limit:- ");
		upperLimitResponse = Integer.parseInt(System.console().readLine());

		//Creating a Factorial object with given input and displaying the required string
		Factorial f = new Factorial(lowerLimitResponse, upperLimitResponse);
		System.out.println(f.toString());
	}
}