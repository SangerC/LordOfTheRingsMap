import java.util.ArrayList;

public class Node {

	String name;
	Integer x;
	Integer y;

	ArrayList<Path> paths;
	ArrayList<Node> nodes;

	public Node(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.nodes = new ArrayList<Node>();
		this.paths = new ArrayList<Path>();
	}

	public void addNode(Node n) {
		nodes.add(n);
//		this.paths.put(n, new Path(this, n));
	}

	public Boolean checkConnect(Node n) {
		return (this.nodes.contains(n));
	}

}
