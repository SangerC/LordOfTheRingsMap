import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Path {
	
	Integer distance;
	Node n1;
	Node n2;
	ArrayList<Graph.Mode> modes;
	
	public Path(Node n1, Node n2, ArrayList<Graph.Mode> modes){
		this.n1 = n1;
		this.n2 = n2;
		this.modes = modes;
	}
	
	public void setDist(int dist) {
		this.distance = dist;
	}
	
	public Integer getDist() {
		return this.distance;
	}
	
	public Node[] getBothNode() {
		Node[] ns = {n1, n2};
		return ns;
	}
	
	public Node getOtherNode(Node n) {
		if (n.equals(this.n1)) {
			return this.n2;
		} else if (n.equals(this.n2)) {
			return this.n1;
		}
		return null;
	}

	public void drawOn(Graphics2D g) {
		if (this.modes.contains(Graph.Mode.BOAT)){
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.GREEN);
		}
		
		g.drawLine(n1.getX(), n1.getY(), n2.getX(), n2.getY());
	}
	
}
