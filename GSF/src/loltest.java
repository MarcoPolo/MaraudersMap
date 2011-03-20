
public class loltest {
	public static void main(String[] args){
		System.out.println("this is a test");
		StringBuilder test = new StringBuilder("o hai there");
		System.out.println(test);
		test.insert(test.length(), 'l');
		System.out.println(test.toString());
	}
}
