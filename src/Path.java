import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Path {

	Integer distance;
	Node n1;
	Node n2;
	ArrayList<Graph.Mode> modes;
	boolean visible = false;

	public Path(Node n1, Node n2, ArrayList<Graph.Mode> modes) {
		this.n1 = n1;
		this.n2 = n2;
		this.modes = modes;
		setDist();
	}

	public void setDist() {
		this.distance = (int) Math.sqrt((n1.x - n2.x)*(n1.x - n2.x)+(n1.y - n2.y)*(n1.y - n2.y));
	}

	public Integer getDist() {
		return this.distance;
	}

	public Node[] getBothNode() {
		Node[] ns = { n1, n2 };
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
		if (this.visible == true) {
			if (this.modes.contains(Graph.Mode.BOAT)) {
				g.setColor(Color.BLUE);
			} else {
				g.setColor(Color.MAGENTA);
			}

			g.drawLine(n1.getX() + 9, n1.getY() + 9, n2.getX() + 9, n2.getY() + 9);
		}
	}

	public void setVisible() {
		this.visible = true;
	}
	
	public void setInvisible() {
		this.visible = false;
	}
}
