package aplicacion;

public class Administrador extends Usuario {
    private Integer sueldo;
    
    public Administrador (String login, String pw, String correo, java.util.Date fechaNacimiento, Integer sueldo) {
        super(login, pw, correo, fechaNacimiento);
        this.sueldo = sueldo;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }
    
}
