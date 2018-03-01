package Logica;



/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:23 a.m.
 */
public class GirarDerecha implements Movimiento {

	public GirarDerecha(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param personaje
	 * @param tablero
	 */
	public boolean ejecutar(Personaje personaje, Tablero tablero){
            if(personaje.getOrientacion()<3)
            {
                personaje.setOrientacion(personaje.getOrientacion()+1);
            }else
            {
                personaje.setOrientacion(0);
            }
            return true;
	}

}