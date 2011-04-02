package algorithm;

import java.util.ArrayList;


public class Listener {

	public static ArrayList<SignalListener> listeners = new ArrayList<SignalListener>(2);
	
	public static void addListener(SignalListener listener){
		listeners.add(listener);
	}
		
	public static void notifyListeners(int sensor, boolean isBlocked){
		for(SignalListener sl : listeners){
			sl.signalReceived(sensor, isBlocked);
		}
	} 
}
