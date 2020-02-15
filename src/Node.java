import java.util.ArrayList;
import java.util.HashMap;

public class Node {

	private String name;
	private Integer x;
	private Integer y;
	
	private HashMap<Node, Path> paths;
	private ArrayList<Node> nodes;

	public Node(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	

}
