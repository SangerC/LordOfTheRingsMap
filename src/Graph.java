import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	HashMap<String, Node> nodes;
	ArrayList<Path> path;
	public enum Cost {TIME, DISTANCE};
	public enum Mode {WALKING, HORSE, BOAT};
	
	
	
	
	
	
	
	
	
	public ArrayList<Path> findShortestPath(Node n, Node d, ArrayList<Mode> modes, Cost cost){
		Node wn = n;
		wn.cost=0;
		wn.known=true;
		wn.shortestPath= new ArrayList<Path>();
		
		while(!d.known) {
			for(Path p : wn.paths){
				for(Mode m : modes) {
					if(p.modes.contains(m)) {
						Node temp;
						if(!p.n1.known) temp = p.n1;
						else if(!p.n2.known) temp=p.n2;
						else break;
						
						int fromWN = cost(p.distance,cost,m)+wn.cost;
						if(temp.cost==-1 || fromWN<temp.cost) {
							temp.cost=fromWN;
							temp.shortestPath= new ArrayList<Path>();
							temp.shortestPath.addAll(wn.shortestPath);
							temp.shortestPath.add(p);
						}
					}
				}
			}
			
			int shortestCost = -1;
			for(String s : nodes.keySet()) {
				if((!nodes.get(s).known&&nodes.get(s).cost!=-1)&&(shortestCost==-1||nodes.get(s).cost<shortestCost)) {
					shortestCost = nodes.get(s).cost;
					wn = nodes.get(s);
				}
			}
			wn.known=true;
		}
		for(String s : nodes.keySet()) {
			nodes.get(s).cost=-1;
			nodes.get(s).known=false;
			nodes.get(s).shortestPath=null;
		}
		return wn.shortestPath;
	}
	
	private int cost(int distance, Cost cost,Mode mode){
		if(cost==Cost.DISTANCE)return distance;
		
		if(mode==Mode.BOAT)return distance;
		if(mode==Mode.HORSE)return distance*2;
		else return distance*4;
	}

}
