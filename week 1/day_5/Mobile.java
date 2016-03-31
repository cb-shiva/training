// Class Mobile:
// Members
// -name : String
// -remainingCharge : Integer
// Methods:
// +remainingCharge(): void
// +name() : void
// Create a list of mobiles overriding the remainingCharge() for each mobile(random value >0&<100). 
// Print the mobile name and remaining charge. Use anonymous inner class for creating mobile objects.

//Mobile class
import java.util.*;
public class Mobile{
	private String name;
	private int remainingCharge;
	
	Mobile(int remainingCharge, String name){
		this.name = name;
		this.remainingCharge = remainingCharge;
	}
	public void remainingCharge(){
		System.out.println("Remaining charge:- "+remainingCharge);
	}
	
	public void name(){
		System.out.println("Name:-"+name);
	}

	public static void main(String[] args) {
		List<Mobile> mobileList = new ArrayList<Mobile>();
		
		//Creating mobile objects using anonymous inner classes and overriding the functions, remainingCharge() and name()
		Mobile mobileObj1 = new Mobile(20,"SAMSUNG"){
			public void remainingCharge(){
				Random rand = new Random();
				int randomNumber = rand.nextInt(101);
				System.out.println("Remaining charge:- " + randomNumber);
			}
		};

		Mobile mobileObj2 = new Mobile(20,"NOKIA"){
			public void remainingCharge(){
				System.out.println("Remaining charge:- 95 ");
			}
		};

		Mobile mobileObj3 = new Mobile(20,"MOTOROLA"){
			public void remainingCharge(){
				System.out.println("Remaining charge:- 60");
			}
		};

		mobileList.add(mobileObj1);
		mobileList.add(mobileObj2);
		mobileList.add(mobileObj3);

		for(Mobile mobileObj : mobileList){
			mobileObj.name();
			mobileObj.remainingCharge();
		}
	}
}