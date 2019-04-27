package aplicacion;

import javax.swing.JDialog;

public class FachadaAplicacion {

    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionUsuarios gu;
    GestionCategorias gc;
    GestionDesarrolladoras gd;
    GestionJuegos gj;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        gu = new GestionUsuarios(fgui, fbd);
        gc = new GestionCategorias(fgui, fbd);
        gd = new GestionDesarrolladoras(fgui, fbd);
        gj = new GestionJuegos(fgui, fbd);
    }

    public static void main(String[] args) {
        FachadaAplicacion fa;

        fa = new FachadaAplicacion();
        fa.iniciaLogin();
    }

    public void muestraVPrincipal(Usuario usuario) {
        fgui.muestraVPrincipal(usuario);
    }

    public void iniciaLogin() {
        fgui.iniciaLogin();
    }

    public void muestraAvisoCorrecto(String s) {
        fgui.muestraAvisoCorrecto(s);
    }

    public void registrarUsuario(String login, String pw, String correo, java.util.Date fechaNacimiento) {
        fbd.registrarUsuario(login, pw, correo, fechaNacimiento);
    }

    public Usuario validarUsuario(String login, String pw) {
        return gu.validarUsuario(login, pw);
    }
    
    public void modificarDatosUsuario(Usuario usuario, java.util.Date fechaNacimiento, String correo) {
        fbd.modificarDatosUsuario(usuario, fechaNacimiento, correo);
    }
    
    public void modificarDatosUsuarioConPW(Usuario usuario, String pw, java.util.Date fechaNacimiento, String correo) {
        fbd.modificarDatosUsuarioConPW(usuario, pw, fechaNacimiento, correo);
    }

    public java.util.List<Categoria> obtenerCategorias() {
        return gc.obtenerCategorias();
    }

    public java.util.List<Desarrolladora> obtenerDesarrolladoras() {
        return gd.obtenerDesarrolladoras();
    }
    
    public java.util.List<Juego> consultarJuegosTienda(String categoria, String desarrolladora, String nombre){
        return gj.consultarJuegosTienda(categoria,desarrolladora,nombre);
    }
    
    public java.util.List<Juego> consultarJuegosPropios(String categoria, String desarrolladora, String nombre, Jugador jugador){
        return gj.consultarJuegosPropios(categoria,desarrolladora,nombre, jugador);
    }
    
    public boolean usuarioTieneJuego(String nick,Integer idJuego){
        return gu.usuarioTieneJuego(nick,idJuego);
    }
    
    public void comprarListaJuegos(Jugador jugador, java.util.List<Juego> juegos){
        fbd.comprarListaJuegos(jugador, juegos);
    }
    
    public void muestraVVerDetalles(Juego juego){
        fgui.muestraVVerDetalles(juego);
    }
    
    public void muestraVVerLogros(Juego juego, Jugador jugador){
        fgui.muestraVVerLogros(juego, jugador);
    }

    public void muestraVMiPerfil(Usuario usuario){
        fgui.muestraVMiPerfil(usuario);
    }
    
    public void muestraVMisAmigos(Usuario usuario){
        fgui.muestraVMisAmigos(usuario);
    }
    
    public void muestraVMisJuegos(Usuario usuario){
        fgui.muestraVMisJuegos(usuario);
    }
    
    public void muestraJugar(Jugador jugador, Juego juego){
        fgui.muestraJugar(jugador, juego);
    }
    
    public void muestraVCarrito(gui.VPrincipal VPrincipal, Usuario usuario, java.util.List<Juego> juegos){
        fgui.muestraVCarrito(VPrincipal, usuario, juegos);
    }
    
    public void jugar(Jugador jugador, Juego juego){
        gu.jugar(jugador, juego);
    }
    
    public void dejarJugar(Jugador jugador, Juego juego){
        gu.dejarJugar(jugador, juego);
    }
    
    public void retransmitir(Jugador jugador, Juego juego){
        gu.retranmitir(jugador, juego);
    }
    
    public void dejarRetransmitir(Jugador jugador, Juego juego){
        gu.dejarRetransmitir(jugador, juego);
    }
    
    public java.util.List<Complemento> obtenerComplementos(Juego juego){
        return gj.obtenerComplementos(juego);
    }
    
    public java.util.List<Logro> obtenerLogros(Juego juego){
        return gj.obtenerLogros(juego);
    }
    
    public java.util.List<Categoria> obtenerCategoriasJuego(Juego juego){
        return gc.obtenerCategoriasJuego(juego);
    }
    
    public java.util.ArrayList<Logro> obtenerLogrosJugador(Jugador jugador) {
        return gu.obtenerLogrosJugador(jugador);
    }
    
    public java.util.List<Jugador> obtenerAmigos(Jugador jugador, String nombre){
        return gu.obtenerAmigos(jugador, nombre);
    }
    
    public java.util.List<Jugador> obtenerJugadores(Jugador jugador, String nombre){
        return gu.obtenerJugadores(jugador, nombre);
    }
    
    public void bloquearJugador(Jugador jugador, Jugador aBloquear){
        gu.bloquearJugador(jugador, aBloquear);
    }
    
    public boolean estaBloqueado(Jugador jugador, Jugador bloqueado){
        return gu.estaBloqueado(jugador, bloqueado);
    }
    
    public boolean sonAmigos(Jugador jugador, Jugador amigo){
        return gu.sonAmigos(jugador, amigo);
    }
    
    public void anhadirAmigo(Jugador jugador, Jugador amigo){
        gu.anhadirAmigo(jugador, amigo);
    }
    
    public java.util.List<Jugador> obtenerBloqueados(Jugador jugador, String nombre){
        return gu.obtenerBloqueados(jugador,nombre);
    }
    
    public void muestraVBloqueados(Usuario usuario, JDialog parent){
        fgui.muestraVBloqueados(usuario,parent);
    }
    
    public void desbloquearJugador(Jugador jugador, Jugador desbloquear){
        gu.desbloquearJugador(jugador,desbloquear);
    }
}
