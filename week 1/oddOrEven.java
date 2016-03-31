/*Accepts a number and finds whether it is odd or even*/
import java.util.Scanner;
class oddOrEven {
	public static void main(String[] args) {
		int inputNum;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Please enter a number:- ");
		inputNum=sc.nextInt();

		if(inputNum%2==0){
			System.out.println("The number is even");
		}
		else {
			System.out.println("The number is odd");
		}

	}
}