package AsteroidsWithSprites;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JpanelAsteroids extends JPanel implements ActionListener {

	private Nave nave;
	private ImageIcon imagenIcon;
	public JpanelAsteroids(){
		
		super();
		this.setPreferredSize(new Dimension(1920,1080));

		setBackground(Color.BLACK);
		
		
		//this.setFocusable(true);
		
	}
	
	 public void paint(Graphics g) {
		 super.paintComponent(g);
		 Graphics2D g2d = (Graphics2D)g;
		 g2d.drawImage(imagenIcon.getImage(), 0, 0, this);  
		 g2d.drawImage(nave.getImage(), nave.getX(), nave.getY(), this);
		 
	 }
	 
	 public void actionPerformed(ActionEvent e){
		 nave.avanzar();
		 repaint();
		 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




















	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




















	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




















	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
