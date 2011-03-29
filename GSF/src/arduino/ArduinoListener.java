package arduino;
import java.io.*;
import gnu.io.*;

import java.util.Enumeration;
// go here for the rx tx library that is needed for this communication to work
//this is an eclipse repo
//http://rxtx.qbang.org/eclipse/

public class ArduinoListener implements SerialPortEventListener {
	SerialPort serialPort;
    /** The port we're normally going to use. */
private static final String PORT_NAMES[] = { 
		"/dev/tty.usbserial-A9007UX1", // Mac OS X
		"/dev/ttyUSB0", // Linux
		"COM3", // Windows
		};
/** Buffered input stream from the port */
private InputStream input;
/** The output stream to the port */
private OutputStream output;
/** Milliseconds to block while waiting for port open */
private static final int TIME_OUT = 2000;
/** Default bits per second for COM port. */
private static final int DATA_RATE = 9600;

public static boolean SENSOR1, SENSOR2, SENSOR3, SENSOR4, SENSOR5, SENSOR6, SENSOR7, SENSOR8, SENSOR9, SENSOR10, SENSOR11, SENSOR12, SENSOR13, SENSOR14, SENSOR15 = false;

public void initialize() {
	CommPortIdentifier portId = null;
	Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

	// iterate through, looking for the port
	while (portEnum.hasMoreElements()) {
		CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
		for (String portName : PORT_NAMES) {
			if (currPortId.getName().equals(portName)) {
				portId = currPortId;
				break;
			}
		}
	}

	if (portId == null) {
		System.out.println("Could not find COM port.");
		return;
	}

	try {
		// open serial port, and use class name for the appName.
		serialPort = (SerialPort) portId.open(this.getClass().getName(),
				TIME_OUT);

		// set port parameters
		serialPort.setSerialPortParams(DATA_RATE,
				SerialPort.DATABITS_8,
				SerialPort.STOPBITS_1,
				SerialPort.PARITY_NONE);

		// open the streams
		input = serialPort.getInputStream();
		output = serialPort.getOutputStream();

		// add event listeners
		serialPort.addEventListener(this);
		serialPort.notifyOnDataAvailable(true);
	} catch (Exception e) {
		System.err.println(e.toString());
	}
}

/**
 * This should be called when you stop using the port.
 * This will prevent port locking on platforms like Linux.
 */
public synchronized void close() {
	if (serialPort != null) {
		serialPort.removeEventListener();
		serialPort.close();
	}
}

/**
 * Handle an event on the serial port. Read the data and print it.
 */
public synchronized void serialEvent(SerialPortEvent oEvent) {
	if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
		try {
			int available = input.available();
			byte chunk[] = new byte[available];
			input.read(chunk, 0, available);
				//System.out.println("test");
				String s = new String(chunk);
				//System.out.println(s);
			// Displayed results are codepage dependent
			//System.out.print(new String(chunk));
			//int a = input.read();
			//System.out.println(""+a);
			//probably should turn this into a switch
				
				
				
				
				
			//code to read the serial data	
			if (s.indexOf("1t")!=-1){
				System.out.println("Sensor 1 is unblocked");
				SENSOR1=false;
			}
			if (s.indexOf("1f")!=-1){
				System.out.println("Sensor 1 is blocked");
				SENSOR1=true;
			}
			if (s.indexOf("2t")!=-1){
				System.out.println("Sensor 2 is unblocked");
				SENSOR2=false;
			}
			if (s.indexOf("2f")!=-1){
				System.out.println("Sensor 2 is blocked");
				SENSOR2=true;
			}
			
			if (s.indexOf("3t")!=-1){
				System.out.println("Sensor 3 is unblocked");
				SENSOR3=false;
			}
			if (s.indexOf("3f")!=-1){
				System.out.println("Sensor 3 is blocked");
				SENSOR3=true;
			}
			
			if (s.indexOf("4t")!=-1){
				System.out.println("Sensor 4 is unblocked");
				SENSOR4=false;
			}
			if (s.indexOf("4f")!=-1){
				System.out.println("Sensor 4 is blocked");
				SENSOR4=true;
			}
			
			if (s.indexOf("5t")!=-1){
				System.out.println("Sensor 5 is unblocked");
				SENSOR5=false;
			}
			if (s.indexOf("5f")!=-1){
				System.out.println("Sensor 5 is blocked");
				SENSOR5=true;
			}
			
			
			if (s.indexOf("6t")!=-1){
				System.out.println("Sensor 6 is unblocked");
				SENSOR6=false;
			}
			if (s.indexOf("6f")!=-1){
				System.out.println("Sensor 6 is blocked");
				SENSOR6=true;
			}
			
			if (s.indexOf("7t")!=-1){
				System.out.println("Sensor 7 is unblocked");
				SENSOR7=false;
			}
			if (s.indexOf("7f")!=-1){
				System.out.println("Sensor 7 is blocked");
				SENSOR7=true;
			}
			
			if (s.indexOf("8t")!=-1){
				System.out.println("Sensor 8 is unblocked");
				SENSOR8=false;
			}
			if (s.indexOf("8f")!=-1){
				System.out.println("Sensor 8 is blocked");
				SENSOR8=true;
			}
			
			
			if (s.indexOf("9t")!=-1){
				System.out.println("Sensor 9 is unblocked");
				SENSOR9=false;
			}
			if (s.indexOf("9f")!=-1){
				System.out.println("Sensor 9 is blocked");
				SENSOR9=true;
			}
			
			
			if (s.indexOf("10t")!=-1){
				System.out.println("Sensor 10 is unblocked");
				SENSOR10=false;
			}
			if (s.indexOf("10f")!=-1){
				System.out.println("Sensor 10 is blocked");
				SENSOR10=true;
			}
			
			if (s.indexOf("11t")!=-1){
				System.out.println("Sensor 11 is unblocked");
				SENSOR11=false;
			}
			if (s.indexOf("11f")!=-1){
				System.out.println("Sensor 11 is blocked");
				SENSOR11=true;
			}
			
			if (s.indexOf("12t")!=-1){
				System.out.println("Sensor 12 is unblocked");
				SENSOR12=false;
			}
			if (s.indexOf("12f")!=-1){
				System.out.println("Sensor 12 is blocked");
				SENSOR12=true;
			}
			
			if (s.indexOf("13t")!=-1){
				System.out.println("Sensor 13 is unblocked");
				SENSOR13=false;
			}
			if (s.indexOf("13f")!=-1){
				System.out.println("Sensor 13 is blocked");
				SENSOR13=true;
			}
			
			if (s.indexOf("14t")!=-1){
				System.out.println("Sensor 14 is unblocked");
				SENSOR14=false;
			}
			if (s.indexOf("14f")!=-1){
				System.out.println("Sensor 14 is blocked");
				SENSOR14=true;
			}
			
			if (s.indexOf("15t")!=-1){
				System.out.println("Sensor 15 is unblocked");
				SENSOR15=false;
			}
			if (s.indexOf("15f")!=-1){
				System.out.println("Sensor 15 is blocked");
				SENSOR15=true;
			}
			
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	// Ignore all the other eventTypes, but you should consider the other ones.
}

public static boolean getSENSOR1(){
	return SENSOR1;
}

public static boolean getSENSOR2(){
	return SENSOR2;
}

public static void main(String[] args) throws Exception {
	ArduinoListener main = new ArduinoListener();
	main.initialize();
	System.out.println("Started");
}

	}
	
	
	

