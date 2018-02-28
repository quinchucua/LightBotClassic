package Logica;



/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:24 a.m.
 */
public abstract class Nivel {

	private int x;
	private int y;



	public void finalize() throws Throwable {

	}

	public Nivel(){

	}

	/**
	 * 
	 * @param tablero    tablero
	 * @param personaje
	 */
	public abstract void construir(Tablero tablero, Personaje personaje);

}