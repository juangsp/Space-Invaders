

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * 
 */

/**
 * @author Juan
 *
 */
public class Juego extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	private Game game;
	public final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Inicio.class);

	public Juego() {
		iniciarJuego();
		
		
	}

	public void iniciarJuego() {
		log.trace("Se crean las distintas opciones de juego");
		game=new Game(this);
		game.addKeyListener();
		this.add(game);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while(true){
		game.move();	
		game.repaint();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			log.warn("Proceso Interumpido");
		}
		}
	}
		
	}
	
	

	

	
	

	
	

