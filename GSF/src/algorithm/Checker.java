public class Checker{
	public static boolean thisIsAnExistingPerson(SensorTracker st){
		for(Person per : People.ppl){
			if(st.isDirUp){
				if(per.getPrevSensor() % 2 == 0){
					if(per.getPrevSensor() == st.sensor + 2){
						return true;
					}
				}
			}
			else{
				if(per.getPrevSensor() % 2 == 1){
					if(per.getPrevSensor() == st.sensor - 2){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static int pairNum(int i){
		if(i % 2 == 0)
			return i - 1;
		return i+1;
	}
}