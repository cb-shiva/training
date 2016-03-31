//Finds the smallest and the largest integer, in an array given as input
import java.util.Scanner;
class smallestAndLargest{
	public static void main(String[] args) {
		int min,max,size;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of your array:- ");
		size = sc.nextInt();
		int[] inputArray = new int[size];
		System.out.println("Enter your array:- ");
		for (int i = 0; i < size; i++)
			inputArray[i]=sc.nextInt();
		min=inputArray[0];
		max=inputArray[0];
		for (int i =0; i <size ; i++) {
			if (inputArray[i] < min)
				min = inputArray[i];
			if (inputArray[i] > max)
				max = inputArray[i];
		}
		System.out.println("Max:- "+max);
		System.out.println("Min:- "+min);
	}
}