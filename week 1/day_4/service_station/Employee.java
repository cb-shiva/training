//Employee class inherits from person
package service_station_pack;
public class Employee extends Person{
	private String empId;
	Employee(String _name, String _contact, int _age, String _empId){
		super(_name, _contact, _age);
		empId = _empId;
	}

	public String toDisplay(){
		return String.format("%s %s %d %s",name ,contact ,age ,empId);
	}
};