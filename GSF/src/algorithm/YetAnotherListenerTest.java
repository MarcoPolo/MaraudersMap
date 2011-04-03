package algorithm;

public class YetAnotherListenerTest{

	public static void main(String[] args) throws InterruptedException{
		double time1 = System.nanoTime();
		Thread.sleep(1001);
		double time2 = System.nanoTime();
		
		System.out.println(((time2-time1)*Math.pow(10,-9)));
	}
	
}
