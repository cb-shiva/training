/*
Finds the sum of the indices of the string given as input, and checks if this sum is even or odd
*/
import java.util.Scanner;
class inputCharacters {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input=sc.next();
		int sum = 0;
		for(char ch: input.toCharArray()){
			sum = sum + ((int)ch - 96);
		}
		if(sum%2 == 0)
			System.out.println("even");
		else 
			System.out.println("odd");
	}
}
	
