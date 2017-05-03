package AsteroidsWithSprites;

import javax.swing.JFrame;

public class VentanaAsteroid extends JFrame {

	
	public VentanaAsteroid(){
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setExtendedState(MAXIMIZED_BOTH);
		 this.setLocationRelativeTo(null);
		 
		 this.pack();
		 this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		VentanaAsteroid Asteroids = new VentanaAsteroid();
		

	}

}
