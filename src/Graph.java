import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	HashMap<String, Node> nodes;
	ArrayList<Path> path;
	public enum Cost {TIME, DISTANCE};
	public enum Mode {WALKING, HORSE, BOAT};
	
	
	
	
	
	
	
	
	
	public ArrayList<Path> findShortestPath(String name, ArrayList<Mode> modes, Cost cost){
		Node n = nodes.get(name);
		
		
		
		
	}
	private class workingNode extends Node{
		public workingNode(Node n) {

		}

		
	}
	
	private int cost(int distance, Cost cost,Mode mode){
		if(cost==Cost.DISTANCE)return distance;
		
		if(mode==Mode.BOAT)return distance;
		if(mode==Mode.HORSE)return distance*2;
		else return distance*4;
	}

}
