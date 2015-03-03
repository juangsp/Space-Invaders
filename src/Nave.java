
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public class Nave {
	int x = 0;
	int xa = 0;
	private Game game;
	private Image img;
	public final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Inicio.class);

	public Nave(Game game) {
		
		this.game = game;
		LoadImageDemo();
		

	}
	public void  LoadImageDemo() {
	      // Load an external image via URL
	      URL imgUrl = getClass().getClassLoader().getResource(game.IMGNAVENAME);
	      System.out.println(imgUrl);
	      if (imgUrl == null) {
	         System.err.println("Couldn't find file: " + game.IMGNAVENAME );
	      } else {
	         try {
	            img = ImageIO.read(imgUrl);
	         } catch (IOException ex) {
	            ex.printStackTrace();
	         }
	      }

	   }
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - 60) {
			x = x + xa;
		}
	}
	
	public void paint(Graphics2D g) {

		g.drawImage(img,x,game.getHeight()-100,null);

	}

	public Rectangle getBounds() {
		return new Rectangle(x, game.getHeight() - 100, img.getWidth(game),img.getHeight(game));
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -4;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 4;
		}

	}

}
