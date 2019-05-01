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
    
    public java.util.ArrayList<Logro> obtenerLogrosCompartidos(Jugador jugador) {
        return fbd.obtenerLogrosCompartidos(jugador);
    }
    
    public java.util.List<Jugador> obtenerAmigos(Jugador jugador, String nombre){
        return fbd.obtenerAmigos(jugador, nombre);
    }
    
    public java.util.List<Jugador> obtenerJugadores(Jugador jugador, String nombre){
        return fbd.obtenerJugadores(jugador, nombre);
    }
    
    public void bloquearJugador(Jugador jugador, Jugador aBloquear){
        fbd.bloquearJugador(jugador, aBloquear);
    }
    
    public boolean estaBloqueado(Jugador jugador, Jugador bloqueado){
        return fbd.estaBloqueado(jugador, bloqueado);
    }
    
    public boolean sonAmigos(Jugador jugador, Jugador amigo){
        return fbd.sonAmigos(jugador, amigo);
    }
    
    public void anhadirAmigo(Jugador jugador, Jugador amigo){
        fbd.anhadirAmigo(jugador, amigo);
    }
    
    public void borrarAmigo(Jugador jugador, Jugador amigo){
        fbd.borrarAmigo(jugador, amigo);
    }
    
    public java.util.List<Jugador> obtenerBloqueados(Jugador jugador, String nombre){
        return fbd.obtenerBloqueados(jugador,nombre);
    }
    
    public void desbloquearJugador(Jugador jugador, Jugador desbloquear){
        fbd.desbloquearJugador(jugador,desbloquear);
    }
    
    public void banearJugador(String nickJugador) {
        fbd.banearJugador(nickJugador);
    }
    
    public void desbanearJugador(String nickJugador) {
        fbd.desbanearJugador(nickJugador);
    }
}
