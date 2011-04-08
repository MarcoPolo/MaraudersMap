package consolePrint;
import java.io.Console;

public class consolePrint {
	private final static int borderLength=50;
	private final static int defaultSpeed = 50 ;
//this class will usually not run this method but it was helpful for debugging/testing	
	public static void main(String[] args){
		
		CartPoint point4 = new CartPoint(7,5);
		CartPoint pointOther = new CartPoint(10,5);
		printPointMoving(point4, pointOther, defaultSpeed);
		
		//these are experimental methods to be implemented later
//		Nodes nodes = new Nodes(point4);
//		System.out.println(checkLeft(point4));
//		System.out.println(checkUp(point4));
//		nodes = travelUp(point4, nodes);
//		nodes.printNodes(nodes);
		
	}
	public static void printPointMoving(CartPoint start, CartPoint end, int speed){
		
		int yDrawCoord;
		do {
			bound(borderLength);
		for(int k =0;k<=9;k++){
			yDrawCoord=start.getY();
			if(k==yDrawCoord){
				stepPointMovingNicely(start, end);
				printLvl(' ', new CartPoint(2,(++k)));
			}else{
				printLvl(' ', new CartPoint(2,k));
			}
		}
		bound(borderLength);
		sleep(speed);
		} while(start.getY()!=end.getY() || start.getX()!=end.getX());
	}
	
	public static void sleep(int time){
		try {
			Thread.sleep(time);
		}catch (Exception e){
			//something happened while falling asleep
		}
	}
	
	public static String returnLvl(int n){
		//This method returns the string appropriate for the current level 
		//please note that the level pertains to each line in the ascii map
		//also note that the level begins with the first string that has a changing string
		//so for example the entrance to the living room because it is the first sensor on the first line
		
		switch (n) {
		case 0:
			return ("     -------------------------------");
		case 1:
			return ("      |     |     |     | #        |");
		case 2:
			return ("      |     |     |     | #  #     |");
		case 3:
			return ("      |     |     |     | #        |");
		case 4:
			return ("______|_ ___|__ __|___ _|    ######|");
		case 5:
			return ("|                                  |");
		case 6:
			return ("|     |___ _       ___ _           |");
		case 7:
			return ("|     |     |     |     |          |");
		case 8:
			return ("|     |     |     |     |        # |");
		case 9:
			return ("|     |     |     |     |        # |");

		default: 
			return("This is not an appropriate floor level, pl3ase check your calculations!");
		}
	}
	
	public static void stepPointMovingNicely(CartPoint location, CartPoint destination){
		if(location.getX()!=destination.getX()){
			printLvl('*',location);
			location.setX(NumberComparer(location.getX(), destination.getX()));
//			printLvl('*',location);
		}else{
			if(location.getY()!=destination.getY()){
				printLvl('*', location);
				location.setY(NumberComparer(location.getY(), destination.getY()));
//				printLvl('*', location);
			}
		}
	}
	
	public static void printPointMovingNicely(CartPoint location, CartPoint destination){
		do {
			printLvl('*', location);
			location.setX(NumberComparer(location.getX(), destination.getX()));
		} while(location.getX()!=destination.getX());
		do {
			printLvl('*', location);
			location.setY(NumberComparer(location.getY(), destination.getY()));
		} while(location.getY()!=destination.getY());
		
	}
	
	public static int NumberComparer(int first, int second){
		if (first<second){
			return (first+1);
		}else if(first>second){
			return (first-1);
		}else if(first==second){
			return first;
		}
			return first;
	}
	
	public static void printLvl(char someSignal, CartPoint posOfSomeSignal){
		String StringLvl = drawLvl(posOfSomeSignal.getX(), posOfSomeSignal.getY(), someSignal);
		border(StringLvl);
		//bound()
	}
	
	public static void bound(int length){
		if (length>0){
			System.out.print("-");
			bound(length-1);
		}else{
			System.out.println();
			
		}
	}
	
	public static String drawLvl(int d1, int lvlNum, char c1){
		StringBuilder buildMe = new StringBuilder(returnLvl(lvlNum));
		buildMe.deleteCharAt(d1);
		buildMe.insert(d1, c1);
		return buildMe.toString();
	}

	public static void border(String s){
		int a=borderLength-s.length()-2;
		String format = "| %s%"+a+"s\n";
		System.out.printf(format, s, "|");
	}
	public static void clearConsole(){
		Console console = System.console();
		console.flush();
	}

	//true means there is nothing there
	//false means there is something
	public static boolean checkUp(CartPoint currentPoint){
		if (currentPoint.getY()==0){
			return false;
		}
		StringBuilder upLvl = new StringBuilder(returnLvl(currentPoint.getY()-1));
		return (upLvl.charAt(currentPoint.getX())==' ');
	}
		
	public static boolean checkDown(CartPoint currentPoint){
		if (currentPoint.getY()==9){
			return false;
		}
		StringBuilder downLvl = new StringBuilder(returnLvl(currentPoint.getY()+1));
		return (downLvl.charAt(currentPoint.getX())==' ');
	}
		
	public static boolean checkRight(CartPoint currentPoint){
		if (currentPoint.getX()==34){
			return false;
		}
		StringBuilder rightLvl = new StringBuilder(returnLvl(currentPoint.getY()));
		return (rightLvl.charAt(currentPoint.getX()+1)==' ');
	}
		
	public static boolean checkLeft(CartPoint currentPoint){
		if (currentPoint.getX()==0){
			return false;
		}
		StringBuilder leftLvl = new StringBuilder(returnLvl(currentPoint.getY()));
		return(leftLvl.charAt(currentPoint.getX()-1)==' ');
	}
	
//here begins the A* algorithm
	
	private static float heuristicDistance(CartPoint first, CartPoint last){
		int firstX = first.getX();
		int firstY = first.getY();
		int lastX = last.getX();
		int lastY = last.getY();
		return (float)(Math.sqrt(  Math.pow((lastX-firstX), 2) + Math.pow(lastY-firstY, 2))  );
	}
	
	private static void branchDist(CartPoint first, CartPoint last){
		Nodes nodes = new Nodes(first);
		
	}
	
	private static Nodes travelUp(CartPoint point, Nodes nodes){
		while(checkUp(point)){
			printPointMoving(point, (new CartPoint(point.getX(), ++point.y)), defaultSpeed);
		}
			nodes.stackNodeOnTop(point, nodes);
			return nodes;
	}
	//this method will
	
	
	
}
