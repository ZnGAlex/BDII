package baseDatos;

import aplicacion.Jugador;
import aplicacion.Administrador;
import aplicacion.Juego;
import aplicacion.Logro;
import aplicacion.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOUsuarios extends AbstractDAO {
    
    public DAOUsuarios (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public Usuario validarUsuario(String login, String pw) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        Jugador jugador = null;
        
        Connection con = this.getConexion();
        
        try {            
            stmt = con.prepareStatement("SELECT * FROM Jugador WHERE nick = ? AND clave = crypt(?, clave)");
            stmt.setString(1, login);
            stmt.setString(2, pw);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                /* Si el usuario a hacer login es jugador, se crea una instancia de jugador */
                java.util.Date fecha = (java.util.Date) rs.getObject("fec_nacimiento");
                usuario = new Jugador(rs.getString("nick"), rs.getString("clave"), rs.getString("correo"), fecha, rs.getBoolean("baneado"));
            }
            
            if (usuario != null) {
                jugador = (Jugador) usuario;
                if (jugador.getBaneado()) {
                    this.getFachadaAplicacion().muestraAvisoCorrecto("El jugador esta baneado, no puede iniciar sesion.");
                    usuario = null;
                    return usuario;
                } else {
                    return usuario;
                }
            }
            
            stmt = con.prepareStatement("SELECT * FROM Administrador WHERE nick = ? AND clave = crypt(?, clave)");
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

            stmt = con.prepareStatement("INSERT INTO Jugador (nick, clave, correo, fec_nacimiento)"
                                      + " VALUES (?, crypt(?, gen_salt('bf')), ?, ?)");
            stmt.setString(1, login);
            stmt.setString(2, pw);
            stmt.setString(3, correo);
            stmt.setObject(4, new java.sql.Date(fechaNacimiento.getTime()));
            
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
    
    public void modificarDatosUsuario(Usuario usuario, java.util.Date fechaNac, String correo) {
        PreparedStatement stmt = null;
        Connection con = this.getConexion();
        
        try {
            stmt = con.prepareStatement("UPDATE Jugador "
                                      + "SET correo = ?, fec_nacimiento = ? "
                                      + "WHERE nick = ?");
            stmt.setString(1, correo);
            stmt.setObject(2, new java.sql.Date(fechaNac.getTime()));
            stmt.setString(3, usuario.getNick());
            
            stmt.executeUpdate();
            
            usuario.setCorreo(correo);
            usuario.setFechaNacimiento(fechaNac);
            
            this.getFachadaAplicacion().muestraAvisoCorrecto("Datos de usuario actualizados correctamente.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error modificando perfil.");
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void modificarDatosUsarioConPW(Usuario usuario, String pw, java.util.Date fechaNac, String correo) {
        PreparedStatement stmt = null;
        Connection con = this.getConexion();
        
        try {
            stmt = con.prepareStatement("UPDATE Jugador "
                                      + "SET clave = crypt(?, gen_salt('bf')), "
                                      + "correo = ?, fec_nacimiento = ? "
                                      + "WHERE nick = ?");
            stmt.setString(1, pw);
            stmt.setString(2, correo);
            stmt.setObject(3, new java.sql.Date(fechaNac.getTime()));
            stmt.setString(4, usuario.getNick());
            
            stmt.executeUpdate();
            
            usuario.setCorreo(correo);
            usuario.setFechaNacimiento(fechaNac);
            usuario.setPw(pw);
            
            this.getFachadaAplicacion().muestraAvisoCorrecto("Datos de usuario actualizados correctamente.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error modificando perfil.");
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
            stmc.setInt(2, juego.getId());
            
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
            +"set fechafin = now() "
            +"where juego = ? "
            +"and jugador = ? "
            +"and fechafin is null ");
            stmc.setInt(1, juego.getId());
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
            stmc.setInt(2, juego.getId());
            
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
            stmc = con.prepareStatement("update Retransmitir "
            +"set fechafin = now() "
            +"where juego = ? "
            +"and jugador like ? "
            +"and fechafin is null ");
            stmc.setInt(1, juego.getId());
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
                        + "and juego = ?");
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
    
    public ArrayList<Logro> obtenerLogrosJugador(Jugador jugador) {
        ArrayList<Logro> logros = new ArrayList<>();
        Logro logro = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Connection con = this.getConexion();
        
        try {
            stmt = con.prepareStatement("SELECT l.nombre, l.descripcion, l.puntos "
                                      + "FROM conseguirlogro c INNER JOIN logro l on c.logro = l.nombre and c.juego = l.juego "
                                      + "WHERE c.jugador = ?");
            stmt.setString(1, jugador.getNick());
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                logro = new Logro(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("puntos"));
                logros.add(logro);
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
        
        return logros;
    }
    
    public ArrayList<Jugador> buscarJugadores(String nick, String correo) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = this.getConexion();
        
        try {
            stmt = con.prepareStatement("SELECT nick, correo, fec_nacimiento, baneado FROM jugador WHERE nick = ? AND correo = ?");
            stmt.setString(1, '%' + nick + '%');
            stmt.setString(2, '%' + correo + '%');
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                java.util.Date fecha = (java.util.Date) rs.getObject("fec_nacimiento");
                jugador = new Jugador(rs.getString("nick"), rs.getString("correo"), fecha, rs.getBoolean("baneado"));
                jugadores.add(jugador);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto(e.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return jugadores;
    }
    
    
}
