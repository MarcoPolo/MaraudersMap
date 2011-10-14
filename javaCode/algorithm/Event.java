package algorithm;

public class Event {
	static boolean is5;
	
	
	public static void main(String[] args){
		System.out.println("This is a test");
		YetAnotherListenerTest listenTest = new YetAnotherListenerTest();
		listenTest.addlisten();
		for(;;){
		is5 = (5==(int)(Math.random()*10));
		System.out.println(is5);
		System.out.println((int)(Math.random()*10));
		if (is5) break;
		}
		
		SignalListener s = new SignalListener() {
			@Override
			public void signalReceived(int sensor, boolean isBlocked) {
				System.out.println(sensor);
			}
		};
		
		Listener.addListener(s);
		
		if (is5==true){
//			Listener.notifyListeners("The number is indeed 5");
		}
		
	}
}