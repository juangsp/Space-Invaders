import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MiKeyListener implements KeyListener {
		private Nave v;
		private Game g;
		private Proyectil p;
		public final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Inicio.class);
	

		public MiKeyListener(Nave v, Game g) {
			this.v = v;
			this.g = g;
			
			
		
		}

		@Override
		public void keyPressed(KeyEvent e) {
			e.consume();
			switch (g.getEscena()) {
			case 1:
				if ((e.getKeyCode() == KeyEvent.VK_ENTER)) {
					log.trace("Se inicia la pantalla de seleccion de niveles");
					g.setEscena(2);
				}
				break;
			case 2:
				if ((e.getKeyCode() == KeyEvent.VK_1)) {
					log.trace("Seleccionado nivel 1");
					g.setLevel(1);
					g.setEscena(3);
					g.getJ().setSize(600, 600);
					g.setSize(600, 600);
					g.crearMarcianos();
					
					g.setIniciado(true);
				}
				if ((e.getKeyCode() == KeyEvent.VK_2)) {
					log.trace("Seleccionado nivel 2");
					g.setLevel(2);
					g.setEscena(3);
					g.getJ().setSize(900, 800);
					g.setSize(900, 800);
					g.crearMarcianos();		
					
					g.setIniciado(true);
				}

				if ((e.getKeyCode() == KeyEvent.VK_3)) {
					log.trace("Seleccionado nivel 3");
					g.setLevel(3);
					g.setEscena(3);
					g.getJ().setSize(1200, 1000);
					g.setSize(1200, 1000);
					g.crearMarcianos();	
					
					g.setIniciado(true);
				}
				break;
			default:
				break;
			}
			if ((e.getKeyCode() == KeyEvent.VK_SPACE)) {
				 p = new Proyectil(g);
				 g.setP(p);
				
			}
			v.keyPressed(e);
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			v.keyReleased(e);
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

	}