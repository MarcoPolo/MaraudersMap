package algorithm;

//this class will track one sensor and listen for its pair to give appropriate calculations
public class SensorTracker implements SignalListener{

	
	double distancebtwnSensor= 1; //this is the distance between the two sensors given in meters
	int sensor;
	int pairSensor;
	boolean hasPairBeenActv;
	boolean isBlocked;
	boolean isPairBlocked;
	boolean isDirUp;
	double speed;
	double deltaT;
	double startTime;
	double stopTime;
	
	
	public double getSpeed() {
		return speed;
	}

	
	public double getDeltaT() {
		return deltaT;
	}
	
	public SensorTracker(){
		
	}

	public SensorTracker(int sensor, boolean isBlocked){
		//to start the timer
//		startTimer();
		this.sensor=sensor;
//		this.isBlocked=isBlocked;
		//this is here to calculate the paired sensor.
		//because each odd sensor is paired with an even one that is one higher and vice versa this holds true
		//i.e. sensor 1 and 2 are paired as well as sensor 3 and 4
		if (sensor%2==0){
			pairSensor=(sensor-1);
			isDirUp = false;
		}else{
			pairSensor=(sensor+1);
			isDirUp = true;
		}
		
		Listener.addListener(this);
		
	}

	@Override
	public void signalReceived(int sensor, boolean isBlocked) {
		// TODO Auto-generated method stub
		//this listener just listens to see if the pair sensor is triggered
		
		if(this.sensor == sensor && !this.isBlocked && isBlocked){
			this.isBlocked=isBlocked;
			startTimer();
		}
		
		
		if (this.isBlocked && sensor == pairSensor && !hasPairBeenActv){
			hasPairBeenActv=true;
			stopTimer();
		}
		
		if(hasPairBeenActv && pairSensor == sensor && !isBlocked ){
			hasPairBeenActv=false;
			isBlocked=false;
		}
		
	}
	
	//this method will start the timing function
	public void startTimer(){
		startTime = System.nanoTime();

	}
	
	//this method will stop the timing function
	//it calculates base of the time difference
	//also goes ahead and calculates the speed
	public void stopTimer(){
		stopTime = System.nanoTime();
		deltaT = ((stopTime - startTime)*Math.pow(10,-9));
		calcSpeed();
		System.err.println(speed);
		
		
	}
		
	public void calcSpeed(){
		speed = (distancebtwnSensor/deltaT);
	}
	
	//this is used to create a new person that started at this origin
	public void createPerson(){
		
	}
}
