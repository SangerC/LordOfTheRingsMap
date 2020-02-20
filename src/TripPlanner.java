import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class TripPlanner extends JFrame {

	private String location;
	private String destination;
	private Graph.Cost method;
	private int cost;
	private Graph graph;

	
	public TripPlanner(Graph graph) {
		this.graph = graph;
		
		this.setTitle("Trip Planner");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = displayPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.add(Box.createHorizontalStrut(10), BorderLayout.WEST);
		this.add(panel, BorderLayout.CENTER);
		this.add(Box.createHorizontalStrut(10), BorderLayout.EAST);
		
		
		this.pack();
		this.setResizable(false);
		Dimension center = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(center.width/2 - this.getSize().width/2, center.height/2 - this.getSize().height/2);
		this.setVisible(true);
	}

	public JPanel displayPanel() {
		JPanel panel = new JPanel();
		

		return panel;
	}
	
	
}

