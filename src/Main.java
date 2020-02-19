import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	Graph graph;
	WindowFrame windowFrame;
	
	public Main() {
		this.windowFrame = new WindowFrame();
		this.graph = new Graph();
	}
	
	public void addGraphElement() {

		//getNodesfromText();
		//getEdgesfromText();

	}
	
	public void getNodesfromText() {
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("NodeList.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		String line;
		StringTokenizer st;
		boolean hasMoreLines = true;
		
		while (hasMoreLines) {
			try {
				line = reader.readLine();
				if (line == null)
					break;
				st = new StringTokenizer(line);
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				graph.nodes.put(name, new Node(name, x, y));

			} catch (IOException e) {
				hasMoreLines = false;
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
			}
		} // end of while
	}
	
	
	
	public void getEdgesfromText() {
		
		ArrayList<Graph.Mode> boat = new ArrayList<Graph.Mode>();
		boat.add(Graph.Mode.BOAT);
		
		ArrayList<Graph.Mode> walk = new ArrayList<Graph.Mode>();
		walk.add(Graph.Mode.WALKING);
		walk.add(Graph.Mode.HORSE);
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("src\\EdgeList.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		String line;
		StringTokenizer st;
		boolean hasMoreLines = true;
		
		while (hasMoreLines) {
			try {
				line = reader.readLine();
				if (line == null)
					break;
				st = new StringTokenizer(line);
				
				String nodeName1 = st.nextToken();
				String nodeName2 = st.nextToken();
				String mode = st.nextToken();
				
				Node n1 = graph.nodes.get(nodeName1);
				Node n2 = graph.nodes.get(nodeName2);
				Path p = null;
				
				if (mode.contentEquals("boat")) {
					p = new Path(n1, n2, boat);
				} else {
					p = new Path(n1, n2, walk);
				}
				
				graph.path.add(p);
				n1.addConnection(n2, p);
				n2.addConnection(n1, p);

			} catch (IOException e) {
				hasMoreLines = false;
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
			}
		} // end of while
	}
	
	public static void main(String[] args) {
//		WindowFrame frame = new WindowFrame();
		
		Main main = new Main();
		main.addGraphElement();
	}
	
	
	
	
}
//

//https://docs.google.com/document/d/1oi5XLrY79R7I8JhC74IQpLMWnCZqIC4ew-tfuvrwfE8/edit?usp=sharing
