package Logica;



/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:23 a.m.
 */
public class EncenderLuz implements Movimiento {

	public EncenderLuz(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param personaje
	 * @param tablero
     * @return 
	 */
        @Override
	public boolean ejecutar(Personaje personaje, Tablero tablero){
            System.out.println("Implementar movimiento Encender Luz");
            return true;
	}

}