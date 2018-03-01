package Logica;

import java.util.ArrayList;

/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:25 a.m.
 */
public class Personaje {

    private ArrayList<Movimiento> movimientos;
    private int orientacion;
    private int columna;
    private int fila;
    private Tablero tablero;

    public Personaje(Tablero tablero) {
        this.tablero = tablero;
    }

    public void olvidarmovimientos() {
        movimientos = new ArrayList();
    }

    public void agregarMovimiento(String movimiento) {
        if ("Avanzar".equals(movimiento)) {
            Movimiento m = new Avanzar();
            this.movimientos.add(m);
        }
        if ("Giro Der".equals(movimiento)) {
            Movimiento m = new GirarDerecha();
            this.movimientos.add(m);
        }
        if ("Giro Izq".equals(movimiento)) {
            Movimiento m = new GirarIzquierda();
            this.movimientos.add(m);
        }
        if ("Encender".equals(movimiento)) {
            Movimiento m = new EncenderLuz();
            this.movimientos.add(m);
        }
    }

    public boolean moverse() {
        return movimientos.get(movimientos.size()-1).ejecutar(this, tablero);
    }

    //Metodos get y set
    public ArrayList getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList movimientos) {
        this.movimientos = movimientos;
    }

    public int getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(int orientacion) {
        this.orientacion = orientacion;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

}
