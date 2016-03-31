//Finds and prints the first n fibonacci numbers 
import java.util.Scanner;
class fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt(),first = 0,second = 1,third;
		System.out.print(first+" ");
		System.out.print(second+" ");
		for (int i = 2; i < input; i++) {
			third = first + second;
			System.out.print(third+" ");
			first = second;
			second = third;
		}
	}
}