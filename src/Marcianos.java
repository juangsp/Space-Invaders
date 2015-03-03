import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Marcianos {
	Game game;

	public int x = 30;
	public int y = 0;
	public int xa =0;
	public int ya = 25;
	public int posicionY;
	public int posicionX;
	public int puntuacion = 10;
	public int velocidad=0;
	private Image img;
	private Image img2;
	private boolean muerto=false;
	public final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Inicio.class);

	public Marcianos(int x, int y, Game game,int velocidad) {
		this.game = game;
		posicionY = y;
		posicionX = x;
		LoadImageDemo();
		this.velocidad=velocidad;
		xa=this.velocidad;
		
			
	}
	
	 public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}

	public void  LoadImageDemo() {
	      // Load an external image via URL
	      URL imgUrl = getClass().getClassLoader().getResource(game.IMGMARNAME);
	      URL imgUrl2 = getClass().getClassLoader().getResource("res/explosion.png");
	      if (imgUrl == null) {
	         System.err.println("Couldn't find file: " + game.IMGMARNAME);
	      } else {
	         try {
	            img = ImageIO.read(imgUrl);
	            img2=ImageIO.read(imgUrl2);
	         } catch (IOException ex) {
	            ex.printStackTrace();
	         }
	      }

	   }
	 
	
	public int getPuntuacion() {
		return puntuacion;
	}

	public void move() {
	

		if (x + xa < 10) {
			xa=velocidad;
			y = y + ya;
		}
		if(game.getLevel()==1){

		if (x + xa > game.getWidth() -(img.getWidth(game)*game.FILA1)){
			xa = -velocidad;
			y = y + ya;
		}
		}else if(game.getLevel()==2){

			if (x + xa > game.getWidth() -(img.getWidth(game)*game.FILA2)){
				xa = -velocidad;
				y = y + ya;
			}
		}else if(game.getLevel()==3){

				if (x + xa > game.getWidth() -(img.getWidth(game)*game.FILA3)) {
					xa = -velocidad;
					y = y + ya;
				}
		}
		if(collisionNave()){
			game.gameOver();
		}
		x = x + xa;
	}

	public void paint(Graphics2D g) {
		
		g.drawImage(img,x + posicionX, y + posicionY,null);
		if(muerto==true){
			g.drawImage(img2,x + posicionX, y + posicionY,null);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public  boolean collision() {
		if(game.getP()!=null){
			return game.getP().getBounds().intersects(getBounds());
		}
		return false;	
		
	}
	
	private boolean collisionNave() {
		
		return game.getV().getBounds().intersects(getBounds());
	}
	public Rectangle getBounds() {
		return new Rectangle(x + posicionX, y + posicionY,img.getWidth(game) ,img.getHeight(game));
	}

}
