import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class FailedSearchFrame extends JFrame {

	public FailedSearchFrame() {
		this.setTitle("Google Middle Earth - Search Failed");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
//		this.add(Box.createVerticalStrut(50), BorderLayout.NORTH);
//		this.add(Box.createHorizontalStrut(50), BorderLayout.WEST);
//		this.add(message, BorderLayout.CENTER);
//		this.add(Box.createHorizontalStrut(50), BorderLayout.EAST);
		JPanel panel = displayPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		this.add(panel, BorderLayout.CENTER);
//		this.add(ok, BorderLayout.AFTER_LAST_LINE);
//		this.setSize(new Dimension(480, 240));
		this.setSize(300, 200);
		
		Dimension center = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(center.width/2 - this.getSize().width/2, center.height/2 - this.getSize().height/2);
		this.setVisible(true);
	}
	
	public JPanel displayPanel() {
		JPanel panel = new JPanel();
		
		JTextArea message = new JTextArea();
		message.setBackground(this.getBackground());
		message.setText("          Missing location or destination. Try again.");
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==ok) {
					FailedSearchFrame.super.dispose();
				}
			}
		});
		panel.add(Box.createVerticalStrut(25));
		panel.add(message, BorderLayout.CENTER);
		panel.add(Box.createVerticalStrut(25));
		panel.add(ok);
		panel.add(Box.createVerticalStrut(25));
		return panel;
	}

}
