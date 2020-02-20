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


public class SearchResultFrame extends JFrame {

	private String location;
	private String destination;
	private Graph.Cost method;
	private int cost;
	
	public SearchResultFrame(String location, String destination, Graph.Cost method, int cost) {
		this.location = location;
		this.destination = destination;
		this.method = method;
		this.cost = cost;
		
		this.setTitle("Google Middle Earth - Results");
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
		
		JTextArea message = new JTextArea();
		message.setBackground(this.getBackground());
		Font font = new Font("Times New Roman", Font.PLAIN, 18);
		message.setFont(font);
		message.setText("   "+this.location+" => "+this.destination + "\n   "+this.method.toString()+": "+ getCostString());
		message.setEditable(false);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==ok) {
					SearchResultFrame.super.dispose();
				}
			}
		});
		
		panel.add(Box.createVerticalStrut(25));
		message.setAlignmentX(panel.CENTER_ALIGNMENT);
		panel.add(message);
		panel.add(Box.createVerticalStrut(10));
		ok.setAlignmentX(panel.CENTER_ALIGNMENT);
		panel.add(ok);
		panel.add(Box.createVerticalStrut(25));
		
		return panel;
	}
	
	private String getCostString() {
		String output = "";
		output += String.valueOf(cost);
		if(method == Graph.Cost.DISTANCE)output += " Miles";
		else output += " Days";
		return output;
	}
	
}
