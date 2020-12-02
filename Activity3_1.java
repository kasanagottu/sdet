package javaActivity_3;


import java.util.ArrayList;

public class Activity3_1 {

	public static void main(String[] args)
	{
		//declaring Array list of String objects
		ArrayList<String> myList  = new ArrayList<String>();
		
		//Adding objects to Array List at default index
		myList.add("Venkat");
		myList.add("Pranika");
		myList.add("Harshika");
		myList.add("Kruthika");
		myList.add("Shriti");
		
		System.out.println("The names are :");
		
			for (String str :myList)
			{
				System.out.println(str);
			}
		
			//Adding other at specific index
		
			myList.add(2, "Apple");
			myList.add(0, "Grapes");
			
			System.out.println("*********The new names are :************");
			
			for (String str :myList)
			{
				System.out.println(str);
			}
		
			
			//Retrieve 3rd Object
			System.out.println("The 3rd element from the list :"+myList.get(2));
			
			//Check names exist in the list
			System.out.println("Check the Apple in the list : "+myList.contains("Apple"));
			
			//Check size of the array in the list
			System.out.println("initial sise of the list :"+myList.size());
			
			//Remove a object from the list
			System.out.println("Removal object"+myList.remove(4));
			
			//Check size of the array in the list after removing the object
			System.out.println("Size of the the list after removal:"+myList.size());
				
			
	}
	
	

}
