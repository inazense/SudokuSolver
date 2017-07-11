package gui;

import participantes.Tablero;
import utiles.Literales;

/**
 * Clase que se encarga de imprimir por pantalla el sudoku
 * @author Inazio
 *
 */
public class GraficosConsola {

	/**
	 * Imprime el tablero completo con la información sobre el programa
	 * @param tablero
	 */
	public void imprimirTablero(Tablero tablero) {
		this.limpiarPantalla();
		this.imprimirTitulo();
		
		String texto = "";
		texto += "-------------------\n";
		
		for (int i = 0; i < tablero.getCasillas().length; i++) {
			for (int j = 0; j < tablero.getCasillas()[i].length; j++) {
				
				int valorReal = tablero.getCasillas()[i][j].getValor();
				String valorTextual = " ";
				
				if (valorReal != 0) {
					valorTextual = String.valueOf(valorReal);
				}
				
				texto += "|" + valorTextual;
			}
			texto += "|\n";
			texto += "-------------------\n";
		}
		
		System.out.println(texto);
	}
	
	/**
	 * Imprime el título para la interfaz de consola
	 */
	public void imprimirTitulo() {
		
		String texto = "";
		texto += "******************************************\n";
		texto += "              " + Literales.NOMBRE + " - " + Literales.VERSION + "\n";
		texto += "******************************************\n";
		texto += "      " + Literales.AUTOR + " - " + Literales.WEB + "\n";
		texto += "******************************************\n";
		
		System.out.println(texto);
	}
	
	/**
	 * Limpia el texto de la terminal
	 */
	private void limpiarPantalla() {
		int i = 0;
		while (i < 20) {
			System.out.println("\n");
			i++;
		}
	}
}
