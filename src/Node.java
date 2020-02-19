import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Node {

	String name;
	Integer x;
	Integer y;

	ArrayList<Path> paths;
	ArrayList<Node> nodes;
	
	public Boolean known;
	public int cost;
	public ArrayList<Path> shortestPath;

	public Node(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.nodes = new ArrayList<Node>();
		this.paths = new ArrayList<Path>();
		this.cost = -1;
		this.known=false;
	}

	public void addNode(Node n) {
		nodes.add(n);
//		this.paths.put(n, new Path(this, n));
	}
	
	public void addConnection(Node n, Path p) {
		this.nodes.add(n);
		this.paths.add(p);
	}

	public Boolean checkConnect(Node n) {
		return (this.nodes.contains(n));
	}
	
	public void drawOn(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillOval(this.x, this.y, 25, 25);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
