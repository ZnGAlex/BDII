package gui;

import aplicacion.Jugador;

public class FachadaGui {
    
    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    
    public FachadaGui(aplicacion.FachadaAplicacion fa){
        this.fa=fa;
        this.vp = new VPrincipal(this.fa);
    }
    
    public void muestraVPrincipal () {
        this.vp.setVisible(true);
    }
    
    public void iniciaLogin(){
        VLogin va;
    
        va = new VLogin(this.vp, true, fa);
        va.setVisible(true);
    }
    
    public void muestraAvisoCorrecto (String s) {
        VAvisoCorrecto vac;
        
        vac = new VAvisoCorrecto(vp, true, s);
        vac.setVisible(true);
    }
    
}
