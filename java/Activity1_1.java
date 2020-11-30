package javaActivity1;

public class Activity1_1 {

	public static void main(String[] args) 
	{
		//Creating the object for Car Class
		Car toyota = new Car();
		
		//Assigning the values to object
        toyota.make = 2014;
        toyota.color = "Black";
        toyota.transmission = "Manual";
    
        //Using object call the Car class methods
        toyota.displayCharacterstics();
        toyota.accelerate();
        toyota.brake();
	}

}
