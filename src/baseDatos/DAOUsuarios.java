package baseDatos;

import aplicacion.Jugador;
import aplicacion.Administrador;
import aplicacion.Juego;
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
            stmt = con.prepareStatement("SELECT * FROM Jugador WHERE nick = ? AND clave = MD5(?)");
            stmt.setString(1, login);
            stmt.setString(2, pw);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                /* Si el usuario a hacer login es jugador, se crea una instancia de jugador */
                java.util.Date fecha = (java.util.Date) rs.getObject("fec_nacimiento");
                usuario = new Jugador(rs.getString("nick"), rs.getString("clave"), rs.getString("correo"), fecha ,rs.getBoolean("baneado"));
            }
            
            if (usuario != null) return usuario;
            
            stmt = con.prepareStatement("SELECT * FROM Administrador WHERE nick = ? AND clave = MD5(?)");
            stmt.setString(1, login);
            stmt.setString(2, pw);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                /* Si el usuario a hacer login es administrador, se crea una instancia de administrador */
                java.util.Date fecha = (java.util.Date) rs.getObject("fec_nacimiento");
                usuario = new Administrador(rs.getString("nick"), rs.getString("clave"), rs.getString("correo"), fecha, rs.getInt("sueldo"));
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

            stmt = con.prepareStatement("INSERT INTO Jugadores (nick, clave, correo, fec_nacimiento, baneado)"
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
    
     public void jugar(Jugador jugador, Juego juego){
        
        PreparedStatement stmc = null;
       
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("insert into Jugar(jugador,juego) "
            +" values(?,?) ");
            stmc.setString(1, jugador.getNick());
            stmc.setString(2, juego.getNombre());
            
            stmc.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al intentar jugar");
        } finally {
            try {
                stmc.close();

            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void dejarJugar(Jugador jugador, Juego juego){
        
        PreparedStatement stmc = null;
       
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("update Jugar "
            +"set fec_fin = now() "
            +"where juego like ? "
            +"and jugador like ? "
            +"and fec_fin = null ");
            stmc.setString(1, juego.getNombre());
            stmc.setString(2, jugador.getNick());
            
            
            stmc.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, al dejar de jugar");
        } finally {
            try {
                stmc.close();

            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void retrasnmitir(Jugador jugador, Juego juego){
        
        PreparedStatement stmc = null;
       
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("insert into Retransmitir(jugador,juego) "
            +" values(?,?) ");
            stmc.setString(1, jugador.getNick());
            stmc.setString(2, juego.getNombre());
            
            stmc.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al intentar retransmitir");
        } finally {
            try {
                stmc.close();

            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void dejarRetransmitir(Jugador jugador, Juego juego){
        
        PreparedStatement stmc = null;
       
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("update Retrasnmitir "
            +"set fec_fin = now() "
            +"where juego like ? "
            +"and jugador like ? "
            +"and fec_fin = null ");
            stmc.setString(1, juego.getNombre());
            stmc.setString(2, jugador.getNick());
            
            
            stmc.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, al dejar de retransmitir");
        } finally {
            try {
                stmc.close();

            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void anhadirAmigo(Jugador jugador, Jugador amigo){
        
        PreparedStatement stmc = null;
       
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("");
            
            
            
            stmc.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, al intentar entablar amistad");
        } finally {
            try {
                stmc.close();

            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void quitarAmigo(Jugador jugador, Jugador amigo){
        
        PreparedStatement stmc = null;
       
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("delete from amigos "
                +" where (jugador like ? and amigo like ?) "
                + " or (jugador like ? and amigo like ?) ");
            stmc.setString(1, jugador.getNick());
            stmc.setString(2, amigo.getNick());
            stmc.setString(3, amigo.getNick());
            stmc.setString(4, jugador.getNick());
            
            
            stmc.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, al quitar amigo");
        } finally {
            try {
                stmc.close();

            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public boolean usuarioTieneJuego(String nick,Integer idJuego){
        boolean resultado = false;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("select * "
                    + "from comprar "
                    + "where jugador like ? "
                        + "and juego like ?");
            stmc.setString(1, nick);
            stmc.setInt(2, idJuego);

            rst = stmc.executeQuery();
            if (rst.next()) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al consultar pertenecia de juego");
        } finally {
            try {
                stmc.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    
}
