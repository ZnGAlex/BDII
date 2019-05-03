package baseDatos;

import aplicacion.Categoria;
import aplicacion.Complemento;
import java.sql.*;
import aplicacion.Juego;
import aplicacion.Desarrolladora;
import aplicacion.Jugador;
import aplicacion.Logro;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */

public class DAOJuegos extends AbstractDAO {

    public DAOJuegos(Connection con, aplicacion.FachadaAplicacion fa) {
        super.setConexion(con);
        super.setFachadaAplicacion(fa);
    }

    /**
     * Este metodo le permite al jugador ver los juegos disponible sen la tienda, tanto los
     * que tiene como los que no.
     * @param categoria
     * @param desarrolladora
     * @param nombre
     * @return 
     */
    public java.util.List<Juego> consultarJuegosTienda(String categoria, String desarrolladora, String nombre) {

        java.util.List<Juego> resultado = new java.util.ArrayList<>();
        Juego jactual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;
        
        if(categoria.equals("")){
            categoria = "%";
        }
        if(desarrolladora.equals("")){
            desarrolladora = "%";
        }

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("select distinct j.id, j.nombre, j.edadrecomendada, j.desarrolladora, d.pais "
                    + "from Juego as j, TenerCategoria as c, Desarrolladora as d "
                    + "where j.id = c.juego "
                    + "and j.desarrolladora like d.nombre "
                    + "and j.nombre like ? "
                    + "and j.desarrolladora like ? "
                    + "and c.categoria like ? ");
            stmc.setString(1, "%" + nombre + "%");
            stmc.setString(2, desarrolladora);
            stmc.setString(3, categoria);

            rst = stmc.executeQuery();
            while (rst.next()) {
                jactual = new Juego(rst.getInt("id"), rst.getString("nombre"), rst.getInt("edadrecomendada"), null, new Desarrolladora(rst.getString("desarrolladora"), rst.getString("pais")));
                resultado.add(jactual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al buscar en la tienda");
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
     * Esta cnsulta le permite al jugador obtener los juegos que tiene comprados.
     * @param categoria
     * @param desarrolladora
     * @param nombre
     * @param jugador
     * @return 
     */
    public java.util.List<Juego> consultarJuegosPropios(String categoria, String desarrolladora, String nombre, Jugador jugador) {

        java.util.List<Juego> resultado = new java.util.ArrayList<>();
        Juego jactual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;
        
        if(categoria.equals("")){
            categoria = "%";
        }
        if(desarrolladora.equals("")){
            desarrolladora = "%";
        }
        
        con = this.getConexion();
        try {
            stmc = con.prepareStatement("select distinct j.id, j.nombre, j.edadrecomendada, j.desarrolladora, d.pais "
                    + "from Juego as j, TenerCategoria as c, Desarrolladora as d, Comprar as co "
                    + "where j.id = c.juego "
                    + "and j.desarrolladora like d.nombre "
                    + "and co.jugador like ? "
                    + "and co.juego = j.id "
                    + "and j.nombre like ? "
                    + "and j.desarrolladora like ? "
                    + "and c.categoria like ? ");
            stmc.setString(1, "%"+jugador.getNick()+"%");
            stmc.setString(2, "%"+nombre+"%");
            stmc.setString(3, desarrolladora);
            stmc.setString(4, categoria);

            rst = stmc.executeQuery();
            while (rst.next()) {
                jactual = new Juego(rst.getInt("id"), rst.getString("nombre"), rst.getInt("edadrecomendada"), null, new Desarrolladora(rst.getString("desarrolladora"), rst.getString("pais")));
                resultado.add(jactual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al buscar los juegos propios");
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
     * Este metodo devuelve los juegos que estan siendo compartidos por un dterminado jugador.
     * @param categoria
     * @param desarrolladora
     * @param nombre
     * @param jugador
     * @return 
     */
    public java.util.List<Juego> consultarJuegosCompartidos(String categoria, String desarrolladora, String nombre, Jugador jugador) {

        java.util.List<Juego> resultado = new java.util.ArrayList<>();
        Juego jactual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;
        
        if(categoria.equals("")){
            categoria = "%";
        }
        if(desarrolladora.equals("")){
            desarrolladora = "%";
        }
        
        con = this.getConexion();
        try {
            stmc = con.prepareStatement("select distinct j.id, j.nombre, j.edadrecomendada, j.desarrolladora, d.pais "
                    + "from Juego as j, TenerCategoria as c, Desarrolladora as d, Comprar as co "
                    + "where j.id = c.juego "
                    + "and j.desarrolladora like d.nombre "
                    + "and co.jugador like ? "
                    + "and co.juego = j.id "
                    + "and j.nombre like ? "
                    + "and j.desarrolladora like ? "
                    + "and c.categoria like ? "
                    + "and co.visibilidad = true ");
            stmc.setString(1, "%"+jugador.getNick()+"%");
            stmc.setString(2, "%"+nombre+"%");
            stmc.setString(3, desarrolladora);
            stmc.setString(4, categoria);

            rst = stmc.executeQuery();
            while (rst.next()) {
                jactual = new Juego(rst.getInt("id"), rst.getString("nombre"), rst.getInt("edadrecomendada"), null, new Desarrolladora(rst.getString("desarrolladora"), rst.getString("pais")));
                resultado.add(jactual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al buscar los juegos compartidos");
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
     * Este metodo le permite a un jugador comprar un unico juego
     * Se añadira una tupla a la relacion comprar con ese jugador y juego.
     * @param jugador
     * @param juego 
     */
    public void comprarJuego(Jugador jugador, Juego juego){
        
        PreparedStatement stmc = null;
       
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("insert into Comprar(jugador,juego) "
            +" values(?,?) ");
            stmc.setString(1, jugador.getNick());
            stmc.setInt(2, juego.getId());
            
            stmc.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, ese juego ya pertenece al jugador");
        } finally {
            try {
                stmc.close();

            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    /**
     * Este metodo permite al jugador comprar varios juegos de una sola vez de forma atomica
     * Se añadiran tantas tuplas a la relación comprar como juegos vaya a comprar el jugador, 
     * con el juego concreto y el jugador.
     * @param jugador
     * @param juegos 
     */
    public void comprarListaJuegos(Jugador jugador, java.util.List<Juego> juegos){
        
        PreparedStatement stmc = null;
       
        Connection con;

        con = this.getConexion();
        
        
        try {
            
        //Desactivamos autocommit 
        con.setAutoCommit(false);
            
            for (Juego juego : juegos) {
                stmc = con.prepareStatement("insert into Comprar(jugador,juego) "
                        +" values(?,?) ");
                stmc.setString(1, jugador.getNick());
                stmc.setInt(2, juego.getId());
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
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error en comprar juegos, intentelo de nuevo");
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
     * Este metodo devuelve los complementos de un determinado juego.
     * @param juego
     * @return 
     */
    public java.util.List<Complemento> obtenerComplementos(Juego juego){
        java.util.List<Complemento> resultado = new java.util.ArrayList<>();
        Complemento comactual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;
        con=this.getConexion();
        try {
            stmc=con.prepareStatement("select nombre, descripcion "
                    + "from complemento as c "
                    + "where juego = ? ");
            stmc.setInt(1, juego.getId());
            rst=stmc.executeQuery();
            while(rst.next()){
                comactual = new Complemento(rst.getString("nombre"), rst.getString("descripcion"), juego);
                resultado.add(comactual);
            }
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, obtencion de complemento fallida");
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
     * Este metodo devuelve todos los logros de un determinado juego.
     * @param juego
     * @return 
     */
    public java.util.List<Logro> obtenerLogros(Juego juego){
        java.util.List<Logro> resultado = new java.util.ArrayList<>();
        Logro logactual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;
        con=this.getConexion();
        try {
            stmc=con.prepareStatement("select nombre, descripcion, puntos "
                    + "from logro as c "
                    + "where juego = ? ");
            stmc.setInt(1, juego.getId());
            rst=stmc.executeQuery();
            while(rst.next()){
                logactual = new Logro(rst.getString("nombre"), rst.getString("descripcion"), rst.getInt("puntos"), juego);
                resultado.add(logactual);
            }
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, obtencion de logros fallida");
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
     * Este metodo devuelve la visibilidad que tiene un logro de un juego conseguido por el jugador.
     * @param jugador
     * @param logro
     * @return 
     */
    public boolean visibilidadLogro(Jugador jugador, Logro logro){
        boolean resultado=false;
        
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;
        con=this.getConexion();
        try {
            stmc=con.prepareStatement("select visibilidad "
                    + "from conseguirlogro as c "
                    + "where juego = ? "
                    + "and logro like ? "
                    + "and jugador like ? ");
            stmc.setInt(1, logro.getJuego().getId());
            stmc.setString(2, logro.getNombre());
            stmc.setString(3, jugador.getNick());
            rst=stmc.executeQuery();
            if(rst.next()){
                resultado = rst.getBoolean("visibilidad");
            }
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, obtencion de visibilidad fallida");
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
     * Este metodo devuelve la visibilidad que tiene un jugador en un juego comprado.
     * @param jugador
     * @param juego
     * @return 
     */
    public boolean visibilidadCompra(Jugador jugador, Juego juego){
        boolean resultado=false;
        
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;
        con=this.getConexion();
        try {
            stmc=con.prepareStatement("select visibilidad "
                    + "from comprar as c "
                    + "where juego = ? "
                    + "and jugador like ? ");
            stmc.setInt(1, juego.getId());
            
            stmc.setString(2, jugador.getNick());
            rst=stmc.executeQuery();
            if(rst.next()){
                resultado = rst.getBoolean("visibilidad");
            }
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, obtencion de visibilidad de compra fallida");
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
     * Este metodo sirve para cambiar la visibilidad de un juego que tiene un jugador
     * para permiter o evitar que sus amigos lo vean
     * Actualiza la tupla de comprar en la que coincidan el jugador y el juego, cambiando la visibilidad
     * a la deseada.
     * @param jugador
     * @param juego
     * @param visibilidad 
     */
    public void cambiarVisibilidadCompra(Jugador jugador, Juego juego, boolean visibilidad){
        Connection con;
        PreparedStatement stmc = null;
        
        con=this.getConexion();
        try{
            stmc=con.prepareStatement("update comprar "
                    + "set visibilidad = ? "
                    + "where jugador like ? "
                    + "and juego = ? ");
            stmc.setBoolean(1, visibilidad);
            stmc.setString(2, jugador.getNick());
            stmc.setInt(3, juego.getId());
            stmc.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, cambiar visibilidad de compra fallida");
        } finally {
            try {
                stmc.close();

            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        
    }
    
    /**
     * Este metodo sirve para cambiar la visibilidad de un logro conseguido por un jugador
     * para evitar/permitir que sus anigos lo vean
     * Actualiza la tupla de conseguirlogroen el que concuerden el jugador, el logro y el juego
     * a la visibilidad deseada.
     * @param jugador
     * @param logro
     * @param visibilidad 
     */
    public void cambiarVisibilidadLogro(Jugador jugador, Logro logro, boolean visibilidad){
        Connection con;
        PreparedStatement stmc = null;
        
        con=this.getConexion();
        try{
            stmc=con.prepareStatement("update conseguirlogro "
                    + "set visibilidad = ? "
                    + "where jugador like ? "
                    + "and logro like ?"
                    + "and juego = ? ");
            stmc.setBoolean(1, visibilidad);
            stmc.setString(2, jugador.getNick());
            stmc.setString(3, logro.getNombre());
            stmc.setInt(4, logro.getJuego().getId());
            stmc.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, cambiar visibilidad de logro fallida");
        } finally {
            try {
                stmc.close();

            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        
    }
    
    /**
     * Este metodo sirve para que un jugador obtenga un nuevo complemento para uno de sus juegos
     * añadiendo en la tabla tenercomplemento ese complemento, su juego y el jugador.
     * @param jugador
     * @param complemento 
     */
    public void obtenerComplementoJugador(Jugador jugador, Complemento complemento){
        Connection con;
        PreparedStatement stmc = null;
        
        con=this.getConexion();
        try{
            stmc=con.prepareStatement("insert into tenerComplemento(juego,jugador,complemento) "
                    + "values(?,?,?)");
            stmc.setInt(1, complemento.getJuego().getId());
            stmc.setString(2, jugador.getNick());
            stmc.setString(3, complemento.getNombre());
            
            stmc.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, obtencion de complemento para jugador fallida, seguramente ya obtenido");
        } finally {
            try {
                stmc.close();

            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        
    }
    
    /**
     * ADMINISTRADOR
     * Este metodo permite a un administrador insertar un nuevo juego en la base de datos
     * Añade una nueva tupla a la relacion juego con los datos introducidos, e introduciendo en la
     * relacion tener categoria todas las categorias seleccionadas.
     * @param nombre
     * @param edadRecomendada
     * @param desarrolladora
     * @param categorias 
     */
    public void anhadirJuego(String nombre, Integer edadRecomendada, String desarrolladora, ArrayList<Categoria> categorias) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = this.getConexion();
        int idJuego = 0;
        
        try {
            con.setAutoCommit(false);
            
            stmt = con.prepareStatement("INSERT INTO Juego (nombre, edadrecomendada, desarrolladora) "
                                      + "VALUES (?, ?, ?)");
            stmt.setString(1, nombre);
            stmt.setInt(2, (int) edadRecomendada);
            stmt.setString(3, desarrolladora);
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("SELECT id FROM Juego WHERE nombre = ? AND edadrecomendada = ? AND desarrolladora = ?");
            stmt.setString(1, nombre);
            stmt.setInt(2, (int) edadRecomendada);
            stmt.setString(3, desarrolladora);
            
            rs = stmt.executeQuery();
            
            while (rs.next())
                idJuego = rs.getInt("id");
            
            for (Categoria c : categorias) {
                stmt = con.prepareStatement("INSERT INTO tenercategoria "
                                          + "VALUES (?, ?)");
                stmt.setString(1, c.getNombre());
                stmt.setInt(2, idJuego); 
                
                stmt.executeUpdate();
            }
            
            con.commit();
            
            this.getFachadaAplicacion().muestraAvisoCorrecto("Juego " + nombre + " añadido correctamente.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error añadiendo el juego.");
        } finally {
            try {
                con.setAutoCommit(true);
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
     * ADMINISTRADOR
     * Este metodo permite a un administrador cambiar los datos de un juego
     * Se modificaran los atributos de la tupla de la tabla juego que coincidan con la id del juego, 
     * y añadiendo o eliminando tuplas de la relacion tenercategoria segun se hayan seleccionado.
     * @param idJuego
     * @param nombre
     * @param edadRecomendada
     * @param desarrolladora
     * @param categorias 
     */
    public void editarJuego(int idJuego, String nombre, Integer edadRecomendada, String desarrolladora, ArrayList<Categoria> categorias) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = this.getConexion();
        
        try {
            con.setAutoCommit(false);
            stmt = con.prepareStatement("UPDATE Juego "
                                      + "SET nombre = ?, edadRecomendada = ?, desarrolladora = ? "
                                      + "WHERE id = ?");
            stmt.setString(1, nombre);
            stmt.setInt(2, (int) edadRecomendada);
            stmt.setString(3, desarrolladora);
            stmt.setInt(4, idJuego);
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("DELETE FROM tenercategoria "
                                      + "WHERE juego = ?");
            stmt.setInt(1, idJuego);
            
            stmt.executeUpdate();
            
            for (Categoria c : categorias) {
                stmt = con.prepareStatement("INSERT INTO tenercategoria "
                                          + "VALUES (?, ?)");
                stmt.setString(1, c.getNombre());
                stmt.setInt(2, idJuego); 
                
                stmt.executeUpdate();
            }
            
            con.commit();
            
            this.getFachadaAplicacion().muestraAvisoCorrecto("Juego " + nombre + " editado correctamente.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error añadiendo el juego.");
        } finally {
            try {
                con.setAutoCommit(true);
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
