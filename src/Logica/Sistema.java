package Logica;

/**
 * @author ASUS
 * @version 1.0
 * @created 27-feb.-2018 11:11:24 a.m.
 */
public class Sistema {

    private Personaje personaje;
    private Tablero tablero;

    public Sistema() {
        tablero = new Tablero();
        personaje = new Personaje(tablero);
        tablero.generartablero(personaje);
        tablero.imprimirtablero(personaje);
    }

    //metodos get y set    
    
    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

}
