import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Asteroids extends JFrame{

	public Asteroids(){
		super("Asteroids");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setPreferredSize(new Dimension(1080,800));
		
		this.setExtendedState(MAXIMIZED_BOTH);
		
		JOptionPane.showMessageDialog(null,"JUGAR");
		
		JuegoPanel jp= new JuegoPanel();
		this.add(jp);
		
		
		this.pack();
		this.setVisible(true);		
	}
	
	
	
	public static void main(String[] args) {
		Asteroids steroids = new Asteroids();

	}

}
