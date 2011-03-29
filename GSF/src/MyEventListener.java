import java.util.EventListener;
	// Declare the listener class. It must extend EventListener.
	// A class must implement this interface to get MyEvents.
public interface MyEventListener extends EventListener {
    public void myEventOccurred(MyEvent evt);
    
}

