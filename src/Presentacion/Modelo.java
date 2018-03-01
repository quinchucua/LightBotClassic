package Presentacion;

import Logica.Sistema;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:24 a.m.
 */
public class Modelo {

    public Sistema sistema;
    public Vista vista;
    boolean running;
    Thread hilodibujar;

    public Modelo() {
        HiloDibujar h = new HiloDibujar(this);
        this.hilodibujar = new Thread(h);
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
}
