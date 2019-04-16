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
public class GestionDesarrolladoras {
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionDesarrolladoras(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui=fgui;
        this.fbd=fbd;
    }
    
    public java.util.List<Desarrolladora> obtenerDesarrolladoras() {
        return fbd.obtenerDesarrolladoras();
    }
}
