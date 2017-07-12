package app;

import java.io.IOException;
import java.util.Scanner;

import gui.GraficosConsola;
import participantes.Tablero;
import utiles.LectorFicheros;
import utiles.Literales;
import utiles.Solucionador;

/**
 * Clase principal
 * @author Inazio
 *
 */
public class App {

	public static void main(String[] args) {
		
		int[][] matriz 				= null;
		String controlMatrizTexto 	= ""; // Controla si la matriz es leída correctamente del fichero CSV
		
		
		Tablero tablero 			= new Tablero();
		GraficosConsola graficos 	= new GraficosConsola();
		Solucionador solucionador 	= new Solucionador();
		LectorFicheros lector 		= new LectorFicheros();
		Scanner scanner 			= new Scanner(System.in);
		
		graficos.imprimirTitulo();
		System.out.print("Escribe la ruta del CSV para cargar el fichero: ");
		String ruta = scanner.nextLine();
		
		scanner.close();
		
		try {
			matriz = lector.leerCSVSimple(ruta, lector.leerPropiedad("SEPARADOR_CSV"));
		} 
		catch (IOException | NumberFormatException e) {
			controlMatrizTexto = e.getMessage();
		}
		
		// Si no hay error cargo la instrucción de resolver el sudoku. Si lo hay, muestro un error
		if (controlMatrizTexto.equals("")) {
			tablero.inicializarTablero();
			tablero.insertarValores(matriz);
			graficos.imprimirTablero(tablero);
			boolean resultado = solucionador.solucionarSudoku(tablero);
			
			if (resultado)
				System.out.println(Literales.COMPLETADO);
			else
				System.out.println(Literales.INCOMPLETO);
		}
		else {
			System.out.println("Error al leer el fichero CSV.\n" + controlMatrizTexto);
		}
	}

}
