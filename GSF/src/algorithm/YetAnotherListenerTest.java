package algorithm;

public class YetAnotherListenerTest implements SignalListener{

	@Override
	public void signalReceived(int sensor, boolean isBlocked) {
		// TODO Auto-generated method stub
		System.out.println("O snap the listener has been activated");
		
	}
	
	public void addlisten(){
		Listener.addListener(this);
	}
	
	

}
