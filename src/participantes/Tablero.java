package participantes;

/**
 * Clase que contiene la estructura de un tablero de Sudoku 9x9
 * @author Inazio
 *
 */
public class Tablero {

	/// PROPIEDADES 
	
	private Casilla[][] casillas;
	
	/// CONSTRUCTOR
	
	/**
	 * Genera un tablero de sudoku básico de 9x9
	 */
	public Tablero() {
		this.casillas = new Casilla[9][9];
	}
	
	/// METODOS
	
	/**
	 * Devuelve las casillas del tablero
	 * @return
	 */
	public Casilla[][] getCasillas() {
		return this.casillas;
	}
	
	/**
	 * Inicializa el tablero estableciendo por defecto los valores:
	 * Valor 	= 0
	 * PosX 	= i
	 * PosY 	= j
	 * Editable = true
	 * Sector 	= Según posición
	 */
	public void inicializarTablero() {
		
		for (int i = 0; i < this.casillas.length; i++) {
			for (int j = 0; j < this.casillas[i].length; j++) {
				Casilla casilla = new Casilla();
				casilla.setValor(0);
				casilla.setPosX(i);
				casilla.setPosY(j);
				casilla.setEditable(true);
				casilla.establecerSectorSegunPosicion();
				
				this.casillas[i][j] = casilla;
			}
		}
	}
	
	/**
	 * Establece una nueva casilla en la posición que tenga configurada la misma
	 * @param casilla
	 */
	public void editarCasilla(Casilla casilla) {
		this.casillas[casilla.getPosX()][casilla.getPosY()] = casilla;
	}
	
	/**
	 * Reestablece el valor de la casilla según su posición
	 * @param x Posición horizontal
	 * @param y Posición vertical
	 */
	public void reestablecerCasillaPorPosicion(int x, int y) {
		this.casillas[x][y].setValor(0);
	}
	
	/**
	 * Inserta los valores de la matriz en la misma casilla respecto a su posición
	 * Ha tenido que inicializarse la matriz de casillas previamente
	 * @param matriz Matriz de enteros entre 0 y 9
	 */
	public void insertarValores(int[][] matriz) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] != 0) {
					this.casillas[i][j].setEditable(false);
				}
				this.casillas[i][j].setValor(matriz[i][j]);
			}
		}
	}
}
