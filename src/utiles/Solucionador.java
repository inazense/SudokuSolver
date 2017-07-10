package utiles;

import java.util.ArrayList;

import gui.GraficosConsola;
import participantes.Casilla;
import participantes.Tablero;

public class Solucionador {
	
	/// METODOS
	
	/**
	 * Método que controla las operaciones necesarias para solucionar el sudoku
	 * @param tablero Tablero que contiene las casillas del sudoku
	 * @return boolean. True = Sudoku solucionado. False = Sudoku sin solucionar
	 */
	public boolean solucionarSudoku(Tablero tablero) {
		
		GraficosConsola graficos = new GraficosConsola();
		ArrayList<Casilla> editables = this.extraerCasillasEditables(tablero.getCasillas());
		int i = 0;
		
		while (i < editables.size()) {
			
			graficos.imprimirTablero(tablero);
			
			// Control de salida. Si el primer resultado es igual a 0 y su valor superior al máximo permitido por el sudoku, 
			// error al solucionar el sudoku
			Casilla actual = editables.get(i);
			if (actual.getValor() > 9) {
				tablero.reestablecerCasillaPorPosicion(actual.getPosX(), actual.getPosY());
				i--;
				
				if (i < 0) {
					return false;
				}
				else {
					actual = editables.get(i);
					actual.setValor(actual.getValor() + 1);
					tablero.editarCasilla(actual);
				}
			}
			else {
				if (actual.getValor() == 0) {
					actual.setValor(1);
				}
				
				ArrayList<ArrayList<Casilla>> listasParaValidar = this.extraerCasillasComparables(tablero, actual);
				
				// Validar si listas cumplen reglas de Sudoku (salvo valor sin rellenar)
				if (validacionFCS(listasParaValidar)) {
					tablero.editarCasilla(actual);
					i++;
				}
				else
				{
					System.out.println(i + ": MAL");
					actual.setValor(actual.getValor() + 1);
					if (actual.getValor() > 9) {
						tablero.reestablecerCasillaPorPosicion(actual.getPosX(), actual.getPosY());
						if (i != 0) {
							i--;
							actual = editables.get(i);
							actual.setValor(actual.getValor() + 1);
							tablero.editarCasilla(actual);
						}
						else {
							return false;
						}
					}
				}
			}
			
		}
		
		return true;
	}
	
	/**
	 * Devuelve un array con todas las casillas en las que la propiedad editable es verdadera
	 * @param casillas Matriz de casillas
	 * @return Array con las casillas editables
	 */
	private ArrayList<Casilla> extraerCasillasEditables(Casilla[][] casillas) {
		ArrayList<Casilla> editables = new ArrayList<Casilla>();
		
		for (int i = 0; i < casillas.length; i++ ) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (casillas[i][j].isEditable()) {
					editables.add(casillas[i][j]);
				}
			}
		}
		
		return editables;
	}
	
	/**
	 * Extrae las casillas que contengan la misma fila, columna o sector que la casilla actual
	 * @param tablero Tablero de 9x9
	 * @param actual Casilla actual
	 * @return ArrayList que contiene tres arrayList de casillas. Fila, columna y sector
	 */
	private ArrayList<ArrayList<Casilla>> extraerCasillasComparables(Tablero tablero, Casilla actual) {
		
		ArrayList<Casilla> fila 	= new ArrayList<Casilla>();
		ArrayList<Casilla> columna 	= new ArrayList<Casilla>();
		ArrayList<Casilla> sector 	= new ArrayList<Casilla>();
		
		for (int i = 0; i < tablero.getCasillas().length; i++) {
			for (int j = 0; j < tablero.getCasillas()[i].length; j++) {
				if (tablero.getCasillas()[i][j].getPosX() == actual.getPosX()) {
					fila.add(tablero.getCasillas()[i][j]);
				}
				
				if (tablero.getCasillas()[i][j].getPosY() == actual.getPosY()) {
					columna.add(tablero.getCasillas()[i][j]);
				}
				
				if (tablero.getCasillas()[i][j].getSector() == actual.getSector()) {
					sector.add(tablero.getCasillas()[i][j]);
				}
			}
		}
		
		ArrayList<ArrayList<Casilla>> resultado = new ArrayList<ArrayList<Casilla>>();
		resultado.add(fila);
		resultado.add(columna);
		resultado.add(sector);
		
		return resultado;
	}
	
	/**
	 * Valida la fila, columna y sector. Si no se repite ningun numero (sin contar el 0)
	 * es una lista válida
	 * @param listas ArrayList de arraylist de casillas
	 * @return True si validacion correcta. False en caso contrario
	 */
	private boolean validacionFCS(ArrayList<ArrayList<Casilla>> listas) {
		
		for (ArrayList<Casilla> lista : listas) {
			
			ArrayList<Integer> valores = null;
			valores = new ArrayList<Integer>();
			
			for (Casilla casilla : lista) {
				if (casilla.getValor() != 0) {
					if (valores.contains(casilla.getValor())) {
						return false;
					}
					else {
						valores.add(casilla.getValor());
					}
				}
			}
		}
		
		return true;
	}
}
