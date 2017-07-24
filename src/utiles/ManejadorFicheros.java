package utiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * Clase para trabajar con distintos ficheros de texto
 * @author Inazio
 *
 */
public class ManejadorFicheros {

	/// PROPIEDADES
	private BufferedReader bufferLectura;
	private BufferedWriter bufferEscritura;
	private File archivo;
	private Properties propiedades;
	private String rutaPropiedades;
	
	/// CONSTRUCTOR
	public ManejadorFicheros() {
		this.bufferLectura		= null;
		this.bufferEscritura 	= null;
		this.archivo 			= null;
		this.propiedades 	 	= new Properties();
		this.rutaPropiedades 	= Literales.RUTA_PROPERTIES;
		
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
		this.bufferLectura 	= new BufferedReader(new FileReader(ruta));
		String linea 	= bufferLectura.readLine();
		
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
			
			linea = this.bufferLectura.readLine();
		}
		
		// Cierro el buffer
		if (this.bufferLectura != null) {
			bufferLectura.close();
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
	
	/**
	 * Genera un fichero CSV en la ruta pasada como parámetro
	 * @param ruta Ruta del fichero CSV
	 * @param matrizContenido Contenido a volcar
	 * @return True si el fichero se genera correctamente. False en caso contrario
	 */
	public void guardarCSV(String ruta, int[][] matrizContenido) {
		
		String textoAGuardar = "";
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				textoAGuardar += String.valueOf(matrizContenido[i][j]);
				if (j != 8) {
					textoAGuardar += ",";
				}
			}
			textoAGuardar += "\n";
		}
		
		this.archivo = new File(ruta);
		
		try {
			this.bufferEscritura = new BufferedWriter(new FileWriter(this.archivo));
			this.bufferEscritura.write(textoAGuardar);
			JOptionPane.showMessageDialog(null, Literales.GUARDADO_CSV_OK);
		} 
		catch (IOException e) {
			String mensajeError = Literales.GUARDADO_CSV_FAIL + "\n" + e.getMessage();
			JOptionPane.showMessageDialog(null, mensajeError, Literales.ERROR, JOptionPane.ERROR_MESSAGE);
		}
		finally {
			
			if (this.bufferEscritura != null) {
				try {
					this.bufferEscritura.close();
				} 
				catch (IOException e) {}
			}
			
			if (this.archivo != null) {
				this.archivo = null;
			}
		}
		
	}
}
