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
    
    /**
     * Permite al usuario de la aplicación iniciar sesion
     * @param login
     * @param pw
     * @return 
     */
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
    
    /**
     * Permite el registro de un usuario nuevo en la aplicacion
     * @param login
     * @param pw
     * @param correo
     * @param fechaNacimiento 
     */
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
    
    /**
     * Permite a un usuario modificar sus datos
     * @param usuario
     * @param fechaNac
     * @param correo 
     */
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
    
    /**
     * Permite a un usuario modificar sus datos, cuando cambia,
     * además, la contraseña
     * @param usuario
     * @param pw
     * @param fechaNac
     * @param correo 
     */
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
    
    /**
     * Cambia el estado de un jugador a jugar
     * @param jugador
     * @param juego 
     */
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
    
    /**
     * Permite a un jugador dejar de jugar guardando la fecha de fin
     * @param jugador
     * @param juego 
     */
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
    
    /**
     * Permite a un jugador retransmitir cuando esta jugando
     * @param jugador
     * @param juego 
     */
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
    
    /**
     * Permite a un jugador dejar la retransmision guardando la fecha de fin
     * @param jugador
     * @param juego 
     */
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
    
    /**
     * Permite a un jugador agregar a su lista de amigos otro jugador
     * @param jugador
     * @param amigo 
     */
    public void anhadirAmigo(Jugador jugador, Jugador amigo){
        PreparedStatement stmc = null;
        Connection con;
        con = this.getConexion();
        try {
            stmc = con.prepareStatement("insert into seramigo values (?, ?)");
            stmc.setString(1, jugador.getNick());
            stmc.setString(2, amigo.getNick());
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
    
    /**
     * Permite a un jugador borrar otro jugador de su lista de amigos
     * @param jugador
     * @param amigo 
     */
    public void borrarAmigo(Jugador jugador, Jugador amigo){
        
        PreparedStatement stmc = null;
       
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("delete from seramigo "
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
    
    /**
     * Comprueba si un jugador tiene un juego dado
     * @param nick
     * @param idJuego
     * @return 
     */
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
    
    /**
     * Obtiene todos los logros que ha conseguido un jugador
     * @param jugador
     * @return 
     */
    public ArrayList<Logro> obtenerLogrosJugador(Jugador jugador) {
        ArrayList<Logro> logros = new ArrayList<>();
        Logro logro = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Connection con = this.getConexion();
        
        try {
            stmt = con.prepareStatement("SELECT l.nombre, l.descripcion, l.puntos, l.juego FROM conseguirlogro c INNER JOIN logro l on c.logro = l.nombre and c.juego = l.juego WHERE c.jugador = ?");
            stmt.setString(1, jugador.getNick());
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                //System.out.println(rs.getInt("juego"));
                Juego juego = new Juego(rs.getInt("juego"), "nombre", 0, null);
                logro = new Logro(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("puntos"), juego);
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
    
    /**
     * Obtiene todos los logros que ha conseguido un jugador y que tiene marcados
     * como compartidos
     * @param jugador
     * @return 
     */
    public ArrayList<Logro> obtenerLogrosCompartidos(Jugador jugador) {
        ArrayList<Logro> logros = new ArrayList<>();
        Logro logro = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Connection con = this.getConexion();
        
        try {
            stmt = con.prepareStatement("SELECT l.nombre, l.descripcion, l.puntos, l.juego "
                    + "FROM conseguirlogro c INNER JOIN logro l on c.logro = l.nombre and c.juego = l.juego "
                    + "WHERE c.jugador = ? "
                        + "and c.visibilidad = true ");
            stmt.setString(1, jugador.getNick());
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                //System.out.println(rs.getInt("juego"));
                Juego juego = new Juego(rs.getInt("juego"), "nombre", 0, null);
                logro = new Logro(rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("puntos"), juego);
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
    
    /**
     * Obtiene el listado de amigos de un jugador
     * @param jugador
     * @param nombre
     * @return 
     */
    public java.util.List<Jugador> obtenerAmigos(Jugador jugador, String nombre){
        
        java.util.List<Jugador> resultado = new java.util.ArrayList<>();
        Jugador jActual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("select j.nick, j.correo, j.fec_nacimiento "
                    + "from seramigo s, jugador j "
                    + "where (s.jugador like ? and s.amigo like ? and j.nick like s.amigo) "
                    + "or (s.jugador like ? and s.amigo like ? and j.nick like s.jugador)");
            stmc.setString(1, jugador.getNick());
            stmc.setString(2,"%" + nombre + "%");
            stmc.setString(3,"%" + nombre + "%");
            stmc.setString(4, jugador.getNick());
            
            rst = stmc.executeQuery();
            while (rst.next()) {
                jActual = new Jugador(rst.getString("nick"), rst.getString("correo"), rst.getDate("fec_nacimiento"));
                resultado.add(jActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al obtener los amigos");
        } finally {
            try {
                stmc.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    /**
     * Permite obtener la lista del resto de jugadores excepto del propio jugador
     * @param jugador
     * @param nombre
     * @return 
     */
    public java.util.List<Jugador> obtenerJugadores(Jugador jugador, String nombre){
        
        java.util.List<Jugador> resultado = new java.util.ArrayList<>();
        Jugador jActual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("select nick, correo, fec_nacimiento "
                    + "from jugador "
                    + "where nick not like ? "
                    + "and nick like ?"); 
            stmc.setString(1, jugador.getNick());
            stmc.setString(2,"%" + nombre + "%");
            
            rst = stmc.executeQuery();
            while (rst.next()) {
                jActual = new Jugador(rst.getString("nick"), rst.getString("correo"), rst.getDate("fec_nacimiento"));
                resultado.add(jActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al obtener los jugadores");
        } finally {
            try {
                stmc.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    /**
     * Permite saber si un jugador tiene bloqueado a otro jugador
     * @param jugador
     * @param bloqueado
     * @return 
     */
    public boolean estaBloqueado(Jugador jugador, Jugador bloqueado){
        boolean resultado = false;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("select * "
                    + "from bloquear "
                    + "where jugador like ? and bloqueado like ? ");
            stmc.setString(1, jugador.getNick());
            stmc.setString(2, bloqueado.getNick());

            rst = stmc.executeQuery();
            if (rst.next()) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al consultar si está bloqueado");
        } finally {
            try {
                stmc.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    /**
     * Permite saber si dos jugadores son amigos
     * @param jugador
     * @param amigo
     * @return 
     */
    public boolean sonAmigos(Jugador jugador, Jugador amigo){
        boolean resultado = false;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("select * "
                    + "from seramigo "
                    + "where (jugador like ? and amigo like ?) "
                    + "or (jugador like ? and amigo like ?)");
            stmc.setString(1, jugador.getNick());
            stmc.setString(2, amigo.getNick());
            stmc.setString(3, amigo.getNick());
            stmc.setString(4, jugador.getNick());

            rst = stmc.executeQuery();
            if (rst.next()) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al consultar si eson amigos");
        } finally {
            try {
                stmc.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    /**
     * Obtiene el listado de jugadores bloqueados de un jugador
     * @param jugador
     * @param nombre
     * @return 
     */
    public java.util.List<Jugador> obtenerBloqueados(Jugador jugador, String nombre){
        java.util.List<Jugador> resultado = new java.util.ArrayList<>();
        Jugador jActual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("select bloqueado "
                    + "from bloquear "
                    + "where jugador like ? and bloqueado like ?");
            stmc.setString(1, jugador.getNick());
            stmc.setString(2,"%" + nombre + "%");
            
            rst = stmc.executeQuery();
            while (rst.next()) {
                jActual = new Jugador(rst.getString("bloqueado"));
                resultado.add(jActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al obtener los bloqueados");
        } finally {
            try {
                stmc.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    /**
     * CONSULTA COMPUESTA
     * Permite bloquear a un jugador
     * @param jugador
     * @param aBloquear
     */
    public void bloquearJugador(Jugador jugador, Jugador aBloquear){ 
        PreparedStatement stmc = null;
        Connection con;
        con = this.getConexion();
         
        try {
        //Desactivamos autocommit 
        con.setAutoCommit(false);
            stmc = con.prepareStatement("insert into bloquear(jugador, bloqueado) values(?, ?)");
            stmc.setString(1, jugador.getNick());
            stmc.setString(2,aBloquear.getNick());            
            stmc.executeUpdate();
            
            stmc = con.prepareStatement("delete from seramigo "
                    + "where (jugador like ? and amigo like ?) "
                        + "or (jugador like ? and amigo like ?)");
            stmc.setString(1, jugador.getNick());
            stmc.setString(2,aBloquear.getNick());            
            stmc.setString(3,aBloquear.getNick());            
            stmc.setString(4, jugador.getNick());
            stmc.executeUpdate();
        con.commit();
            
        } catch (SQLException e) {
            try {
                //Si ha fallado hacemos el rollback
                con.rollback();
            } catch (SQLException ex) {
                System.out.println("Imposible realizar el rollback");
            }
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al bloquear jugador");
        } finally {
            try {
                //Desactivamos autocommit 
                con.setAutoCommit(true);
                stmc.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    /**
     * CONSULTA COMPUESTA 3 CONSULTAS
     * Permite desbloquear a un jugador
     * @param jugador
     * @param desbloquear
     */
    public void desbloquearJugador(Jugador jugador, Jugador desbloquear){ 
        PreparedStatement stmc = null;
        Connection con;
        con = this.getConexion();
        ResultSet rst;
         
        try {
        //Desactivamos autocommit 
        con.setAutoCommit(false);
        
            //// 1 / Eliminar de la tabla bloquear
            stmc = con.prepareStatement("delete from bloquear "
                                      + "where jugador like ? and bloqueado like ?");
            stmc.setString(1, jugador.getNick());
            stmc.setString(2, desbloquear.getNick());        
            stmc.executeUpdate();
            
            //// 2 / Comprobar si el otro usuario me tiene bloqueado
            stmc = con.prepareStatement("select * from bloquear "
                                        + "where jugador like ? and bloqueado like ? ");
            stmc.setString(1, desbloquear.getNick());
            stmc.setString(2, jugador.getNick());
            rst = stmc.executeQuery();
            
            
            ///// 3 / Si el otro usuario no me tiene bloqueado lo añado a amigos
            if(!rst.next()){
                stmc = con.prepareStatement("insert into seramigo "
                        + "values (?, ?)");
                stmc.setString(1, jugador.getNick());
                stmc.setString(2,desbloquear.getNick());            

                stmc.executeUpdate();
            }
        con.commit();
            
        } catch (SQLException e) {
            try {
                //Si ha fallado hacemos el rollback
                con.rollback();
            } catch (SQLException ex) {
                System.out.println("Imposible realizar el rollback");
            }
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al desbloquear jugador");
        } finally {
            try {
                //Desactivamos autocommit 
                con.setAutoCommit(true);
                stmc.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    /**
     * ADMINISTRADOR
     * Permite obtener todos los jugadores de la base de datos
     * @param nick
     * @param correo
     * @return 
     */
    public ArrayList<Jugador> buscarJugadores(String nick, String correo) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugador = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = this.getConexion();
        
        try {
            stmt = con.prepareStatement("SELECT nick, correo, fec_nacimiento, baneado FROM jugador WHERE nick LIKE ? AND correo LIKE ?");
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
    
    /**
     * ADMINISTRADOR
     * Permite banear un jugador dado
     * @param nickJugador 
     */
    public void banearJugador(String nickJugador) {
        PreparedStatement stmt = null;
        Connection con = this.getConexion();
        
        try {
            stmt = con.prepareStatement("UPDATE Jugador SET baneado = TRUE WHERE nick = ?");
            stmt.setString(1, nickJugador);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto(e.getMessage());
        }
    }
    
    /**
     * ADMINISTRADOR
     * Permite desbanear un jugador dado
     * @param nickJugador 
     */
    public void desbanearJugador(String nickJugador) {
        PreparedStatement stmt = null;
        Connection con = this.getConexion();
        
        try {
            stmt = con.prepareStatement("UPDATE Jugador SET baneado = FALSE WHERE nick = ?");
            stmt.setString(1, nickJugador);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto(e.getMessage());
        }
    }
}