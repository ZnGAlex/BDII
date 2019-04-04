package aplicacion;

public class FachadaAplicacion {
    
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionUsuarios gu;
    
    public FachadaAplicacion(){
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        gu = new GestionUsuarios(fgui, fbd);
    }

    public static void main(String[] args) {
        FachadaAplicacion fa;
     
        fa= new FachadaAplicacion();
        fa.iniciaLogin();
    }
    
    public void muestraVPrincipal() {
        fgui.muestraVPrincipal();
    }
    
    public void iniciaLogin(){
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
    
}
