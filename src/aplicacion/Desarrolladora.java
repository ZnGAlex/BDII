package aplicacion;

import java.util.ArrayList;

public class Desarrolladora {
    private String nombre;
    private String pais;
    private ArrayList<Juego> juegos;
    
    public Desarrolladora(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.juegos = new ArrayList<>();
    }
    
    public Desarrolladora(String nombre, String pais, ArrayList juegos) {
        this.nombre = nombre;
        this.pais = pais;
        this.juegos = juegos;
    }
    
    public void anhadirJuego(Juego juego) {
        this.juegos.add(juego);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
