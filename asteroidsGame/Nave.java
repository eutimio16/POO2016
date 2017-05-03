package AsteroidsWithSprites;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Nave {
	private Image nave;
	private int Vx,
	Vy,
	x,
	y;

	public Nave(){
		ImageIcon imagenNave = new ImageIcon(this.getClass().getResource("nave_pequena.png"));
		nave= imagenNave.getImage();

		x=520;
		y=370;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public void avanzar(){
		x+=Vx;
		y+=Vy;
		
	}
	
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT){
			Vx = 5;
		}
		if (key == KeyEvent.VK_LEFT){
			Vx = -5;
		}
		if (key == KeyEvent.VK_UP){
			Vy = -5;
		}
		if (key == KeyEvent.VK_DOWN){
			Vy = 5;
		}        
	}

	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_RIGHT){
			Vx = 0;
		}
		if (key == KeyEvent.VK_LEFT){
			Vx = 0;
		}
		if (key == KeyEvent.VK_UP){
			Vy = 0;
		}
		if (key == KeyEvent.VK_DOWN){
			Vy = 0;
		}      
	}

	public Image getImage() {

		return nave;
	}

}
