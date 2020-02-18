import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	HashMap<String, Node> nodes;
	ArrayList<Path> path;
	public enum Cost {TIME, DISTANCE};
	public enum Mode {WALKING, HORSE, BOAT};
	
	
	
	
	
	
	
	
	
	public ArrayList<Path> findShortestPath(Node n, ArrayList<Mode> modes, Cost cost){
		WorkingNode wn = new WorkingNode(n);
		wn.cost=0;
		wn.known=true;
		
		ArrayList<Workin>
		WorkingNode closest;
		for(){
			
			
			
		}
		
		
		
	}
	
	private class WorkingNode{
		
		private Boolean known;
		private int cost;
		private ArrayList<Path> shortestPath;
		private Node n;
		
		public WorkingNode(Node node) {
			n = node;
			known=false;
			shortestPath = new ArrayList<Path>();
		}
	}
	
	private int cost(int distance, Cost cost,Mode mode){
		if(cost==Cost.DISTANCE)return distance;
		
		if(mode==Mode.BOAT)return distance;
		if(mode==Mode.HORSE)return distance*2;
		else return distance*4;
	}

}
