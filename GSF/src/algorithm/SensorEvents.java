package algorithm;

import java.util.ArrayList;

public class SensorEvents implements SignalListener{

	//this is to track all of the sensors as a simple array
	//this makes it easy to specify a certain sensor tracker
	SensorTracker[] sensorTrackers = new SensorTracker[15];
	
	SensorEvents(){
		Listener.addListener(this);
	}

	@Override
	public void signalReceived(int sensor, boolean isBlocked) {
		//this is here to make sure that the a sensorTracker isn't created if its pair already exist
		for(SensorTracker sensorTracker : sensorTrackers){
			if (sensor == sensorTracker.pairSensor){
				return;
			}
		}
		//this uses the array of trackers and creates a new tracking object for a specific sensor
		sensorTrackers[sensor] = new SensorTracker(sensor, true);
	}
}
