package algorithm;

public class Location{
	float x = 0;
	float y = 0;
	
	public Location(float u, float v){
		x = u;
		y = v;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public boolean equals(Location l){
		return (l.getX() == x && l.getY() == y);
	}
}
