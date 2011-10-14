package algorithm;

import consolePrint.CartPoint;

public class SensorEvents implements SignalListener{

	//this is to track all of the sensors as a simple array
	//this makes it easy to specify a certain sensor tracker
	public SensorTracker[] sensorTrackers;
	public Person someone = new Person();
	public SensorEvents(){
		Listener.addListener(this);
		sensorTrackers = new SensorTracker[15];
	}

	@Override
	public void signalReceived(int sensor, boolean isBlocked) {
		//this is here to make sure that the a sensorTracker isn't created if its pair already exist
		//fix this to only use the sensors pair instead of iterating through everything
		double speed;
		CartPoint location;

			//this will create the sensor object for the sensor	
			if (sensorTrackers[sensor] == null ){
				//this uses the array of trackers and creates a new tracking object for a specific sensor
				sensorTrackers[sensor] = new SensorTracker(sensor, isBlocked);
			} 
			
			//if the sensor pair exist we will pass the pair to get the speed
			if(sensorTrackers[Checker.pairNum(sensor)] != null){
				speed = sensorTrackers[Checker.pairNum(sensor)].returnSpeed(sensorTrackers[sensor]);
				location = Checker.returnCartPoint(sensor);
				sensorTrackers[sensor] = null;
				sensorTrackers[Checker.pairNum(sensor)] = null;
				//Now to give the position to the people who are listening
				People.notifyPersons(speed, location);
				return;
			}
		
			if (sensorTrackers[1] != null && sensor == sensorTrackers[1].pairSensor){

				return;
			}
			
//			if (sensor sensorTrackers[sensor] != null){
//				sensorTrackers[sensor] = new SensorTracker();
//			}
			
//		System.out.println(sensorTrackers[sensor].speed);
	}
}


