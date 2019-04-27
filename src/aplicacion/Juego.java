package aplicacion;

import java.util.ArrayList;

public class Juego {
    private Integer id;
    private String nombre;
    private Integer edadRecomendada;
    private ArrayList<Categoria> categorias;
    private Desarrolladora desarrolladora;
    private ArrayList<Complemento> complementos;
    private ArrayList<Logro> logros;
    
    public Juego (Integer id, String nombre, Integer edadRecomendada, ArrayList<Categoria> categorias, Desarrolladora desarrolladora, ArrayList<Complemento> complementos, ArrayList<Logro> logros) {
        this.id = id;
        this.nombre = nombre;
        this.edadRecomendada = edadRecomendada;
        this.categorias = categorias;
        this.desarrolladora = desarrolladora;
        this.complementos = complementos;
        this.logros = logros;
    }
    
    public Juego (Integer id, String nombre, Integer edadRecomendada, Categoria categoria, Desarrolladora desarrolladora) {
        this.id = id;
        this.nombre = nombre;
        this.edadRecomendada = edadRecomendada;
        this.categorias = new ArrayList<>();
        this.categorias.add(categoria);
        this.desarrolladora = desarrolladora;
    }
    
    public Juego (Integer id, String nombre, Integer edadRecomendada, Desarrolladora desarrolladora) {
        this.id = id;
        this.nombre = nombre;
        this.edadRecomendada = edadRecomendada;
        this.desarrolladora = desarrolladora;
    }  
    
    public Juego (Integer id, String nombre, Categoria categoria, Desarrolladora desarrolladora) {
        this.id = id;
        this.nombre = nombre;
        this.categorias = new ArrayList<>();
        this.categorias.add(categoria);
        this.desarrolladora = desarrolladora;
    }
    
    public void anhadirCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }
    
    public void borrarCategoria(Categoria categoria) {
        this.categorias.remove(categoria);
    }
    
    public void anhadirComplemento(Complemento complemento) {
        this.complementos.add(complemento);
    }
    
    public void borrarComplemento(Complemento complemento) {
        this.complementos.remove(complemento);
    }
    
    public void anhadirLogro(Logro logro) {
        this.logros.add(logro);
    }
    
    public void borrarLogro(Logro logro) {
        this.logros.remove(logro);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(Integer edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Desarrolladora getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(Desarrolladora desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public ArrayList<Complemento> getComplementos() {
        return complementos;
    }

    public void setComplementos(ArrayList<Complemento> complementos) {
        this.complementos = complementos;
    }

    public ArrayList<Logro> getLogros() {
        return logros;
    }

    public void setLogros(ArrayList<Logro> logros) {
        this.logros = logros;
    }
    
    
    
}
