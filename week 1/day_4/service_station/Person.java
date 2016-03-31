//Person class
package service_station_pack;
public class Person{
	protected int age;
	protected String name,contact;
	Person(String _name, String _contact, int _age){
		name = _name;
		contact = _contact;
		age = _age;
	}
	public String getName(){
		return name;
	}
};
