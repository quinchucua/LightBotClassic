/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;

/**
 *
 * @author ASUS
 */
public class HiloDibujar implements Runnable {
    Thread hilodibujar;
    Modelo modelo;
    
    public HiloDibujar(Modelo modelo)
    {
        this.modelo = modelo;
        this.hilodibujar = new Thread(this);
    }
    public void dibujar() {
        this.modelo.vista.getjPTablero().removeAll();

        int an = this.modelo.vista.getjPTablero().getWidth();
        int al = this.modelo.vista.getjPTablero().getHeight();
        int fi = this.modelo.sistema.getTablero().getFilas();
        int co = this.modelo.sistema.getTablero().getColumnas();

        for (int i = 0; i < co; i++) {
            for (int j = 0; j < fi; j++) {
                JButton b = new JButton();
                if (this.modelo.sistema.getTablero().getMatriz()[j][i] == 1) {
                    b.setBackground(Color.BLUE);
                }
                if (this.modelo.sistema.getTablero().getMatriz()[j][i] == 0) {
                    b.setBackground(Color.RED);
                }
                if (this.modelo.sistema.getTablero().getMatriz()[j][i] == 2) {
                    b.setBackground(Color.YELLOW);
                }
                if (this.modelo.sistema.getPersonaje().getFila() == j && this.modelo.sistema.getPersonaje().getColumna() == i) {
                    b.setBackground(Color.GREEN);
                    int orientacion = this.modelo.sistema.getPersonaje().getOrientacion();
                    if (orientacion == 0) {
                        b.setText("Arriba");
                    }
                    if (orientacion == 1) {
                        b.setText("Derecha");
                    }
                    if (orientacion == 2) {
                        b.setText("Abajo");
                    }
                    if (orientacion == 3) {
                        b.setText("Izquierda");
                    }
                }

                b.setBounds(i * an / co, j * al / fi, an / co, al / fi);
                this.modelo.vista.getjPTablero().add(b);
            }
        }
        int ultimomovimiento = this.modelo.sistema.getPersonaje().getUltimomovimiento();
        if(ultimomovimiento!=-1 )
        {
            Component c = this.modelo.vista.getjPSecuencia().getComponent(this.modelo.sistema.getPersonaje().getUltimomovimiento());
            JButton b = (JButton)c;

            this.modelo.vista.getjTResultado().setText("Ultimo movimiento Realizado : "+(ultimomovimiento+1)+"\n Tipo Movimiento : "+b.getText());
            
        }
        this.modelo.vista.getjPTablero().repaint();
    }

    @Override
    public void run() {
        while (this.modelo.running) {
            try {
                hilodibujar.sleep(20);
            } catch (InterruptedException ex) {
            }
            dibujar();
        }
    }
    
}