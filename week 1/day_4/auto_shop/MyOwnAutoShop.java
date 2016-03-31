//Base class car
class Car{
	private int speed;
	private double regularPrice;
	private String color;
	Car(int _speed, double _regularPrice, String _color){
		speed = _speed;
		regularPrice = _regularPrice;
		color = _color;
	}
	public double getSalePrice(){
		return regularPrice;
	}
};

//The following classes are sub classes of car
class Truck extends Car{
	private int weight;
	Truck(int _weight, int _speed, double _regularPrice, String _color){
		super(_speed, _regularPrice, _color);
		weight = _weight;
	}
	public double getSalePrice(){
		if (weight > 2000) 
			return super.getSalePrice() * (double)0.90;
		else
			return super.getSalePrice() * (double)0.80;
	}
};

class Ford extends Car{
	private int year,manufacturerDiscount;
	Ford(int _speed, double _regularPrice, String _color, int _year, int _manufacturerDiscount){
		super(_speed, _regularPrice, _color);
		year = _year;
		manufacturerDiscount = _manufacturerDiscount;
	}
	public double getSalePrice(){
		return super.getSalePrice() - manufacturerDiscount;
	}
};

class Sedan extends Car{
	private int length;
	Sedan(int _length, int _speed, double _regularPrice, String _color){
		super(_speed, _regularPrice, _color);
		length = _length;
	}
	public double getSalePrice(){
		if(length > 20)
			return super.getSalePrice() * (double)0.95;
		else
			return super.getSalePrice() * (double)0.90;
	}
};

public class MyOwnAutoShop{
	public static void main(String[] args) {
		
		//Creating vehicle objects and testing them
		Sedan sedanObj = new Sedan(22, 100, 500, "black");
		System.out.println(sedanObj.getSalePrice());
		Ford fordObj = new Ford(30, 500, "white", 2014, 100);
		System.out.println(fordObj.getSalePrice());
		Truck truckObj = new Truck(3000, 30, 800, "red");
		System.out.println(truckObj.getSalePrice());
	}
}

