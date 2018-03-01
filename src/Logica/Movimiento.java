package Logica;



/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:23 a.m.
 */
public interface Movimiento {

	/**
	 * 
	 * @param personaje
	 * @param tablero
	 */
	abstract public boolean ejecutar(Personaje personaje, Tablero tablero);

}