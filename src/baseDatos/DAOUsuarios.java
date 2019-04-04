package baseDatos;

import aplicacion.Jugador;
import aplicacion.Administrador;
import aplicacion.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUsuarios extends AbstractDAO {
    
    public DAOUsuarios (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public Usuario validarUsuario(String login, String pw) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        
        Connection con = this.getConexion();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Jugadores WHERE clave = MD5(?)");
            stmt.setString(1, pw);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                /* Si el usuario a hacer login es jugador, se crea una instancia de jugador */
                java.util.Date fecha = (java.util.Date) rs.getObject("fechaNacimiento");
                usuario = new Jugador(rs.getString("login"), rs.getString("clave"), rs.getString("correo"), fecha ,rs.getBoolean("baneado"));
            }
            
            stmt = con.prepareStatement("SELECT * FROM Administradores WHERE clave = MD5(?)");
            stmt.setString(1, pw);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                /* Si el usuario a hacer login es administrador, se crea una instancia de administrador */
                java.util.Date fecha = (java.util.Date) rs.getObject("fechaNacimiento");
                usuario = new Administrador(rs.getString("login"), rs.getString("clave"), rs.getString("correo"), fecha, rs.getInt("sueldo"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
        }
        return usuario;
    }
    
    public void registrarUsuario (String login, String pw, String correo, java.util.Date fechaNacimiento) {
        PreparedStatement stmt = null;
        
        Connection con = this.getConexion();
        
        try {
            stmt = con.prepareStatement("INSERT INTO Jugadores (login, clave, correo, fechaNacimiento, baneado)"
                                      + " VALUES (?, MD5(?), ?, ?, ?)");
            stmt.setString(1, login);
            stmt.setString(2, pw);
            stmt.setString(3, correo);
            stmt.setObject(4, new java.sql.Date(fechaNacimiento.getTime()));
            stmt.setBoolean(5, false);
            
            stmt.executeUpdate();
            
            this.getFachadaAplicacion().muestraAvisoCorrecto("Usuario " + login + " registrado correctamente.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
    }
}
