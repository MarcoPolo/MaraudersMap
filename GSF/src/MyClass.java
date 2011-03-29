public class MyClass {
	public static void main(String[] args){
		MyClass c = new MyClass();
		System.out.println("test");

		// Register for MyEvents from c
		c.addMyEventListener(new MyEventListener() {
		    public void myEventOccurred(MyEvent evt) {
		        // MyEvent was fired
		    }
		});
	}
    // Create the listener list
    protected javax.swing.event.EventListenerList listenerList =
        new javax.swing.event.EventListenerList();

    // This methods allows classes to register for MyEvents
    public void addMyEventListener(MyEventListener listener) {
        listenerList.add(MyEventListener.class, listener);
    }

    // This methods allows classes to unregister for MyEvents
    public void removeMyEventListener(MyEventListener listener) {
        listenerList.remove(MyEventListener.class, listener);
    }
    
    void fireMyEvent(MyEvent evt) {
        Object[] listeners = listenerList.getListenerList();
        // Each listener occupies two elements - the first is the listener class
        // and the second is the listener instance
        for (int i=0; i<listeners.length; i+=2) {
            if (listeners[i]==MyEventListener.class) {
                ((MyEventListener)listeners[i+1]).myEventOccurred(evt);
            }
        }
    }
}
