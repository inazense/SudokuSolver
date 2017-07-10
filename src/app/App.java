package app;

import java.io.IOException;

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
		
		// Sudoku completo bien
		/*
		int[][] matriz2 =
		{
			{ 1, 5, 4, 6, 9, 3, 2, 8, 7 },
			{ 6, 3, 2, 5, 7, 8, 9, 4, 1 },
			{ 8, 9, 7, 1, 2, 4, 6, 5, 3 },
			{ 5, 1, 9, 8, 4, 7, 3, 2, 6 },
			{ 2, 4, 3, 9, 6, 5, 7, 1, 8 },
			{ 7, 6, 8, 3, 1, 2, 4, 9, 5 },
			{ 4, 8, 6, 7, 5, 9, 1, 3, 2 },
			{ 9, 7, 5, 2, 3, 1, 8, 6, 4 },
			{ 3, 2, 1, 4, 8, 6, 5, 7, 9 }
		};
		*/
		
		int[][] matriz2 =
		{
			{ 0, 5, 4, 6, 9, 3, 2, 8, 7 },
			{ 6, 3, 2, 5, 7, 8, 9, 4, 1 },
			{ 8, 0, 7, 1, 2, 4, 6, 0, 3 },
			{ 0, 1, 9, 8, 4, 7, 3, 2, 6 },
			{ 2, 4, 0, 9, 6, 0, 0, 1, 8 },
			{ 7, 6, 8, 3, 1, 2, 4, 9, 5 },
			{ 4, 8, 6, 7, 5, 9, 1, 3, 2 },
			{ 0, 7, 5, 0, 0, 1, 8, 6, 4 },
			{ 3, 2, 1, 4, 8, 6, 5, 7, 9 }
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
