

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

public class Configuration {

	//Properties properties ;
	private  Properties properties;
    /** Configuration file name */
    public final static String CONFIG_FILE_NAME = "Configuration.properties";
 
  
	public static final String WIDTH= "WIDTH";
	public static final String HEIGHT="HEIGHT";
	public static final String FILA1="FILA1";
	public static final String COLUMNA1 ="COLUMNA1";
	public static final String FILA2="FILA2";
	public static final String COLUMNA2="COLUMNA2";
	public static final String FILA3="FILA3";
	public static final String COLUMNA3 ="COLUMNA3";
	public static final String WIDTH1="WIDTH1";
	public static final String HEIGTH1="HEIGTH1";
	public static final String WIDTH2="WIDTH2";
	public static final String HEIGTH2="HEIGTH2";
	public static final String WIDTH3="WIDTH3";
	public static final String HEIGTH3="HEIGTH3";
	public static final String IMGNAVENAME = "IMGNAVENAME";
	public static final String IMGSHOOTNAME = "IMGSHOOTNAME"; 
	public static final String IMGMARNAME = "IMGMARNAME";
	
    public Configuration() {
     
    	properties= new Properties();
    	FileInputStream in;
		try {
			in = new FileInputStream(CONFIG_FILE_NAME);
			properties.load(in);
			System.out.println(properties.size());
			//System.out.println(properties.getProperty(OPCIONES));
	    	//in.close();
	    	//System.out.println(properties.getProperty(OPCIONES));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Enumeration em = properties.elements();
		while(em.hasMoreElements())
			System.out.println("'"+em.nextElement()+"'");
//        this.properties = new Properties();
//        try {
//            properties.load(Configuration.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }//Configuration
 
    /**
     * Implementando Singleton
     *
     * @return
     */
    public static Configuration getInstance() {
        return ConfigurationHolder.INSTANCE;
    }
 
    private static class ConfigurationHolder {
 
        private static final Configuration INSTANCE = new Configuration();
    }
 
    /**
     * Retorna la propiedad de configuración solicitada
     *
     * @param key
     * @return
     */
    public String getPropertyMy(String key) {
    	System.out.println(properties);
    	String a = properties.getProperty(key);
    	System.out.println(properties.size());
        return a;
    }//getProperty
}
