package algorithm;

import consolePrint.CartPoint;

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
	public static boolean isDirUp(int OriginSensor){
		if (OriginSensor%2==0){
			return false;
		}else{
			return true;
		}
	}
	
	//this returns the corresponding cartpo0int for the sensor that has been triggered
	public static CartPoint returnCartPoint(int aSensor){
		//this is here to get the even sensor so we can make a simple switch statement
		int x;
		int y;
		if (aSensor%2 != 0){
			aSensor = pairNum(aSensor);
		}
		switch (aSensor) {
		case 2:
			x = 5;
			y = 7;
			break;

		case 4:
			x = 5;
			y = 9;
			break;

		case 6:
			x = 5;
			y = 11;
			break;

		case 8:
			x = 7;
			y = 13;
			break;

		case 10:
			x = 5;
			y = 23;
			break;

		default:
			x = 0;
			y = 0;
			break;
		}
		
		
		return (new CartPoint(x,y));
		
	}
	
}