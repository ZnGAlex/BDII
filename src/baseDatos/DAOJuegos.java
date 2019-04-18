/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.*;
import aplicacion.Juego;
import aplicacion.Desarrolladora;
import aplicacion.Jugador;

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

        java.util.List<Juego> resultado = new java.util.ArrayList<Juego>();
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

        java.util.List<Juego> resultado = new java.util.ArrayList<Juego>();
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
            stmc.setString(2, juego.getNombre());
            
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
}
    
    
