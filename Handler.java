class Handler{
	
	Handler(){
		
	}
	
	public int[] findPerson(int x , int y , int span , boolean[] sensor) throws MismatchedSensorsException{
			//x = num of north-south facing sensors
			//y = num of east-west facing sensors
			//span = distance between evenly spaced sensors
		int[] temp = new int[4];
			//temp[0] = approximate location x-component in units of span
			//temp[1] = approximate location y-component in units of span
			//temp[2] = velocity in the units of span/sec
			//temp[3] = bearing in degrees
		if(sensor.length != x+y)
			throw new MismatchedSensorsException();
			//sensors go across the x then down the y
		for(int i = 0 ; i < x+y ; i++){
			
		}
		return temp;
	}
	
	//public DisplayerMap 
	
	public class MismatchedSensorsException extends Exception{
		
		public MismatchedSensorsException(){
			
		}
		
		public String toString(){
			return "Handler.MismatchedSensorsException: x and y components do not add up to the amount of data given";
		}
		
	}
}