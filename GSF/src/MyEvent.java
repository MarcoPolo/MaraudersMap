import java.util.EventObject;


public class MyEvent extends EventObject {
    public MyEvent(Object source) {
        super(source);
        System.out.println("something happened");
    }
    
	
}
