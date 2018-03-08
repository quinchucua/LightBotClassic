package Presentacion;

import Logica.Sistema;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:24 a.m.
 */
public class Modelo implements Runnable{

    public Sistema sistema;
    public Vista vista;
    boolean running;
    Thread hilodibujar;

    public Modelo() {
        //HiloDibujar h = new HiloDibujar(this);
        this.hilodibujar = new Thread(this);
        running = false;
    }

    public void inicio() {
        this.running = true;

        sistema = new Sistema();
        vista = new Vista(this);
        vista.getjPSecuencia().setLayout(new GridLayout(4, 5));
        this.hilodibujar.start();
    }

    public void agregarbotones(String tipo) {
        int numeroele = this.vista.getjPSecuencia().getComponentCount();
        if (numeroele < 18) {
            JButton b = new JButton(tipo);
            int col = numeroele / 3;
            int fil = numeroele - col * 3;
            b.setBounds(fil * 90, col * 40, 90, 40);
            this.vista.getjPSecuencia().add(b);
            b.addActionListener(this.vista.getControlador());
        }
        this.vista.getjPSecuencia().repaint();

    }

    public void quitarBotones(int boton) {
        this.vista.getjPSecuencia().remove(boton);
        ubicarbotones();
        this.vista.getjPSecuencia().repaint();
    }

    public void ubicarbotones() {
        int numeroele = this.vista.getjPSecuencia().getComponentCount();
        for (int i = 0; i < numeroele; i++) {
            Component b = this.vista.getjPSecuencia().getComponent(i);
            int col = i / 3;
            int fil = i - col * 3;
            b.setBounds(fil * 90, col * 40, 90, 40);
        }

    }

    public void ejecutarsecuencia() throws InterruptedException {
        this.sistema.getTablero().generartablero(this.sistema.getPersonaje());
        this.sistema.getPersonaje().olvidarmovimientos();
        for (int i = 0; i < this.vista.getjPSecuencia().getComponentCount(); i++) {
            Component p = this.vista.getjPSecuencia().getComponent(i);
            JButton b = (JButton) p;
            this.sistema.getPersonaje().agregarMovimiento(b.getText());
        }
        this.sistema.getPersonaje().moverse();
        this.sistema.getTablero().imprimirtablero(this.sistema.getPersonaje());
    }
    
    public void dibujar() {
        this.vista.getjPTablero().removeAll();

        int an = this.vista.getjPTablero().getWidth();
        int al = this.vista.getjPTablero().getHeight();
        int fi = this.sistema.getTablero().getFilas();
        int co = this.sistema.getTablero().getColumnas();

        for (int i = 0; i < co; i++) {
            for (int j = 0; j < fi; j++) {
                JButton b = new JButton();
                b.setEnabled(false);
                if (this.sistema.getTablero().getMatriz()[j][i] == 1) {
                    b.setBackground(Color.LIGHT_GRAY);
                }
                if (this.sistema.getTablero().getMatriz()[j][i] == 0) {
                    b.setBackground(Color.red);
                }
                if (this.sistema.getTablero().getMatriz()[j][i] == 2) {
                    b.setBackground(Color.BLACK);
                }
                if (this.sistema.getTablero().getMatriz()[j][i] == 3) {
                    b.setBackground(Color.YELLOW);
                }
                if (this.sistema.getPersonaje().getFila() == j && this.sistema.getPersonaje().getColumna() == i) {
                    //b.setBackground(Color.GREEN);
                    int orientacion = this.sistema.getPersonaje().getOrientacion();
                    if (orientacion == 0) {
                        //b.setText("Arriba");
                        ImageIcon ico = new ImageIcon("media/arriba3.png");
                        b.setIcon(ico);
                        b.setEnabled(true);
                    }
                    if (orientacion == 1) {
                        //b.setText("Derecha");
                        ImageIcon ico = new ImageIcon("media/der3.png");
                        b.setIcon(ico);
                        b.setEnabled(true);
                    }
                    if (orientacion == 2) {
                        //b.setText("Abajo");
                        ImageIcon ico = new ImageIcon("media/abajo3.png");
                        b.setIcon(ico);
                        b.setEnabled(true);
                    }
                    if (orientacion == 3) {
                        //b.setText("Izquierda");
                        ImageIcon ico = new ImageIcon("media/izq3.png");
                        b.setIcon(ico);
                        b.setEnabled(true);
                    }
                }

                b.setBounds(i * an / co, j * al / fi, an / co, al / fi);
                this.vista.getjPTablero().add(b);
            }
        }
        if(!this.sistema.getPersonaje().isMovimientoscompletados())
        {
            this.vista.getjTResultado().setText("Los movimientos no se completaron.");
        }
        if(this.sistema.getTablero().lucesencendidas())
        {
            this.vista.getjTResultado().setText("Nivel Superado");
        }
        /*
        if(ultimomovimiento!=-1 )
        {
            Component c = this.modelo.vista.getjPSecuencia().getComponent(this.modelo.sistema.getPersonaje().getUltimomovimiento());
            JButton b = (JButton)c;

            this.modelo.vista.getjTResultado().setText("Ultimo movimiento Realizado : "+(ultimomovimiento+1)+"\n Tipo Movimiento : ");
            
        }
*/
        this.vista.getjPTablero().repaint();
    }

    @Override
    public void run() {
        while (this.running) {
            try {
                hilodibujar.sleep(20);
            } catch (InterruptedException ex) {
            }
            dibujar();
        }
    }
}
