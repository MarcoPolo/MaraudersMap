package consolePrint;

public class CartPoint {
	//y is the levels
	int x,y;
	public CartPoint(int x, int y){
		this.x=x;
		this.y=y;
	}
	CartPoint(){
		new CartPoint(0,0);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public void movePointTo(CartPoint a){
		setX(a.getX());
		setY(a.getY());
	}
	public void movePointTo(int x, int y){
		movePointTo(new CartPoint(x,y));
	}
	
	public String toString(){
		return (  "X:"+x+"Y:"+y  );
	}
	
	public void recursivePosMove(int location, int destination){
		if (location<destination){
			recursivePosMove(location+1, destination);
		}else if (location>destination){
			recursivePosMove(location-1, destination);
		}else if (location == destination){
			return;
		}
	}
	
}
