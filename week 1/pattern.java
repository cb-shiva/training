/*
Prints a pattern of the form,
        1         
      1 2 1       
    1 2 3 2 1     
  1 2 3 4 3 2 1   
1 2 3 4 5 4 3 2 1
given the value of n
*/
import java.util.Scanner;
class pattern {
	public static void main(String[] args) {
		System.out.println("Enter the maximum number");
		String nothing = "  ";
		int input,count,k;
		Scanner sc= new Scanner(System.in);
		input=sc.nextInt();
		for(int i = 1; i <= input; i++){
			count=1;
			
			for(int j = 1; j<= input; j++){
				if( (i + j) <= input ){
					System.out.print(nothing);
				}
				else{
					System.out.print(count+" ");
					count++;
				}
			}
			
			count--;
			
			for (int j = input+1 ;j <= ((input*2) - 1) ; j++) {
				k=input*2-j+i;
				if(k<=input){
					System.out.print(nothing);
				}
				else{
					count--;
					System.out.print(count+" ");
				}
			}
			System.out.println();
		}
	}
}