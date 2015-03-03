import org.apache.log4j.PropertyConfigurator;

  
public class Inicio {
	 public final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Inicio.class);

	public static void main(String[] args) {
		 PropertyConfigurator.configure("log4j.properties");
		Juego j = new Juego();	
		
	}

}
                      