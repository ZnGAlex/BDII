package aplicacion;

public class Complemento {
    private String nombre;
    private String descripcion;
    private Juego juego;
    
    public Complemento (String nombre, String descripcion, Juego juego) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
    
}
