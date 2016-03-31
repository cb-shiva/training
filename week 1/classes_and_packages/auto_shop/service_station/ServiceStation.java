
/*
Program description:-
Service Station (name, address, contact) 
Person - Employee/Customer (name, age, contact, emp_id) - an employee can also be a customer.
Vehicle - brand, color, service  (Car, Bike, Bus, service_charge)
Invoice (name_of_owner,vehicle, amount_total, employee_assigned)
List the service charges of all the vehicles that can get repaired in the station. List all the employee and customer (can also be an employee) with their invoices.
*/

package service_station_pack;
import java.util.*;

//Main class ServiceStation
public class ServiceStation {
	private String name,address,contact;
	private ArrayList<Employee> employeeList;
	private ArrayList<Customer> customerList;
	private ArrayList<Invoice> invoiceList;
	private ArrayList<Vehicle> vehicleList;

	ServiceStation(String _name, String _address, String _contact){
		name = _name;
		address = _address;
		contact = _contact;
		employeeList = new ArrayList<Employee>();
		customerList = new ArrayList<Customer>();
		invoiceList = new ArrayList<Invoice>();
		vehicleList = new ArrayList<Vehicle>();
	}

	public void addEmployee(Employee emp){
		employeeList.add(emp);
	}

	public void listAllcustomers(){
		for(Customer customerObj : customerList){
			System.out.println(customerObj.toDisplay());
		}
	}

	public void listAllEmployees(){
		for(Employee employeeObj : employeeList){
			System.out.println(employeeObj.toDisplay());
		}
	}

	public void listAllVehicles(){
		for(Vehicle vehicleObj : vehicleList){
			System.out.println(vehicleObj.toDisplay());
		}
	}

	public void listAllInvoices(){
		for(Invoice invoiceObj : invoiceList){
			System.out.println(invoiceObj.toDisplay());
		}
	}

	public void addCustomer(Customer cus){
		customerList.add(cus);
	}

	public void addInvoice(Invoice inv){
		invoiceList.add(inv);
	}

	public void addVehicle(Vehicle v){
		vehicleList.add(v);
	}

	
	public static void main(String[] args) {
		//Testing the classes created

		//Creating a serviceStation object
		ServiceStation serviceStationObj = new ServiceStation("sname","sadd","091-345123");
		
		//Creating employee objects and adding them to the serviceStation object
		Employee employeeObj1 = new Employee("emp1_name","123",23,"1");
		Employee employeeObj2 = new Employee("emp2_name","456",24,"2");
		Employee employeeObj3 = new Employee("emp3_name","789",25,"3");
		serviceStationObj.addEmployee(employeeObj1);
		serviceStationObj.addEmployee(employeeObj2);
		serviceStationObj.addEmployee(employeeObj3);

		//Creating customer objects and adding them to the serviceStation object
		Customer customerObj1 = new Customer("cus1_name","456",50,"4");
		Customer customerObj2 = new Customer("cus1_name","789",51,"5");
		Customer customerObj3 = new Customer("cus1_name","345",52,"6");
		serviceStationObj.addCustomer(customerObj1);
		serviceStationObj.addCustomer(customerObj2);
		serviceStationObj.addCustomer(customerObj3);

		//Creating vehicle objects and adding them to the serviceStation object
		Vehicle vehicleObj1 = new Vehicle("car", 300);
		Vehicle vehicleObj2 = new Vehicle("truck", 400);
		Vehicle vehicleObj3 = new Vehicle("bike", 500);
		serviceStationObj.addVehicle(vehicleObj1);
		serviceStationObj.addVehicle(vehicleObj2);
		serviceStationObj.addVehicle(vehicleObj3);
		
		//Creating invoice objects using the already created employee,customer and vehicle objects
		Invoice invoiceObj1 = new Invoice(customerObj1, employeeObj1, vehicleObj1);
		Invoice invoiceObj2 = new Invoice(employeeObj2, customerObj2, vehicleObj2);
		Invoice invoiceObj3 = new Invoice(customerObj3, employeeObj3, vehicleObj3);
		serviceStationObj.addInvoice(invoiceObj1);
		serviceStationObj.addInvoice(invoiceObj2);
		serviceStationObj.addInvoice(invoiceObj3);
		
		//Testing all functions of the serviceStation object		
		serviceStationObj.listAllEmployees();
		serviceStationObj.listAllcustomers();
		serviceStationObj.listAllVehicles();
		serviceStationObj.listAllInvoices();


	}
};