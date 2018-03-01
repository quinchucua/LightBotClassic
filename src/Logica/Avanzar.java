package Logica;



/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:23 a.m.
 */
public class Avanzar implements Movimiento {

	public Avanzar(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param personaje
	 * @param tablero
	 */
	public boolean ejecutar(Personaje personaje, Tablero tablero){
            
            int filap = personaje.getFila();
            int columnap = personaje.getColumna();
            
            int numfilast = tablero.getFilas();
            int numcolumnast = tablero.getColumnas();
            
            if(personaje.getOrientacion()==0)//mirando hacia arriba
            {
                if(filap-1<0)
                {
                    return false;
                }else
                {
                    if(tablero.getMatriz()[personaje.getFila()-1][personaje.getColumna()]==1 || tablero.getMatriz()[personaje.getFila()-1][personaje.getColumna()]==2)
                    {
                        personaje.setFila(personaje.getFila()-1);
                        return true;
                    }else
                    {
                        return false;
                    }
                }
            }
            if(personaje.getOrientacion()==1)//mirando hacia derecha
            {
                if(columnap+1>numcolumnast)
                {
                    return false;
                }else
                {
                    if(tablero.getMatriz()[personaje.getFila()][personaje.getColumna()+1]==1 || tablero.getMatriz()[personaje.getFila()][personaje.getColumna()+1]==2)
                    {
                        personaje.setColumna(personaje.getColumna()+1);
                        return true;
                    }else
                    {
                        return false;
                    }
                }
            }
            if(personaje.getOrientacion()==2)//mirando hacia abajo
            {
                if(filap+1>numfilast)
                {
                    return false;
                }else
                {
                    if(tablero.getMatriz()[personaje.getFila()+1][personaje.getColumna()]==1 || tablero.getMatriz()[personaje.getFila()+1][personaje.getColumna()]==2)
                    {
                        personaje.setFila(personaje.getFila()+1);
                        return true;
                    }else
                    {
                        return false;
                    }
                }                
            }
            if(personaje.getOrientacion()==3)//mirando hacia izquierda
            {
                if(columnap-1<0)
                {
                    return false;
                }else
                {
                    if(tablero.getMatriz()[personaje.getFila()][personaje.getColumna()-1]==1 || tablero.getMatriz()[personaje.getFila()][personaje.getColumna()-1]==2)
                    {
                        personaje.setColumna(personaje.getColumna()-1);
                        return true;
                    }else
                    {
                        return false;
                    }
                }
                
            }
            return true;
	}

}