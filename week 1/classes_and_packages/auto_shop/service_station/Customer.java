//Customer class inherits from person
package service_station_pack;
public class Customer extends Person{
	private String customerId;

	Customer(String _name, String _contact, int _age, String _customerId){
		super(_name, _contact, _age);
		customerId = _customerId;
	}

	public String toDisplay(){
		return String.format("%s %s %d %s",name ,contact ,age ,customerId);
	}

};
