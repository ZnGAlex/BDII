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
    
    public void jugar(Jugador j, Juego ju){
        fbd.jugar(j, ju);
    }
    
    public void dejarJugar(Jugador j, Juego ju){
        fbd.dejarJugar(j, ju);
    }
    
    public void retranmitir(Jugador j, Juego ju){
        fbd.retransmitir(j, ju);
    }
    
    public void dejarRetransmitir(Jugador j, Juego ju){
        fbd.dejarRetransmitir(j, ju);
    }
}
