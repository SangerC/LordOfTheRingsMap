import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControlPanel extends JPanel {
	
	private JTextField location;
	private JTextField destination;
	private JCheckBox walk;
	private JCheckBox horse;
	private JCheckBox boat;
	private JComboBox<String> timeDistance;
	private JButton go;
	private JLabel locLabel;
	private JLabel destLabel;
	private JLabel tdLabel;
	private Graph graph;
	private MapPanel mappanel;
	private JComboBox<String> start;
	private JComboBox<String> end;
	
	public ControlPanel(Graph graph, MapPanel panel) {
		this.graph = graph;
		this.mappanel = panel;
		this.addTextFieldsAndLabels();
		this.addComboBoxAndItsItems();
		this.addAndHandleGoButton();
	}
	
	public void addTextFieldsAndLabels() {
		this.location = new JTextField(20);
		this.destination = new JTextField(20);
		this.locLabel = new JLabel("Location");
		this.destLabel = new JLabel("Destination");		
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
		
		this.location.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				start.removeAllItems();
				for(String s : graph.nodes.keySet()) {
					if(s.contains(location.getText()))start.addItem(s);
				}
			}		
		});
		
		this.destination.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				end.removeAllItems();
				for(String s : graph.nodes.keySet()) {
					if(s.contains(destination.getText()))end.addItem(s);
				}
			}		
		});
		
		this.add(locLabel);
		this.add(location);
		this.add(start);
		this.add(destLabel);
		this.add(destination);
		this.add(end);
	}
	
	public void addComboBoxAndItsItems() {
		this.tdLabel = new JLabel("Time/Distance");
		this.timeDistance = new JComboBox<>();
		this.timeDistance.addItem("(Select time or distance)");
		this.timeDistance.addItem("Time");
		this.timeDistance.addItem("Distance");
		this.tdLabel.setAlignmentX(this.CENTER_ALIGNMENT);
		this.timeDistance.setAlignmentX(this.CENTER_ALIGNMENT);
		this.add(Box.createVerticalStrut(200));
		this.add(this.tdLabel);
		this.add(this.timeDistance);
	}
	
	public void addAndHandleGoButton() {
		this.go = new JButton("GO!");
		this.go.setAlignmentX(this.CENTER_ALIGNMENT);
		this.go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String locText = (String) start.getSelectedItem();
				String destText = (String) end.getSelectedItem();
						
				if(e.getSource()==go) {
						SearchResultFrame result = new SearchResultFrame(locText, destText);
						Graph.Cost cOrd;
						
						if (timeDistance.getSelectedItem()=="Distance") {//TODO:
							cOrd = Graph.Cost.DISTANCE;
						} else {
							cOrd = Graph.Cost.TIME;
						}
						graph.findShortestPath(graph.nodes.get(locText), graph.nodes.get(destText), cOrd);
						mappanel.repaint();
					
					location.setText(null);
					destination.setText(null);
				}
			}
		});
		this.add(Box.createVerticalStrut(75));
		this.add(go);
		this.add(Box.createVerticalStrut(250));
	}
	
}
