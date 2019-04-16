package gui;

import aplicacion.Juego;
import aplicacion.Jugador;
import aplicacion.Usuario;

public class FachadaGui {

    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = new VPrincipal(this.fa);
    }

    public void muestraVPrincipal() {
        vp.inicializarBoxes();
        this.vp.setVisible(true);
    }

    public void iniciaLogin() {
        VLogin va;

        va = new VLogin(this.vp, true, fa);
        va.setVisible(true);
    }

    public void muestraAvisoCorrecto(String s) {
        VAvisoCorrecto vac;

        vac = new VAvisoCorrecto(vp, true, s);
        vac.setVisible(true);
    }

    public void muestraVVerDetalles(Juego juego) {
        VVerDetalles vvd;

        vvd = new VVerDetalles(this.vp, true, fa, juego);
        vvd.setVisible(true);
    }

    public void muestraVMiPerfil(Usuario usuario) {
        VMiPerfil vmp;

        vmp = new VMiPerfil(this.vp, true, false, usuario);
        vmp.setVisible(true);
    }
    
    public void muestraVMisAmigos(Usuario usuario){
        VMisAmigos vma;
        
        vma = new VMisAmigos(this.vp,true,fa,usuario);
        vma.setVisible(true);
    }
    
    public void muestraVMisJuegos(Usuario usuario){
        VMisJuegos vmj;
        
        vmj = new VMisJuegos(this.vp,true,fa,usuario);
        vmj.setVisible(true);
    }
    
    public void muestraVCarrito(Usuario usuario, java.util.List<Juego> juegos){
        VCarrito vc;
        
        vc = new VCarrito(this.vp,true,fa,usuario,juegos);
        vc.setVisible(true);
    }

}
