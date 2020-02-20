import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WindowFrame extends JFrame{
		
	public WindowFrame(Graph graph) {	
			//Create the JFrame that contains all components
			this.setTitle("Google Middle Earth");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			//Create the panel that displays the map and its paths
			MapPanel mapPanel = new MapPanel(graph.path);
			
			//Create the panel that contains all the navigation controls
			ControlPanel  controlPanel = new ControlPanel(graph, mapPanel);
			controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
			controlPanel.setBackground(Color.LIGHT_GRAY);
		
			//Adding the panels to the frame and making the frame visible
			this.getContentPane().add(BorderLayout.WEST, controlPanel);
			
//			JScrollPane sPane = new JScrollPane(mapPanel);
//			sPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//			sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//			sPane.setBounds(0, 0, 1200, 750);
//			sPane.addAncestorListener(new AncestorListener() {
//			
//				@Override
//				public void ancestorAdded(AncestorEvent event) {
//					JScrollPane sPane = (JScrollPane)event.getComponent();
//					sPane.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//				}
//
//				@Override
//				public void ancestorMoved(AncestorEvent event) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void ancestorRemoved(AncestorEvent event) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
			
			JPanel layeredPanel = new JPanel();
			layeredPanel.add(mapPanel);
			
			this.getContentPane().add(layeredPanel, BorderLayout.CENTER);
			this.pack();
//			Dimension center = Toolkit.getDefaultToolkit().getScreenSize();
//			this.setLocation(center.width/2 - this.getSize().width/2, center.height/2 - this.getSize().height/2);
			this.setVisible(true);
		}
}
