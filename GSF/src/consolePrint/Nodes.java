package consolePrint;

public class Nodes {
	CartPoint point;
	Nodes lastNode;
	
	public Nodes() {
	}
	
	public Nodes(CartPoint first){
		point = first;
	}
	
	public void stackNodeOnTop(CartPoint point, Nodes node){
		if(node.lastNode==null){
			node.lastNode=new Nodes(point);
		}else{
			stackNodeOnTop(point, node.lastNode);
		}
	}
	
	@Override
	public String toString(){
		return ( "X:" + (point.getX()) + "Y:"+point.getY());
	}
	
	public void printNodes(Nodes nodes){
		if(nodes.lastNode==null){
			System.out.println(nodes);
			return;
		}else{
			System.out.println(nodes);
			printNodes(nodes.lastNode);
		}
		
	}
	
	public CartPoint returnFirstPoint(){
		return this.point;
	}
	
	public Nodes popPoint(){
		CartPoint aPoint = this.point;
		Nodes newNode = this.lastNode;
		return this.lastNode;
	}
	
	
}
