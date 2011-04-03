package algorithm;

import java.util.ArrayList;

public class SensorEvents implements SignalListener{

	//this is to track all of the sensors as a simple array
	//this makes it easy to specify a certain sensor tracker
	public SensorTracker[] sensorTrackers;
	public SensorEvents(){
		Listener.addListener(this);
		sensorTrackers = new SensorTracker[15];
	}

	@Override
	public void signalReceived(int sensor, boolean isBlocked) {
		//this is here to make sure that the a sensorTracker isn't created if its pair already exist
		//fix this to only use the sensors pair instead of iterating through everything
		

			if(sensorTrackers[Checker.pairNum(sensor)] != null){
				return;
			}
				
			if (sensorTrackers[sensor] == null ){
				//this uses the array of trackers and creates a new tracking object for a specific sensor
				sensorTrackers[sensor] = new SensorTracker(sensor, isBlocked);

		
		
			if (sensorTrackers[1] != null && sensor == sensorTrackers[1].pairSensor){

				return;
			}
			
//			if (sensor sensorTrackers[sensor] != null){
//				sensorTrackers[sensor] = new SensorTracker();
//			}
			
//		System.out.println(sensorTrackers[sensor].speed);
	}
}
}

