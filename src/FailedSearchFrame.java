import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextPane;
import javax.swing.border.Border;

public class FailedSearchFrame extends JFrame {

	public FailedSearchFrame() {
		this.setTitle("Google Middle Earth - Search Failed");
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
		
		JTextArea message = new JTextArea();
		message.setBackground(this.getBackground());
		Font font = new Font("Times New Roman", Font.PLAIN, 18);
		message.setFont(font);
		message.setText("Missing location or destination. Try again.");
		message.setEditable(false);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==ok) {
					FailedSearchFrame.super.dispose();
				}
			}
		});

		panel.add(Box.createVerticalStrut(25));
		panel.add(message);
		panel.add(Box.createVerticalStrut(10));
		ok.setAlignmentX(panel.CENTER_ALIGNMENT);
		panel.add(ok);
		panel.add(Box.createVerticalStrut(25));
		return panel;
	}

}
