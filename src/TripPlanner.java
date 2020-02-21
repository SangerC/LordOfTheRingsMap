import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class TripPlanner extends JFrame {

	private Graph graph;
	private JTextField maxCost;
	private JLabel costTypeLabel;
	private JLabel tdLabel;
	private JLabel costLabel;
	private JComboBox<String> timeDistance;
	private JComboBox<String> start;
	private JLabel locLabel;
	private JTextField location;
	private JLabel destLabel;
	private JTextField destination;
	private JComboBox<String> end;

	
	public TripPlanner(Graph graph) {
		this.graph = graph;
		
		this.setTitle("Trip Planner");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
		
		
		
		
		this.tdLabel = new JLabel("Time/Distance");
		this.timeDistance = new JComboBox<>();
		this.timeDistance.addItem("(Select time or distance)");
		this.timeDistance.addItem("Time");
		this.timeDistance.addItem("Distance");
		this.tdLabel.setAlignmentX(this.CENTER_ALIGNMENT);
		this.timeDistance.setAlignmentX(this.CENTER_ALIGNMENT);
		
		this.costLabel = new JLabel("Max Cost");
		this.costLabel.setAlignmentX(this.CENTER_ALIGNMENT);

		this.maxCost = new JTextField();
		this.maxCost.setAlignmentX(this.CENTER_ALIGNMENT);
		
		this.costTypeLabel = new JLabel("Days");
		this.costTypeLabel.setAlignmentX(this.CENTER_ALIGNMENT);
		
		
		
		
		this.location = new JTextField(20);
		this.destination = new JTextField(20);
		this.locLabel = new JLabel("Location");
		this.destLabel = new JLabel("Possible Destinations");		
		this.location.setAlignmentX(this.CENTER_ALIGNMENT);
		this.destination.setAlignmentX(this.CENTER_ALIGNMENT);
		this.locLabel.setAlignmentX(this.CENTER_ALIGNMENT);
		this.destLabel.setAlignmentX(this.CENTER_ALIGNMENT);
		this.add(Box.createVerticalStrut(200));
		

		this.start = new JComboBox<>();
		for(String s : graph.nodes.keySet()) {
			this.start.addItem(s);
		}
		this.start.setAlignmentX(this.CENTER_ALIGNMENT);
		
		this.end = new JComboBox<>();
		for(String s : graph.nodes.keySet()) {
			this.end.addItem(s);
		}
		this.end.setAlignmentX(this.CENTER_ALIGNMENT);
		
		this.maxCost.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				filterDest();
			}
			
		});
		
		
		this.location.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				start.removeAllItems();
				for(String s : graph.nodes.keySet()) {
					if(s.contains(location.getText()))start.addItem(s);
				}
				filterDest();
			}		
		});
		
		this.destination.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				filterDest();
			}		
		});
		
		this.timeDistance.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(timeDistance.getSelectedItem().equals("Time")) {
					costTypeLabel.setText("Days");
				}
				else costTypeLabel.setText("Miles");
			}
		});
		
		panel.add(Box.createVerticalStrut(40));
		panel.add(this.tdLabel);
		panel.add(this.timeDistance);
		panel.add(Box.createVerticalStrut(40));
		panel.add(costLabel);
		panel.add(Box.createVerticalStrut(5));
		panel.add(maxCost);
		panel.add(Box.createVerticalStrut(5));
		panel.add(costTypeLabel);
		panel.add(Box.createVerticalStrut(40));
		panel.add(locLabel);
		panel.add(location);
		panel.add(start);
		panel.add(destLabel);
		panel.add(destination);
		panel.add(end);
		panel.add(Box.createVerticalStrut(200));
		return panel;
	}
	
	
	private void filterDest(){
		end.removeAllItems();
		
		String locText = (String) start.getSelectedItem();
		
		Graph.Cost cOrd;
		
		if (timeDistance.getSelectedItem()=="Distance") {
			cOrd = Graph.Cost.DISTANCE;
		} else {
			cOrd = Graph.Cost.TIME;
		}
		
		for(String s : graph.nodes.keySet()) {
			graph.findShortestPath(graph.nodes.get(locText), graph.nodes.get(s), cOrd);
			if(s.contains(destination.getText())&&Integer.valueOf(maxCost.getText())>=graph.nodes.get(s).cost&&!s.equals(start.getSelectedItem())) end.addItem(s);
		}
	}
	
	
}

