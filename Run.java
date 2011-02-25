class Run{
	public static void main(String[]ar){
		try{
			Parser p = new Parser();
			new Handler().findPerson(0,0,0, new boolean[1]);
			while(true){
				Thread.sleep(1000);
				boolean[] b = p.getData();
				for(boolean a : b)
					System.out.println(a);
			}
		}catch(Exception ex){
			System.err.println(ex);
		}
	}
}
