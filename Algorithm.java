import java.util.*;
import java.io.*;

public class Algorithm{
		//x = num of north-south facing sensors
		//y = num of east-west facing sensors
	private byte numberOfXAxisSensors = 0, numberOfYAxisSensors = 0;
		//goes west-to-east x-sensors first, then north-to-south y-sensors second
		//distance units are arbitrarily up to the user, but the Person objects 
			//will have a location value using those relative values
	private float[] distancesBetweenSensors;
		//array of all arrays from the past 5 seconds
	private boolean[][] pastReadings;
		//time delay between retrievals (in ms)
	private byte delay = 100;
	private Parser source;
	private ArrayList<Person> currentOccupants = new ArrayList<Person>();
	private volatile boolean epicFail = false;
	
	public Algorithm(byte numX, byte numY, float[] dist, byte del, Parser p) throws Exception{
		if(numX <= 0 || numY <= 0)
			throw new InvalidArgumentException();
		if(dist.length != numX+numY)
			throw new MismatchedSensorsException();
		if(p == null)
			throw new NullPointerException("Parser is not attached to an object");
		
		numberOfXAxisSensors = numX;
		numberOfYAxisSensors = numY;
		distancesBetweenSensors = dist;
		delay = del;
		source = p;
		pastReadings = new boolean[(int)(5000/del)][numX+numY];
		
		initialize();
		new Thread(new Updater()).start();
	}
	
	//fills pastReadings with data to begin pushing out to the user
	//requires 5 seconds before data will stream out
	public synchronized void initialize() throws Exception{
		for(byte i = 0 ; i < pastReadings.length ; i++){
			source.getData();
		}
	}
	
	public synchronized void stop(){
		epicFail = true;
	}
	
	private class Updater implements Runnable{
		public void run(){
			while(!epicFail){
				//pull data, update pastReadings, apply algorithm
				byte i = 0;
				//frameshift down until the second to last element is overwritten
				for( ; i < pastReadings.length - 1 ; i++){
					pastReadings[i] = pastReadings[i+1];
				}
				//then adds the new last element
				try{
					pastReadings[i] = source.getData();
				}catch(Exception ex){
					epicFail = true;
				}
				//this is the hard part ... applying the algorithm that will not only find people but assign them a velocity ...
				{
					
					
	
											
					
				}
				//wait a bit ...
				try{
					Thread.sleep(delay);
				}catch(Exception ex){}
				//then do it all over again!
			}
		}
	}
	
	private class MismatchedSensorsException extends Exception{
		public String toString(){
			return "MismatchedSensorsException: x and y components do \n"+
						"not add up to the number of sensors given";
		}
	}
	
	private class InvalidArgumentException extends Exception{
		public String toString(){
			return "InvalidArgumentException: x and y components\n"+
						"are not positive values";
		}
	}
}