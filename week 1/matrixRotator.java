import java.util.*;
class matrixRotator {
	public static void main(String[] args) {
		int rowSize = 3,colSize = 3;
		char input;
		Scanner sc = new Scanner(System.in);
		
		//Accept sizes
		System.out.println("Enter the size of your matrix.");
		System.out.println("Row:- ");
		rowSize=sc.nextInt();
		System.out.println("Column:- ");
		colSize=sc.nextInt();
		int[][] matrix = new int[rowSize][colSize];

		//Reads input matrix
		for (int i = 0; i < rowSize ; i++) {
		 	for (int j = 0; j < colSize ; j++) {
		 		matrix[i][j]=sc.nextInt();
		 	}
		}

		//Displays input matrix
		System.out.println("Your input matrix is:- ");
		for (int i = 0; i < rowSize ; i++) {
			for (int j = 0; j < colSize ; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();		 	
		 }

		//Acceptd choice and displays rotated matrix
		System.out.println("Press 'd' arrow for right rotation, and 'a' arrow for left rotation");
		input=sc.next().charAt(0);

		//right rotation
		if(input == 'd'){
			for(int i = 0 ; i < colSize ; i++) {
				for (int j = 0 ; j < rowSize ; j++) {
					if (rowSize == colSize) 
						System.out.print(matrix[colSize-j-1][i]+" ");
					else if (rowSize > colSize) 
						System.out.print(matrix[colSize-j][i]+" ");
					else if (rowSize < colSize) 
						System.out.print(matrix[colSize-j-2][i]+" ");
				}
				System.out.println();
			}
		}
		//left rotation
		else if (input == 'a') {
			for (int i = 0 ; i < colSize ; i++) {
				for (int j = 0 ; j < rowSize ; j++) {
					if (rowSize == colSize) 
						System.out.print(matrix[j][rowSize-i-1]+" ");
					else if (rowSize > colSize) 
						System.out.print(matrix[j][rowSize-i-2]+" ");
					else if (rowSize < colSize) 
						System.out.print(matrix[j][rowSize-i]+" ");
				}
				System.out.println();
			}		
		}
		else
			System.out.println("Wrong input");
	}	
}