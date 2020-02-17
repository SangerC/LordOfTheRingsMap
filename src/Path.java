
public class Path {
	
	Integer distance;
	Node n1;
	Node n2;
	
	public Path(Node n1, Node n2) {
		this.n1 = n1;
		this.n2 = n2;
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

	
}
