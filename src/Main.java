import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	Graph graph;
	WindowFrame windowFrame;
	
	public void getNodesfromText() {
		
		HashMap<String, Node> nodes = new HashMap<String, Node>();
		
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
				
				String name = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				nodes.put(name, new Node(name, x, y));

			} catch (IOException e) {
				hasMoreLines = false;
			} catch (NumberFormatException e) {
				System.err.println(e.getMessage());
			}
		} // end of while
		
		getEdgesfromText(nodes, "EdgeList.txt");
	}
	
	
	
	public void getEdgesfromText(HashMap<String, Node> nodes, String filename) {
		
	}
	
	public static void main(String[] args) {
		WindowFrame frame = new WindowFrame();
	}
	
	
	
	
}
//

//https://docs.google.com/document/d/1oi5XLrY79R7I8JhC74IQpLMWnCZqIC4ew-tfuvrwfE8/edit?usp=sharing
