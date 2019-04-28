/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestionJuegos {
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionJuegos(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui=fgui;
        this.fbd=fbd;
    }
    
    public java.util.List<Juego> consultarJuegosTienda(String categoria, String desarrolladora, String nombre){
        return fbd.consultarJuegosTienda(categoria,desarrolladora,nombre);
    }
    
    public java.util.List<Juego> consultarJuegosPropios(String categoria, String desarrolladora, String nombre, Jugador jugador){
        return fbd.consultarJuegosPropios(categoria, desarrolladora, nombre, jugador);
    }
    
    public java.util.List<Complemento> obtenerComplementos(Juego juego){
        return fbd.obtenerComplementos(juego);
    }
    
    public java.util.List<Logro> obtenerLogros(Juego juego){
        return fbd.obtenerLogros(juego);
    }
    
    public void anhadirJuego(String nombre, Integer edadRecomendada, String desarrolladora, ArrayList<Categoria> categorias) {
        fbd.anhadirJuego(nombre, edadRecomendada, desarrolladora, categorias);
    }
    
    public void editarJuego(int idJuego, String nombre, Integer edadRecomendada, String desarrolladora, ArrayList<Categoria> categorias) {
        fbd.editarJuego(idJuego, nombre, edadRecomendada, desarrolladora, categorias);
    }
    
}
