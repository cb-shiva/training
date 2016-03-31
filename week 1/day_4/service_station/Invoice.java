//Invoice class
package service_station_pack;
public class Invoice {
	private Person customer, employee;
	private Vehicle vehicle;

	//Person objects are used because argument can be either an Employee object or a customer object
	Invoice(Person cus, Person emp, Vehicle _vehicle){
		customer = cus;
		employee = emp;
		vehicle = _vehicle;
	}

	public String toDisplay(){
		return String.format("Customer:- %s Employee:- %s Vehicle:- %s Total charge:- $%d",customer.getName(), employee.getName(), vehicle.getName(), vehicle.getServiceCharge());
	}
};
