package Logica;

/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:24 a.m.
 */
public class Nivel1 extends Nivel {

    public Nivel1() {

    }

    @Override
    public void construir(Tablero tablero, Personaje personaje) {
        int filas=3;
        int columnas=3;
        
        int[][] matriz = new int[filas][columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j]=0;
            }
        }
        
        crearcamino(matriz);
        ponerluces(matriz);
        ubicarpersonaje(personaje);
        
        tablero.setFilas(filas);
        tablero.setColumnas(columnas);
        tablero.setMatriz(matriz);
    }
    
    public void crearcamino(int[][] matriz)
    {
        matriz[0][0]=1;
        matriz[1][0]=1;
        matriz[2][0]=1;
        matriz[2][1]=1;
        matriz[2][2]=1;
        matriz[1][2]=1;
        matriz[0][2]=1;
    }
    
    public void ponerluces(int[][] matriz)
    {
        matriz[0][2]=2;
    }
    
    public void ubicarpersonaje(Personaje personaje)
    {
        personaje.setColumna(0);
        personaje.setFila(0);
        personaje.setOrientacion(0);
    }

}
