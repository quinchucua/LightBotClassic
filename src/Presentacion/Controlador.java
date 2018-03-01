package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:24 a.m.
 */
public class Controlador implements ActionListener {

    private Vista vista;

    public Controlador(Vista vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.getjBAvanzar()) {
            this.vista.getModelo().agregarbotones("Avanzar");
        }
        if (e.getSource() == this.vista.getjBGiroIzq()) {
            this.vista.getModelo().agregarbotones("Giro Izq");
        }
        if (e.getSource() == this.vista.getjBGiroDer()) {
            this.vista.getModelo().agregarbotones("Giro Der");
        }
        if (e.getSource() == this.vista.getjBEncender()) {
            this.vista.getModelo().agregarbotones("Encender");
        }
        if (e.getSource() == this.vista.getjBPlay()) {
            try {
                this.vista.getModelo().ejecutarsecuencia();
            } catch (InterruptedException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (int i = 0; i < this.vista.getjPSecuencia().getComponentCount(); i++) {
            if(e.getSource()==this.vista.getjPSecuencia().getComponent(i))
            {
                this.vista.getModelo().quitarBotones(i);
            }
        }
        
        
    }

}
