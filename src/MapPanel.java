import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MapPanel extends JPanel{
	
	private Map map;
	private ArrayList<Path> path;

	public MapPanel(ArrayList<Path> path) {
		this.map = new Map();
		this.path = path;
//		for(Node node : this.map.getNodes()) {
//			this.add(node);
//			node.setLocation(node.getX(), node.getY());
//		}
		this.setPreferredSize(new Dimension(1300, 850));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			BufferedImage img = ImageIO.read(new File("FullMEMap.jpeg"));
			g.drawImage(img, 0, 0, 1536, 1280, null);
		} catch(IOException e) {
			e.printStackTrace();
		}
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i=0; i<this.path.size(); i++) {
			//Node node1 = this.map.getNodes().get(i);
			//Node node2 = this.map.getNodes().get(i+1);
			g2.setColor(Color.BLUE);
			g2.setStroke(new BasicStroke(3));
			//g2.drawLine(node1.getX()+9, node1.getY()+9, node2.getX()+9, node2.getY()+9);
			path.get(i).drawOn(g2);
		}
		
		for(Node node : this.map.getNodes()) {
			node.drawOn(g2);
//			for(Node node2 : this.map.getNodes()) {
//				if(!node.equals(node2)) {
//					g2.setColor(Color.RED);
//					g2.drawLine(node.getX()+12, node.getY()+12, node2.getX()+12, node2.getY()+12);
//				}
//			}
		}
	}

}
