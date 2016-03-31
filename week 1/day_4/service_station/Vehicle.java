//Vehicle class
package service_station_pack;
public class Vehicle{
	private String name;
	private int serviceCharge;

	Vehicle(String _name, int _serviceCharge){
		name = _name;
		serviceCharge = _serviceCharge;
	}
	public String getName(){
		return name;
	}
	public int getServiceCharge(){
		return serviceCharge;
	}
	public String toDisplay(){
		return String.format("%s %d",name , serviceCharge);
	}
};
