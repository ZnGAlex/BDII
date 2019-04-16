package aplicacion;

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

    public void muestraVPrincipal() {
        fgui.muestraVPrincipal();
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

    public java.util.List<Categoria> obtenerCategorias() {
        return gc.obtenerCategorias();
    }

    public java.util.List<Desarrolladora> obtenerDesarrolladoras() {
        return gd.obtenerDesarrolladoras();
    }
    
    public java.util.List<Juego> consultarJuegosTienda(String categoria, String desarrolladora, String nombre){
        return gj.consultarJuegosTienda(categoria,desarrolladora,nombre);
    }
    
    public boolean usuarioTieneJuego(String nick,Integer idJuego){
        return gu.usuarioTieneJuego(nick,idJuego);
    }
    
    public void muestraVVerDetalles(Juego juego){
        fgui.muestraVVerDetalles(juego);
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
    
    public void muestraVCarrito(Usuario usuario, java.util.List<Juego> juegos){
        fgui.muestraVCarrito(usuario, juegos);
    }
}
