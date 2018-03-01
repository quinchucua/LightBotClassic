package Presentacion;

import Logica.Sistema;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:24 a.m.
 */
public class Modelo implements Runnable {

    public Sistema sistema;
    public Vista vista;
    boolean running;
    Thread hilodibujo;

    public Modelo() {
        running = false;
        this.hilodibujo = new Thread(this);
    }

    public void inicio() {
        this.running = true;

        sistema = new Sistema();
        vista = new Vista(this);
        vista.getjPSecuencia().setLayout(new GridLayout(4, 5));
        this.hilodibujo.start();
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
                if (this.sistema.getTablero().getMatriz()[j][i] == 1) {
                    b.setBackground(Color.BLUE);
                }
                if (this.sistema.getTablero().getMatriz()[j][i] == 0) {
                    b.setBackground(Color.RED);
                }
                if (this.sistema.getTablero().getMatriz()[j][i] == 2) {
                    b.setBackground(Color.YELLOW);
                }
                if (this.sistema.getPersonaje().getFila() == j && this.sistema.getPersonaje().getColumna() == i) {
                    b.setBackground(Color.GREEN);
                }

                b.setBounds(i * an / co, j * al / fi, an / co, al / fi);
                this.vista.getjPTablero().add(b);
            }
        }
        this.vista.getjPTablero().repaint();
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
            dibujar();
        }
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
    
    public void ubicarbotones()
    {
        int numeroele = this.vista.getjPSecuencia().getComponentCount();
        for (int i = 0; i < numeroele; i++) {
            Component b = this.vista.getjPSecuencia().getComponent(i);
            int col = i / 3;
            int fil = i - col * 3;
            b.setBounds(fil * 90, col * 40, 90, 40);
        }
        
    }
    
    public void ejecutarsecuencia()
    {
        boolean resultado = true;
        this.vista.getjTResultados().setText("");
        this.sistema.getTablero().generartablero(this.sistema.getPersonaje());
        this.sistema.getPersonaje().olvidarmovimientos();
        for (int i = 0; i < this.vista.getjPSecuencia().getComponentCount(); i++) {
            Component p = this.vista.getjPSecuencia().getComponent(i);
            JButton b = (JButton) p;
            this.sistema.getPersonaje().agregarMovimiento(b.getText());
            resultado = this.sistema.getPersonaje().moverse();
            
            if(resultado==false)
            {
                this.vista.getjTResultados().setText("No se pudo realizar el paso #"+(i+1)+" "+b.getText());
                break;
            }
        }
        
        if(resultado==true)
        {
            this.vista.getjTResultados().setText("Todos los pasos completados");
        }
        this.sistema.getTablero().imprimirtablero(this.sistema.getPersonaje());
    }
}