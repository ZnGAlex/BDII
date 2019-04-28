/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Complemento;
import java.sql.*;
import aplicacion.Juego;
import aplicacion.Desarrolladora;
import aplicacion.Jugador;
import aplicacion.Logro;

/**
 *
 * @author Alex
 */

public class DAOJuegos extends AbstractDAO {

    public DAOJuegos(Connection con, aplicacion.FachadaAplicacion fa) {
        super.setConexion(con);
        super.setFachadaAplicacion(fa);
    }

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
    //Esta se podria mezclar con la anterior
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
    
    //Comprar una lista de juegos de forma atómica
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
}
    
    
