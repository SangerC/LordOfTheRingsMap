import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	HashMap<String, Node> nodes;
	ArrayList<Path> path;
	public enum Cost {TIME, DISTANCE};
	
	
	
	
	
	
	
	
	
	public ArrayList<Path> findShortestPath(String name, ArrayList<Path.Mode> modes, Cost cost){
		Node n = nodes.get(name);
		
		
		
		
	}
	
	private int cost(int distance, Cost cost,Path.Mode mode){
		if(cost==Cost.DISTANCE)return distance;
		
		if(mode==Path.Mode.BOAT)return distance;
		if(mode==Path.Mode.HORSE)return distance*2;
		else return distance*4;
	}

}
