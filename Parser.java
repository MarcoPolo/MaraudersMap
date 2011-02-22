import java.io.*;
import java.util.*;

class Parser{

	Scanner file;
	boolean[] b;

	Parser(){
		try{
			file = new Scanner(new File("test.txt"));
			b = new boolean[file.nextInt()+file.nextInt()];
		}catch(Exception ex){
			System.err.println(ex);
		}
	}

	public boolean[] getNextLine() throws Exception{
		for(int i = 0 ; i < b.length ; i++){
			if(file.next().charAt(0)=='.')
				b[i] = false;
			else{
				b[i] = true;
			}
		}
		return b;
	}
}
