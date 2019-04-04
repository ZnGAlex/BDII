package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

public class GestionUsuarios {
    
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui=fgui;
        this.fbd=fbd;
    }  
    
    public Usuario validarUsuario(String login, String pw) {
        return fbd.validarUsuario(login, pw);
    }
    
}
