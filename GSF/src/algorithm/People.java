package algorithm;

import java.util.ArrayList;

import consolePrint.CartPoint;

public class People {
	//this is here to allow for scalability and monitoring of more than one person
	public static ArrayList<Person> ppl = new ArrayList<Person>();
	
	public static void addPerson(Person someone){
		ppl.add(someone);
	}
	public static void notifyPersons(double speed, CartPoint location){
		for (Person person : ppl){
			//right now only handles one person on the grid at a time. This is because the test area is small.
			person.notifyPosition(speed, location);
		}
	}
}
