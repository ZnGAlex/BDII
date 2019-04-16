/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

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
}
