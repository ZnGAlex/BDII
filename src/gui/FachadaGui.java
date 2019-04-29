package gui;

import aplicacion.Juego;
import aplicacion.Jugador;
import aplicacion.Usuario;
import javax.swing.JDialog;

public class FachadaGui {

    private aplicacion.FachadaAplicacion fa;
    private VPrincipal vp;
    

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = new VPrincipal(this.fa);
    }

    public void muestraVPrincipal(Usuario usuario) {
        vp.inicializarBoxes();
        vp.setUsuario(usuario);
        this.vp.setVisible(true);
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

    public void muestraVVerDetalles(Juego juego, Jugador jugador) {
        VVerDetalles vvd;

        vvd = new VVerDetalles(this.vp, true, fa, juego, jugador);
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
        
        vmj = new VMisJuegos(this.vp,true,fa,usuario,false);
    }
    
    public void muestraJugar(Jugador jugador, Juego juego){
        VJugar vj;
        
        vj= new VJugar(this.vp,true,fa,jugador,juego);
    }
    
    public void muestraVCarrito(gui.VPrincipal VPrincipal, Usuario usuario, java.util.List<Juego> juegos){
        VCarrito vc;
        
        vc = new VCarrito(VPrincipal, this.vp,true,fa,usuario,juegos);
    }
    
    public void muestraVBloqueados(Usuario usuario, JDialog parent){
        VBloqueados vb;
        
        vb = new VBloqueados(parent, true,fa,usuario);
    }
    
    public void muestraVPerfilAmigo(Usuario usuario){
        VMiPerfil vmp;
        
        vmp = new VMiPerfil(this.vp,fa,true,true, usuario); 
    }

}
