
public class consolePrint {
	
	public static void main(String[] args){
		int borderLength = 100;
		char[] array = new char[7];
		for(int k=0; k<7;k++){
			array[k]=' ';
		}
		int l=0;
		for (int k=0; k<100;k++, l = (int)(Math.random()*10)){
		bound(borderLength);
		border("Hello there this is the ASCII map of lakeside LOL", borderLength);
		if (l>6) l-=6;
		array[l]='*';
		border("     ------------------------------", borderLength);
		border("      |     |     |     | #        |", borderLength);
		border("      |     |     |     | #  #     |", borderLength);
		border("      |     |     |     | #        |", borderLength);
		border("______|_ ___|__ __|___ _| "+array[4]+"  ######|", borderLength);
		border("|      "+array[0]+" "+array[1]+"         "+array[2]+"    "+array[3]+"          |", borderLength);								
		border("|     |___ _       ___ _           |", borderLength);								
		border("|     |     |  "+array[5]+"  |     |          |", borderLength);								
		border("|     |     |     |     |        # |", borderLength);								
		border("|     |     |     |     |  "+array[6]+"     # |", borderLength);								
		border("|     |     |     |     |          |", borderLength);								
		border("-----------------------------------", borderLength);
		bound(borderLength);
		array[l]=' ';
		try{
		Thread.sleep(100);
		}catch (Exception e) {
			// TODO: handle exception
		}{
			
		}
		}
			
		
//		border(modBound("______|_ ___|__ __|___ _|   ######|", '*', 26),50);
		
		//System.out.printf("\n %10s %10s", "this", "is");
	
	}
	
	public static void bound(int length){
		if (length>0){
			System.out.print("-");
			bound(length-1);
		}else{
			System.out.println();
			
		}
	}
	
	public static String modBound(String s, char c1, int d1){
		StringBuilder buildMe = new StringBuilder(s);
		buildMe.insert(25, c1);
		return buildMe.toString();
	}

	public static void border(String s, int borderLength){
		int a=borderLength-s.length()-2;
		String format = "| %s%"+a+"s\n";
		System.out.printf(format, s, "|");
	}
}
