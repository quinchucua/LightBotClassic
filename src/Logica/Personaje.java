package Logica;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:25 a.m.
 */
public class Personaje implements Runnable {

    private ArrayList<Movimiento> movimientos;
    private int orientacion;
    private int columna;
    private int fila;
    Tablero tablero;
    Thread hilopersonaje;
    boolean movimientoscompletados=true;

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

    public void moverse() throws InterruptedException {
        boolean resultado;
        this.hilopersonaje = new Thread(this);
        this.hilopersonaje.start();
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

    public boolean isMovimientoscompletados() {
        return movimientoscompletados;
    }

    public void setMovimientoscompletados(boolean movimientoscompletados) {
        this.movimientoscompletados = movimientoscompletados;
    }


    @Override
    public void run() {
        boolean resultado = true;
        this.movimientoscompletados=true;
        for (int i = 0; i < this.movimientos.size(); i++) {
            try {
                this.hilopersonaje.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Personaje.class.getName()).log(Level.SEVERE, null, ex);
            }
            resultado = movimientos.get(i).ejecutar(this, tablero);
            if (resultado==false)
            {
                this.movimientoscompletados=false;
                break;
            }
        }
        this.hilopersonaje.stop();
    }

}
