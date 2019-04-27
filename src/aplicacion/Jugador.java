package aplicacion;

public class Jugador extends Usuario {
    private boolean baneado;

    public Jugador(String nick){
        super(nick);
    }
    
    public Jugador(String nick, String pw, String correo, java.util.Date fechaNacimiento, boolean baneado) {
        super(nick, pw, correo, fechaNacimiento);
        this.baneado = baneado;
    }
    
    public Jugador(String nick, String correo, java.util.Date fechaNacimiento){
        super(nick, correo, fechaNacimiento);
    }
    
    @Override
    public String getNick(){
        return super.getNick();
    }

    public boolean getBaneado() {
        return this.baneado;
    }
    
    public void setBaneado(boolean baneado) {
        this.baneado = baneado;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + getNick();
    }
    
}
