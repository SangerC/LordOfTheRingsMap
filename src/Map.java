import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {

	private ArrayList<Node> nodes;
	
	public Map() {
		this.nodes = new ArrayList<>();
		readFile();
	}
	
	public void readFile() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("src\\NodeList.txt"));
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
			return;
		}
		while(scanner.hasNextLine()) {
			this.nodes.add(new Node(null, scanner.nextInt()-12, scanner.nextInt()-12));
			if(!scanner.hasNextLine()) {
				break;
			}
			scanner.nextLine();
		}
		scanner.close();
	}
	
	public ArrayList<Node> getNodes(){
		return this.nodes;
	}
}
