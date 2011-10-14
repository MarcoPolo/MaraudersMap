package algorithm;

import consolePrint.CartPoint;
import consolePrint.consolePrint;

public class Person{
	//this is the persons current location
	private CartPoint location;
	private double speed;
	private double defaultSpeed;
	//this is the persons last location
	private CartPoint lastLocation;
	private boolean isDirUp;
	private int prevSensor;
	
	
	public Person(){
		People.addPerson(this);
	}
	
	//this method gives the speed and location of each person
	public void notifyPosition(double speed, CartPoint location){
		//do not print anything if this is the first point of the person
		if(this.location == null){
			this.location = location;
			this.speed = speed;
			if (speed > 0) isDirUp = true;
			else isDirUp = false;
			return;
		}
		lastLocation = this.location;
		this.speed = speed;
		this.location = location;
		if (speed > 0) isDirUp = true;
		else isDirUp = false;
		drawMeMoving();
	}
	
	public void drawMeMoving(){
		drawMeMoving(lastLocation, location);
	}
	
	public void isEnteringRoom(){
		switch (location.getY()) {
		case 7:
			if(!isDirUp){
				Rooms.room[0]=false;
				Rooms.room[0]=true;
			}
		case 9:
			if(!isDirUp){
				Rooms.room[1]=false;
			}else{
				Rooms.room[1]=true;
			}
			
			break;

		default:
			break;
		}
	}
	
	public void drawMeMoving(CartPoint lastLocation, CartPoint location){
		double speed;
		//checks to make sure the speed makes since, if not then use a default speed
		if (this.speed>40 && this.speed<200){
			speed = this.speed;
		}else{
			speed = this.defaultSpeed;
		}
		consolePrint.printPointMoving(lastLocation, location, (int)Math.abs(speed));
	}
	
	public CartPoint getPosition() {
		return location;
	}

	public double getSpeed() {
		return speed;
	}

	public int getPrevSensor() {
		return prevSensor;
	}
}
