package baseDatos;

import aplicacion.Categoria;
import aplicacion.Complemento;
import aplicacion.Desarrolladora;
import aplicacion.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import aplicacion.Juego;
import aplicacion.Jugador;
import aplicacion.Logro;
import java.util.ArrayList;

public class FachadaBaseDatos {
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;
    private DAOCategorias daoCategorias;
    private DAODesarrolladoras daoDesarrolladoras;
    private DAOJuegos daoJuegos;
    
    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
        
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);
            daoUsuarios = new DAOUsuarios(conexion, fa);
            daoCategorias = new DAOCategorias(conexion, fa);
            daoDesarrolladoras = new DAODesarrolladoras(conexion,fa);
            daoJuegos = new DAOJuegos(conexion,fa);
        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            // fa.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            // fa.muestraExcepcion(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            // fa.muestraExcepcion(e.getMessage());
        }
    }
    
    public Usuario validarUsuario(String login, String pw){
        return daoUsuarios.validarUsuario(login, pw);
    }
    
    public void registrarUsuario(String login, String pw, String correo, java.util.Date fechaNacimiento) {
        daoUsuarios.registrarUsuario(login, pw, correo, fechaNacimiento);
    }
    
    public void modificarDatosUsuario(Usuario usuario, java.util.Date fechaNacimiento, String correo) {
        daoUsuarios.modificarDatosUsuario(usuario, fechaNacimiento, correo);
    }
    
    public void modificarDatosUsuarioConPW(Usuario usuario, String pw, java.util.Date fechaNacimiento, String correo) {
        daoUsuarios.modificarDatosUsarioConPW(usuario, pw, fechaNacimiento, correo);
    }
    
    public java.util.List<Categoria> obtenerCategorias(){
        return daoCategorias.obtenerCategorias();
    }
    
    public java.util.List<Desarrolladora> obtenerDesarrolladoras() {
        return daoDesarrolladoras.obtenerDesarrolladoras();
    }

    public void jugar(Jugador j, Juego ju){
        daoUsuarios.jugar(j, ju);
    }
    
    public void dejarJugar(Jugador j, Juego ju){
        daoUsuarios.dejarJugar(j, ju);
    }
    
    public void retransmitir(Jugador j, Juego ju){
        daoUsuarios.retrasnmitir(j, ju);
    }
    
    public void comprarListaJuegos(Jugador jugador, java.util.List<Juego> juegos){
        daoJuegos.comprarListaJuegos(jugador, juegos);
    }
    
    public void dejarRetransmitir(Jugador j, Juego ju){
        daoUsuarios.dejarRetransmitir(j, ju);
    }
    
    public java.util.List<Juego> consultarJuegosTienda(String categoria, String desarrolladora, String nombre){
        return daoJuegos.consultarJuegosTienda(categoria, desarrolladora, nombre);
    }
    
    public java.util.List<Juego> consultarJuegosPropios(String categoria, String desarrolladora, String nombre, Jugador jugador){
        return daoJuegos.consultarJuegosPropios(categoria, desarrolladora, nombre, jugador);
    }
    
    public java.util.List<Juego> consultarJuegosCompartidos(String categoria, String desarrolladora, String nombre, Jugador jugador){
        return daoJuegos.consultarJuegosCompartidos(categoria,desarrolladora,nombre, jugador);
    }
    
    public boolean usuarioTieneJuego(String nick,Integer idJuego){
        return daoUsuarios.usuarioTieneJuego(nick,idJuego);
    }
    
    public java.util.List<Complemento> obtenerComplementos(Juego juego){
        return daoJuegos.obtenerComplementos(juego);
    }
    
    public java.util.List<Logro> obtenerLogros(Juego juego){
        return daoJuegos.obtenerLogros(juego);
    }
    
    public java.util.List<Categoria> obtenerCategoriasJuego(Juego juego){
        return daoCategorias.obtenerCategoriasJuego(juego);
    }
    
    public java.util.ArrayList<Logro> obtenerLogrosJugador(Jugador jugador) {
        return daoUsuarios.obtenerLogrosJugador(jugador);
    }
    
    public java.util.ArrayList<Logro> obtenerLogrosCompartidos(Jugador jugador) {
        return daoUsuarios.obtenerLogrosCompartidos(jugador);
    }
    
    public java.util.List<Jugador> obtenerAmigos(Jugador jugador, String nombre){
        return daoUsuarios.obtenerAmigos(jugador, nombre);
    }
    
    public java.util.List<Jugador> obtenerJugadores(Jugador jugador, String nombre){
        return daoUsuarios.obtenerJugadores(jugador, nombre);
    }
    
    public void bloquearJugador(Jugador jugador, Jugador aBloquear){
        daoUsuarios.bloquearJugador(jugador, aBloquear);
    }
    
    public boolean estaBloqueado(Jugador jugador, Jugador bloqueado){
        return daoUsuarios.estaBloqueado(jugador, bloqueado);
    }
    
    public boolean sonAmigos(Jugador jugador, Jugador amigo){
        return daoUsuarios.sonAmigos(jugador, amigo);
    }
    
    public void anhadirAmigo(Jugador jugador, Jugador amigo){
        daoUsuarios.anhadirAmigo(jugador, amigo);
    }
    
    public void borrarAmigo(Jugador jugador, Jugador amigo){
        daoUsuarios.borrarAmigo(jugador, amigo);
    }
    
    public java.util.List<Jugador> obtenerBloqueados(Jugador jugador, String nombre){
        return daoUsuarios.obtenerBloqueados(jugador,nombre);
    }
    
    public void desbloquearJugador(Jugador jugador, Jugador desbloquear){
        daoUsuarios.desbloquearJugador(jugador,desbloquear);
    }
    
    public boolean visibilidadLogro(Jugador jugador, Logro logro){
        return daoJuegos.visibilidadLogro(jugador, logro);
    }
    
    public boolean visibilidadCompra(Jugador jugador, Juego juego){
        return daoJuegos.visibilidadCompra(jugador, juego);
    }
    
    public void cambiarVisibilidadCompra(Jugador jugador, Juego juego, boolean v){
        daoJuegos.cambiarVisibilidadCompra(jugador, juego, v);
    }
    
    public void cambiarVisibilidadLogro(Jugador jugador, Logro logro, boolean v){
        daoJuegos.cambiarVisibilidadLogro(jugador, logro, v);
    }
    
    public void obtenerComplementoJugador(Jugador jugador, Complemento complemento){
        daoJuegos.obtenerComplementoJugador(jugador, complemento);
    }
    
    public java.util.ArrayList<Jugador> buscarJugadores(String nick, String correo) {
        return daoUsuarios.buscarJugadores(nick, correo);
    }
    
    public void banearJugador(String nickJugador) {
        daoUsuarios.banearJugador(nickJugador);
    }
    
    public void desbanearJugador(String nickJugador) {
        daoUsuarios.desbanearJugador(nickJugador);
    }
    
    public void anhadirJuego(String nombre, Integer edadRecomendada, String desarrolladora, ArrayList<Categoria> categorias) {
        daoJuegos.anhadirJuego(nombre, edadRecomendada, desarrolladora, categorias);
    }
    
    public void editarJuego(int idJuego, String nombre, Integer edadRecomendada, String desarrolladora, ArrayList<Categoria> categorias) {
        daoJuegos.editarJuego(idJuego, nombre, edadRecomendada, desarrolladora, categorias);
    }
    
}
