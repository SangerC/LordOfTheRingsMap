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
	
	public ControlPanel() {
		this.addTextFieldsAndLabels();
		this.addCheckBoxes();
		this.addComboBoxAndItsItems();
		this.addAndHandleGoButton();
	}
	
	public void addTextFieldsAndLabels() {
		this.location = new JTextField(20);
		this.destination = new JTextField(20);
		this.locLabel = new JLabel("Location");
		this.destLabel = new JLabel("Destination");
		this.add(Box.createVerticalStrut(200));
		this.add(locLabel);
		this.add(location);
		this.add(destLabel);
		this.add(destination);
	}
	
	public void addCheckBoxes() {
		this.walk = new JCheckBox("Walk");
		this.horse = new JCheckBox("Horse");
		this.boat = new JCheckBox("Boat");
		this.walk.setBackground(Color.LIGHT_GRAY);
		this.horse.setBackground(Color.LIGHT_GRAY);
		this.boat.setBackground(Color.LIGHT_GRAY);
		ButtonGroup checkBoxGroup = new ButtonGroup();
		checkBoxGroup.add(this.walk);
		checkBoxGroup.add(this.horse);
		checkBoxGroup.add(this.boat);
		this.add(Box.createVerticalStrut(150));
		this.add(this.walk);
		this.add(this.horse);
		this.add(this.boat);
	}
	
	public void addComboBoxAndItsItems() {
		this.tdLabel = new JLabel("Time/Distance");
		this.timeDistance = new JComboBox<>();
		this.timeDistance.addItem("(Select time or distance)");
		this.timeDistance.addItem("Time");
		this.timeDistance.addItem("Distance");
		this.add(Box.createVerticalStrut(100));
		this.add(this.tdLabel);
		this.add(this.timeDistance);
	}
	
	public void addAndHandleGoButton() {
		this.go = new JButton("GO!");
		this.go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String locText = location.getText();
				String destText = destination.getText();
				if(e.getSource()==go) {
					if(location.getText().isEmpty() || destination.getText().isEmpty()) {
						System.out.println("Missing location or destination. Try again.");
					}
					else {
						System.out.println(locText + " => " + destText);
						if(walk.isSelected()) {
							System.out.println("The long way 'round.");
						}
					}
					location.setText(null);
					destination.setText(null);
				}
			}
		});
		this.add(Box.createVerticalStrut(150));
		this.add(go);
		this.add(Box.createVerticalStrut(100));
	}
}
