import java.util.*;
import java.io.*;

public class Algorithm{
	int numberOfXAxisSensors = 0, numberOfYAxisSensors = 0;
		//x = num of north-south facing sensors
		//y = num of east-west facing sensors
	int[] distancesBetweenSensors;
		//goes west-to-east x-sensors first, then north-to-south y-sensors second
	boolean[][] pastReadings;
	
	public Algorithm(int numX, int numY, int[] dist) throws Exception{
		if(numX <= 0 || numY <= 0)
			throw new InvalidArgumentException();
		if(dist.length != numX+numY)
			throw new MismatchedSensorsException();
		numberOfXAxisSensors = numX;
		numberOfYAxisSensors = numY;
		distancesBetweenSensors = dist;
	}
	
	public void establishSensorBase; //TO DO
	
	public class MismatchedSensorsException extends Exception{
		public String toString(){
			return "MismatchedSensorsException: x and y components do \n"+
						"not add up to the number of sensors given";
		}
	}
	
	public class InvalidArgumentException extends Exception{
		public String toString(){
			return "InvalidArgumentException: x and y components\n"+
						"are not positive values";
		}
	}
	
	
}