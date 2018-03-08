package Logica;

import javax.swing.*;
import java.awt.*;

public class FabricaBotones {
    public JButton getBoton(String tipo) {
        JButton btn = null;
        if (tipo == "Avanzar") {
            ImageIcon img = new ImageIcon("media/avanzar.png");
            Icon icono = new ImageIcon(img.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));
            return new JButton("Avanzar", icono);
        }
        if (tipo == "Giro Izq") {
            ImageIcon img = new ImageIcon("media/girar_izq.png");
            Icon icono = new ImageIcon(img.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));
            return new JButton("Giro Izq", icono);
        }
        if (tipo == "Giro Der") {
            ImageIcon img = new ImageIcon("media/girar_der.png");
            Icon icono = new ImageIcon(img.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));
            return new JButton("Giro Der", icono);
        }
        if (tipo == "Encender") {
            ImageIcon img = new ImageIcon("media/encender.png");
            Icon icono = new ImageIcon(img.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));
            return new JButton("Encender", icono);
        }

        return btn;
    }
}
