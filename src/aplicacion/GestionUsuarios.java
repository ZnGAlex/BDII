package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.util.ArrayList;

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
    
    public boolean usuarioTieneJuego(String nick,Integer idJuego){
        return fbd.usuarioTieneJuego(nick,idJuego);
    }
    
    public ArrayList<Logro> obtenerLogrosJugador(Jugador jugador) {
        return fbd.obtenerLogrosJugador(jugador);
    }
    
    public java.util.List<Jugador> obtenerAmigos(Usuario usuario, String nombre){
        return fbd.obtenerAmigos(usuario, nombre);
    }
    
    public java.util.List<Jugador> obtenerJugadores(Usuario usuario, String nombre){
        return fbd.obtenerJugadores(usuario, nombre);
    }
    
    public void bloquearJugador(Usuario usuario, Jugador jugador){
        fbd.bloquearJugador(usuario, jugador);
    }
    
}
