public class Person{
	private Location currentLocation;
	private Location velocity;
	//velocity is actually a Location object, 
	//but it's "Location" is denoted as units of change of location per one second
	
	public Person(Location loc){
		currentLocation = loc;
		velocity = new Location(0f,0f);
	}
	
	public Location getLocation(){
		return currentLocation;
	}
	
	public Location getVelocity(){
		return velocity;
	}
	
	public void updateLocation(Location loc){
		currentLocation = loc;
	}
	
	public void updateVelocity(Location vel){
		velocity = vel;
	}
}