package Logica;

import java.util.ArrayList;

/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:25 a.m.
 */
public class Personaje {

    private ArrayList movimientos;
    private int orientacion;
    private int columna;
    private int fila;

    public Personaje() {

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
