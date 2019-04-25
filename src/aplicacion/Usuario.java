package aplicacion;

public abstract class Usuario {
     private String nick;
     private String pw;
     private String correo;
     private java.util.Date fechaNacimiento;
     
    public Usuario(String nick, String pw, String correo, java.util.Date fechaNacimiento) {
        this.nick = nick;
        this.pw = pw;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Usuario(String nick, String correo, java.util.Date fechaNacimiento) {
        this.nick = nick;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public java.util.Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(java.util.Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
     
}
