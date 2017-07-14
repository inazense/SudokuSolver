package utiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Clase para trabajar con distintos ficheros de texto
 * @author Inazio
 *
 */
public class ManejadorFicheros {

	/// PROPIEDADES
	private BufferedReader buffer;
	private Properties propiedades;
	private String rutaPropiedades;
	
	/// CONSTRUCTOR
	public ManejadorFicheros() {
		this.buffer			 = null;
		this.propiedades 	 = new Properties();
		this.rutaPropiedades = Literales.RUTA_PROPERTIES;
	}
	
	/// METODOS
	
	/**
	 * Lee un CSV que contiene los valores del sudoku y lo almacena en matriz de enteros
	 * @param ruta Ruta del fichero CSV
	 * @return Matriz de enteros de 9x9
	 * @throws IOException Si ha ocurrido alguna excepción relacionada con el fichero
	 */
	public int[][] leerCSVSimple(String ruta, String separador) throws IOException, NumberFormatException {
		
		int i 			= 0;
		int[][] matriz 	= new int[9][9];
		this.buffer 	= new BufferedReader(new FileReader(ruta));
		String linea 	= buffer.readLine();
		
		while (linea != null) {
			// hago el salto de linea en la matriz
			
			// Separa la línea leída con el separador definido previamente
			String[] campos = linea.split(separador);
			
			// Vuelco en la matriz los resultados
			int j = 0;
			
			for (String num : campos) {
				matriz[i][j] = Integer.parseInt(num);
				j++;
			}
			
			i++;
			
			linea = this.buffer.readLine();
		}
		
		// Cierro el buffer
		if (this.buffer != null) {
			buffer.close();
		}
		
		return matriz;
	}
	
	/**
	 * Devuelve una propiedad del fichero properties
	 * @param miClave Clave de la propiedad
	 * @return String con el valor de la propiedad
	 * @throws IOException Si ha ocurrido alguna excepción relacionada con el fichero
	 */
	public String leerPropiedad(String miClave) throws IOException {
		
		String resultado = "";
		
		this.propiedades.load(new FileReader(this.rutaPropiedades));
		Enumeration<Object> claves = this.propiedades.keys();
		
		while (claves.hasMoreElements()) {
			Object clave = claves.nextElement();
			if (clave.toString().equals(miClave)) {
				resultado = this.propiedades.get(clave).toString();
			}
		}
		
		return resultado;
	}
}
