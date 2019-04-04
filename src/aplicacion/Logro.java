package aplicacion;

public class Logro {
    private String nombre;
    private String descripcion;
    private Integer puntos;
    private Juego juego;
    
    public Logro (String nombre, String descripcion, Integer puntos, Juego juego) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntos = puntos;
        this.juego = juego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    
}
