package app;

import gui.GraficosConsola;
import participantes.Tablero;
import utiles.Literales;
import utiles.Solucionador;

/**
 * Clase principal
 * @author Inazio
 *
 */
public class App {

	public static void main(String[] args) {
		
		// Sudoku de ejemplo
		int[][] matriz =
		{
			{ 8, 3, 2, 7, 0, 6, 0, 5, 4 },
			{ 0, 6, 5, 0, 3, 8, 7, 9, 2 },
			{ 7, 0, 4, 5, 2, 0, 0, 0, 0 },
			{ 0, 1, 8, 9, 7, 4, 3, 0, 5 },
			{ 9, 4, 0, 2, 8, 5, 6, 0, 0 },
			{ 5, 2, 7, 0, 1, 0, 0, 4, 8 },
			{ 0, 0, 0, 0, 4, 0, 5, 0, 0 },
			{ 0, 0, 0, 0, 0, 9, 0, 0, 3 },
			{ 3, 0, 6, 1, 5, 0, 4, 8, 9 }
		};
		
		Tablero tablero 			= new Tablero();
		GraficosConsola graficos 	= new GraficosConsola();
		Solucionador solucionador 	= new Solucionador();
		
		tablero.inicializarTablero();
		tablero.insertarValores(matriz);
		graficos.imprimirTablero(tablero);
		boolean resultado = solucionador.solucionarSudoku(tablero);
		
		if (resultado)
			System.out.println(Literales.COMPLETADO);
		else
			System.out.println(Literales.INCOMPLETO);
	}

}
