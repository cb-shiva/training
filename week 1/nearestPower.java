/*Accepts two numbers x and y , and finds the smalest power of x that is greater than y. */
import java.util.Scanner;
class nearestPower {
	public static void main(String[] args) {
		int num1,num2,temp,power=1;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the first number:- ");
		num1=sc.nextInt();
		System.out.println("Enter the socond number:- ");
		num2=sc.nextInt();

		if(num1==0 || num1==1){
			System.out.println("The smallest power of "+num1+" that is greater than "+num2+" is "+power);			
		}
		else{
			temp=num1;
			while(temp<num2){
				temp=temp*num1;
				power++;
			}
			System.out.println("The smallest power of "+num1+" that is greater than "+num2+" is "+power);			
		}

	}
}