package algorithm;

import consolePrint.CartPoint;

public class Person{
	private CartPoint position;
	private double speed;
	private int prevSensor;
	
	
	public CartPoint getPosition() {
		return position;
	}

	public double getSpeed() {
		return speed;
	}

	public int getPrevSensor() {
		return prevSensor;
	}

	
	//velocity is actually a Location object, 
	//but it's "Location" is denoted as units of change of location per one second
	
	public Person(Location loc){
	}
	
	public void updateVelocity(Location vel){
	}
}
