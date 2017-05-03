import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class JuegoPanel extends JPanel implements KeyListener, Runnable{
	 private int [] vx1 = {380, 350, 410};
     private int [] vy1 = {75, 140, 140};
      
     private int angulo;
     
     
	public JuegoPanel(){
	super();
	this.setPreferredSize(new Dimension(1920,1080));

	setBackground(Color.BLACK); 
	
	this.addKeyListener(this);
	this.setFocusable(true);
	
	Thread hilo = new Thread(this);
	hilo.start();
	
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d =(Graphics2D)g;
			
		
		 g2d.setColor(Color.WHITE);
	     
	     g2d.rotate(Math.toRadians(angulo), vx1[0]-10, vy1[0]-10);
	     g2d.fillPolygon (vx1, vy1, 3);
		
	}


	public void setX1(int a, int b, int c){
		this.vx1[0]=a;
		this.vx1[1]=b;
		this.vx1[2]=c;		
	}
	public void setY1(int a, int b, int c){
		this.vy1[0]=a;
		this.vy1[1]=b;
		this.vy1[2]=c;
		
	}
	//runnable
	public void run() {
		
	}

		//key listener
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void moveUP(){
		this.vy1[0]-=10;
		this.vy1[1]-=10;
		this.vy1[2]-=10;
	}
	public void moveDOWN(){
		this.vy1[0]+=10;
		this.vy1[1]+=10;
		this.vy1[2]+=10;
	}

	public void moveRIGHT(){
		angulo+=15;
			
	}
	public void moveLEFT(){
		angulo-=15;
		
	}

	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			moveUP();
			setY1(vy1[0],vy1[1],vy1[2]);
			repaint();
			}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			moveDOWN();
			setY1(vy1[0],vy1[1],vy1[2]);
			repaint();
			}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			moveRIGHT();
			//setX1(vx1[0],vx1[1],vx1[2]);
			repaint();
			}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			moveLEFT();
			//setX1(vx1[0],vx1[1],vx1[2]);
			repaint();
			}
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}