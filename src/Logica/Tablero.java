package Logica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:24 a.m.
 */
public class Tablero {

    private int columnas;
    private int filas;
    private int matriz[][];
    private int nivel;
    private ArrayList<Nivel> niveles;

    public Tablero() {
        nivel = 1;
        niveles = new ArrayList();
        String[] n = getNiveles("./niveles/");
        if(n!=null)
        {
            for (int i = 0; i < n.length; i++) {
                Nivel nivel1 = new Nivel(n[i]);
                niveles.add(nivel1);
            }
        }
    }

    public void generartablero(Personaje personaje) {
        niveles.get(nivel - 1).construir(this, personaje);
    }

    public void imprimirtablero(Personaje personaje) {
        System.out.println("________________________________");
        for (int i = 0; i < filas; i++) {
            String a = "";
            int n;
            for (int j = 0; j < columnas; j++) {
                n = matriz[i][j];
                a = a + n;
            }
            System.out.println(a);
        }
        System.out.println(" ");
        System.out.println("Ubicacion del personaje");
        System.out.println("Columna " + personaje.getColumna());
        System.out.println("Fila " + personaje.getFila());

        if (personaje.getOrientacion() == 0) {
            System.out.println("Orientacion " + personaje.getOrientacion() + " Arriba ");
        }
        if (personaje.getOrientacion() == 1) {
            System.out.println("Orientacion " + personaje.getOrientacion() + " Derecha ");
        }
        if (personaje.getOrientacion() == 2) {
            System.out.println("Orientacion " + personaje.getOrientacion() + " Abajo ");
        }
        if (personaje.getOrientacion() == 3) {
            System.out.println("Orientacion " + personaje.getOrientacion() + " Izquierda ");
        }
    }

    public boolean lucesencendidas() {
        int luces = 0;
        for (int i = 0; i < this.getFilas(); i++) {
            for (int j = 0; j < this.getColumnas(); j++) {
                if (this.matriz[i][j] == 2) {
                    luces++;
                }
            }
        }
        if (luces != 0) {
            return false;
        } else {
            return true;
        }
    }

    public void apagarluces() {
        for (int i = 0; i < this.getFilas(); i++) {
            for (int j = 0; j < this.getColumnas(); j++) {
                if (this.matriz[i][j] == 3) {
                    this.matriz[i][j] = 2;
                }
            }
        }
    }

    public static String[] getNiveles(String dir_path) {

        String[] arr_res = null;

        File f = new File(dir_path);

        if (f.isDirectory()) {

            List<String> res = new ArrayList<>();
            File[] arr_content = f.listFiles();

            int size = arr_content.length;

            for (int i = 0; i < size; i++) {

                if (arr_content[i].isFile()) {
                    res.add(arr_content[i].toString());
                }
            }

            arr_res = res.toArray(new String[0]);

        } else {
            System.err.println("¡ Path NO válido !");
        }

        return arr_res;
    }

    //Metodos Get y Set
    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Nivel> getNiveles() {
        return niveles;
    }

    public void setNiveles(ArrayList<Nivel> niveles) {
        this.niveles = niveles;
    }

}
