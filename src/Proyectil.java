
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Proyectil {
	private Game game;
	private int y = 0;
	private int velocidad = -5;
	private int x;								// (or bin)
	private Image img;
	public final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Inicio.class);

	public Proyectil(Game game) {

		this.game = game;
		x = game.getV().getX() + 55;
		y = game.getHeight() -100;
		LoadImageDemo();
		
	}
	public void  LoadImageDemo() {
	      // Load an external image via URL
		 
	      URL imgUrl = getClass().getClassLoader().getResource(game.IMGSHOOTNAME);
	      System.out.println(imgUrl);
	      if (imgUrl == null) {
	         System.err.println("Couldn't find file: " +game.IMGSHOOTNAME);
	      } else {
	         try {
	            img = ImageIO.read(imgUrl);
	         } catch (IOException ex) {
	            ex.printStackTrace();
	         }
	      }

	   }

	public void move() {
		y = y +velocidad;
	}

	public void paint(Graphics2D g) {
		
		g.drawImage(img,x, y,null);

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, img.getWidth(game), img.getHeight(game));
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
}
