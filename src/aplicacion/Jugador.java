package aplicacion;

public class Jugador extends Usuario {
    private boolean baneado;

    public Jugador(String login, String pw, String correo, java.util.Date fechaNacimiento, boolean baneado) {
        super(login, pw, correo, fechaNacimiento);
        this.baneado = baneado;
    }

    public boolean getBaneado() {
        return this.baneado;
    }
    
    public void setBaneado(boolean baneado) {
        this.baneado = baneado;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + getLogin();
    }
    
}
