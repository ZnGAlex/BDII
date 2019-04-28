package gui;

import aplicacion.Juego;
import aplicacion.Jugador;
import aplicacion.Usuario;

public class FachadaGui {

    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    VPrincipalAdministrador vpa;

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = new VPrincipal(this.fa);
        this.vpa = new VPrincipalAdministrador(this.fa);
    }

    public void muestraVPrincipal(Usuario usuario) {
        vp.inicializarBoxes();
        vp.setUsuario(usuario);
        this.vp.setVisible(true);
    }
    
    public void muestraVPrincipalAdministrador(Usuario usuario) {
        this.vpa.inicializarBoxes();
        this.vpa.setVisible(true);
    }
    
    public void muestraVAnhadirJuego() {
        VAnhadirJuego vaj;
        
        vaj = new VAnhadirJuego(this.vp, true, this.fa);
        vaj.inicializarBoxes();
        vaj.setVisible(true);
    }
    
    public void muestraEditarJuego(Juego juego) {
        VEditarJuego vej;
        
        vej = new VEditarJuego(this.vp, true, this.fa, juego);
        vej.setVisible(true);
    }

    public void iniciaLogin() {
        VLogin va;

        va = new VLogin(this.vp, true, fa);
    }

    public void muestraAvisoCorrecto(String s) {
        VAvisoCorrecto vac;

        vac = new VAvisoCorrecto(vp, true, s);
        vac.setVisible(true);
    }

    public void muestraVVerDetalles(Juego juego) {
        VVerDetalles vvd;

        vvd = new VVerDetalles(this.vp, true, fa, juego);
    }
    
    public void muestraVVerLogros(Juego juego, Jugador jugador){
        VVerLogros vvl;
        
        vvl = new VVerLogros(this.vp, true, fa, juego, jugador);
    }

    public void muestraVMiPerfil(Usuario usuario) {
        VMiPerfil vmp;

        vmp = new VMiPerfil(this.vp, fa, true, false, usuario);
    }
    
    public void muestraVMisAmigos(Usuario usuario){
        VMisAmigos vma;
        
        vma = new VMisAmigos(this.vp,true,fa,usuario);
    }
    
    public void muestraVMisJuegos(Usuario usuario){
        VMisJuegos vmj;
        
        vmj = new VMisJuegos(this.vp,true,fa,usuario);
    }
    
    public void muestraJugar(Jugador jugador, Juego juego){
        VJugar vj;
        
        vj= new VJugar(this.vp,true,fa,jugador,juego);
    }
    
    public void muestraVCarrito(gui.VPrincipal VPrincipal, Usuario usuario, java.util.List<Juego> juegos){
        VCarrito vc;
        
        vc = new VCarrito(VPrincipal, this.vp,true,fa,usuario,juegos);
    }

}
