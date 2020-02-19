import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MapPanel extends JPanel{
	
	private Map map;

	public MapPanel() {
		this.map = new Map();
//		for(Node node : this.map.getNodes()) {
//			this.add(node);
//			node.setLocation(node.getX(), node.getY());
//		}
		this.setPreferredSize(new Dimension(1300, 850));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Node node : this.map.getNodes()) {
			node.drawOn(g2);
//			for(Node node2 : this.map.getNodes()) {
//				if(!node.equals(node2)) {
//					g2.setColor(Color.RED);
//					g2.drawLine(node.getX()+12, node.getY()+12, node2.getX()+12, node2.getY()+12);
//				}
//			}
		}
		for(int i=0; i<this.map.getNodes().size()-1; i++) {
			Node node1 = this.map.getNodes().get(i);
			Node node2 = this.map.getNodes().get(i+1);
			g2.setColor(Color.RED);
			g2.setStroke(new BasicStroke(3));
			g2.drawLine(node1.getX()+12, node1.getY()+12, node2.getX()+12, node2.getY()+12);
		}
	}

}
