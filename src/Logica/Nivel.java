package Logica;

import Serializable.DatosNivel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:24 a.m.
 */
public class Nivel {
    DatosNivel nivel = null;
    public Nivel(String ubicacion) {
        try {
            FileInputStream fileIn = new FileInputStream(ubicacion);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            nivel = (DatosNivel) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Datos nivel class not found");
            c.printStackTrace();
            return;
        }
        System.out.println(nivel.getColumnas());
    }

    public void construir(Tablero tablero, Personaje personaje) {
        ubicarpersonaje(personaje);

        tablero.setFilas(nivel.getFilas());
        tablero.setColumnas(nivel.getColumnas());
        tablero.setMatriz(nivel.getMatriz());
        tablero.apagarluces();
    }

    public void ubicarpersonaje(Personaje personaje)
    {
        personaje.setColumna(0);
        personaje.setFila(0);
        personaje.setOrientacion(2);
    }

}

