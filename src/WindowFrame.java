import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
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
			ControlPanel  controlPanel = new ControlPanel(graph);
			controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
			controlPanel.setBackground(Color.LIGHT_GRAY);
		
			//Adding the panels to the frame and making the frame visible
			this.getContentPane().add(BorderLayout.WEST, controlPanel);
			this.getContentPane().add(mapPanel, BorderLayout.CENTER);
			this.pack();
			this.setVisible(true);
		}
}
