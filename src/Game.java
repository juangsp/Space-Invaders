
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javafx.scene.media.*;

public class Game extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Marcianos m;
	private Nave v;
	private MiKeyListener listener;
	private Proyectil p=null;
	private int puntuacionTotal = 0;
	private ArrayList<Marcianos> marcianos = new ArrayList<Marcianos>();
	public  int FILA1;
	public  int COLUMNA1;
	public  int FILA2 ;
	public  int COLUMNA2;
	public  int FILA3 ;
	public  int COLUMNA3;
	public 	int WIDTH1;
	public  int HEIGTH1;
	public 	int WIDTH2;
	public  int HEIGTH2;
	public 	int WIDTH3;
	public  int HEIGTH3;
	public  String IMGMARNAME = "";
	public  String IMGNAVENAME  = "";
	public 	String  IMGSHOOTNAME = ""; 	
	private int level=1;
	private int escena=1;
	private boolean iniciado=false;
	private Juego j;
	
	public final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Inicio.class);
	

	public Game(Juego j) {
		Configuration conf = new Configuration();
			FILA1=Integer.parseInt(conf.getPropertyMy(Configuration.FILA1));
			COLUMNA1=Integer.parseInt(conf.getPropertyMy(Configuration.COLUMNA1));
	        FILA2=Integer.parseInt(conf.getPropertyMy(Configuration.FILA2));
	        COLUMNA2=Integer.parseInt(conf.getPropertyMy(Configuration.COLUMNA2));
	        FILA3=Integer.parseInt(conf.getPropertyMy(Configuration.FILA3));
	        COLUMNA3=Integer.parseInt(conf.getPropertyMy(Configuration.COLUMNA3));
	        WIDTH1=Integer.parseInt(conf.getPropertyMy(Configuration.WIDTH1));
	        HEIGTH1=Integer.parseInt(conf.getPropertyMy(Configuration.HEIGTH1));
	        WIDTH2=Integer.parseInt(conf.getPropertyMy(Configuration.WIDTH2));
	        HEIGTH2=Integer.parseInt(conf.getPropertyMy(Configuration.HEIGTH2));
	        WIDTH3=Integer.parseInt(conf.getPropertyMy(Configuration.WIDTH3));
	        HEIGTH3=Integer.parseInt(conf.getPropertyMy(Configuration.HEIGTH3));
	        IMGMARNAME=conf.getPropertyMy(Configuration.IMGMARNAME);
	        IMGNAVENAME=conf.getPropertyMy(Configuration.IMGNAVENAME);	
	        IMGSHOOTNAME=conf.getPropertyMy(Configuration.IMGSHOOTNAME);
	       
	    		
		this.j=j;
		this.setLayout(new FlowLayout());
		v = new Nave(this);
		this.setSize(new Dimension(j.WIDTH,j.HEIGHT));
		
	}

	public Juego getJ() {
		return j;
	}


	public void setJ(Juego j) {
		this.j = j;
	}


	public Nave getV() {
		return v;
	}

	public Proyectil getP() {
		return p;
	}

	public void setP(Proyectil p) {
		this.p = p;
	}

	public void move() {

		for (int i = 0; i < marcianos.size(); i++) {
			marcianos.get(i).move();
		}
		v.move();
		if (ganar()&& iniciado) {
			log.trace("Has ganado");
			JOptionPane.showMessageDialog(this,
					"Has ganado!! Has obtenido "+puntuacionTotal,
					"Enhorabuena!!!", JOptionPane.YES_NO_OPTION);
			System.exit(ABORT);
		} else {

			if (p != null) {
				p.move();
				colisionDisparo();
			}
		}

	}

	public void crearMarcianos() {
		if (level == 1) {
			log.trace("Creados marcianos nivel 1");
			for (int i = 0; i <= COLUMNA1; i++) {
				for (int j = 0; j <= FILA1; j++) {
					marcianos.add(new Marcianos(j * 50, i * 50, this, 2));
				}

			}
		}

		if (level == 2) {
			log.trace("Creados marcianos nivel 2");
			for (int i = 0; i <=COLUMNA2; i++) {
				for (int j = 0; j <=FILA2; j++) {
					marcianos.add(new Marcianos(j * 50, i * 50, this, 3));
				}

			}
		}
		if (level == 3) {
			log.trace("Creados marcianos nivel 3");
			for (int i = 0; i <=COLUMNA3; i++) {
				for (int j = 0; j <=FILA3; j++) {
					marcianos.add(new Marcianos(j * 50, i * 50, this, 4));
				}

			}
		}
	}

	public void colisionDisparo() {
		for (int i = 0; i < marcianos.size(); i++) {

			if (marcianos.get(i).collision() == true) {
				puntuacionTotal = puntuacionTotal
						+ marcianos.get(i).getPuntuacion();
				marcianos.get(i).setMuerto(true);
				marcianos.get(i).paint((Graphics2D) getGraphics());
				marcianos.remove(i);
				p = null;

			}
		}
	}

	public void gameOver() {
		log.trace("Final del juego-Game over");
		JOptionPane.showMessageDialog(this, "OH!Has fallado!!!", "Game Over",
				JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);

	}

	public boolean ganar() {
		if (marcianos.size() == 0) {
			return true;
		}
		return false;

	}
	

	public void paint(Graphics g) {
		 super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		Dimension tamanio = null ;
		if(level==1){
			tamanio = new Dimension(WIDTH1,HEIGTH1);
		}else if(level==2){
		 tamanio = new Dimension(WIDTH2,HEIGTH2);
		}else if(level==3){
			 tamanio = new Dimension(WIDTH3,HEIGTH3);
		}
		
		ImageIcon imagenFondo;
	switch (escena) {
	case 1:
		
		Dimension tamanioI=new Dimension(j.WIDTH,j.HEIGHT);
		imagenFondo = new ImageIcon(getClass().getResource(
				"res/Space_Invaders_-_2002_-_Activision.jpg"));
		g2d.drawImage(imagenFondo.getImage(), 0, 0, tamanioI.width,
				tamanioI.height, null);
		setOpaque(true);
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString("Pulsa ENTER", 250, 600);
		break;
	case 2:
		Dimension tamanioS=new Dimension(j.WIDTH,j.HEIGHT);
		imagenFondo = new ImageIcon(getClass().getResource(
				"res/hubble2010-3.jpg"));
		g2d.drawImage(imagenFondo.getImage(), 0, 0, tamanioS.width,
				tamanioS.height, null);
		setOpaque(true);
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString("Seleciona el nivel al que quieres jugar", 50, 100);
		g2d.drawString("Pulsa 1 para nivel 1", 250,200);
		g2d.drawString("Pulsa 2 para nivel 2", 250,400);
		g2d.drawString("Pulsa 3 para nivel 3", 250,600);
		break;
	case 3:

		imagenFondo = new ImageIcon(getClass().getResource(
				"res/hubble2010-3.jpg"));
		g2d.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width,
				tamanio.height, null);
		setOpaque(true);

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < marcianos.size(); i++) {
			marcianos.get(i).paint(g2d);
		}
		v.paint(g2d);
		if (p != null) {
			p.paint(g2d);
		}

		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(puntuacionTotal), 10, 30);
		break;
	default:
		break;
	}
		

	}

	public void addKeyListener() {
		listener = new MiKeyListener(v, this);
		this.addKeyListener(listener);
		this.setFocusable(true);
	}

	public int getEscena() {
		return escena;
	}

	public void setEscena(int escena) {
		this.escena = escena;
	}
	

	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}

	

	public void setIniciado(boolean iniciado) {
		this.iniciado = iniciado;
	}
	
}
