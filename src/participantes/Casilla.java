package participantes;

/**
 * Clase que contiene toda la información relevante de una casilla de Sudoku 9x9
 * @author Inazio
 *
 */
public class Casilla {

	/// PROPIEDADES
	private int valor;
	private int posX;
	private int posY;
	private Sector sector;
	private boolean editable;
	
	/// CONSTRUCTORES
	/**
	 * Inicializa una casilla vacía
	 */
	public Casilla() {}
	
	/**
	 * 
	 * @param valor
	 * @param posX
	 * @param posY
	 * @param sector
	 * @param editable
	 */
	public Casilla(int valor, int posX, int posY, Sector sector, boolean editable) {
		
		this.valor 		= valor;
		this.posX 		= posX;
		this.posY 		= posY;
		this.sector 	= sector;
		this.editable 	= editable;
	}
	
	/// METODOS
	
	/**
	 * Establece el sector dependiendo de la posición X e Y de la casilla
	 */
	public void establecerSectorSegunPosicion() {
		switch(posX) {
		
		case 0:
		case 1:
		case 2:
			switch(posY) {
			case 0:
			case 1:
			case 2:
				this.setSector(Sector.PRIMERO);
				break;
			case 3:
			case 4:
			case 5:
				this.setSector(Sector.SEGUNDO);
				break;
			case 6:
			case 7: 
			case 8:
				this.setSector(Sector.TERCERO);
				break;
			default:
				break;
			}
			break;
		case 3:
		case 4:
		case 5:
			switch(posY) {
			case 0:
			case 1:
			case 2:
				this.setSector(Sector.CUARTO);
				break;
			case 3:
			case 4:
			case 5:
				this.setSector(Sector.QUINTO);
				break;
			case 6:
			case 7: 
			case 8:
				this.setSector(Sector.SEXTO);
				break;
			default:
				break;
			}
			break;
		case 6:
		case 7:
		case 8:
			switch(posY) {
			case 0:
			case 1:
			case 2:
				this.setSector(Sector.SEPTIMO);
				break;
			case 3:
			case 4:
			case 5:
				this.setSector(Sector.OCTAVO);
				break;
			case 6:
			case 7: 
			case 8:
				this.setSector(Sector.NOVENO);
				break;
			default:
				break;
			}
			break;
		}
	}

	/**
	 * Devuelve el valor de la casilla
	 * @return Entero entre 0 y 9
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Establece el valor de la casilla
	 * @param valor Entero entre 0 y 9
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * Devuelve la posición horizontal
	 * @return Entero entre 0 y 8
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Establece la posición horizontal
	 * @param posX Entero entre 0 y 8
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * Devuelve la posición vertical
	 * @return Entero entre 0 y 8
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Establece la posición vertical
	 * @param posY Entero entre 0 y 8
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Devuelve el sector de la casilla
	 * @return Sector preestablecido en Enum Sector
	 */
	public Sector getSector() {
		return sector;
	}

	/**
	 * Establece el sector de la casilla
	 * @param sector Propiedad del enum Sector
	 */
	public void setSector(Sector sector) {
		this.sector = sector;
	}

	/**
	 * Devuelve si la casilla tiene un valor fijo o no
	 * @return True -> Valor fijo. False -> Valor modificable
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Establece la opción de editar la casilla
	 * @param editable True -> editable. False -> no editable
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}
