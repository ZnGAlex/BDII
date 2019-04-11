/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.*;
import aplicacion.Juego;
import aplicacion.Desarrolladora;
/**
 *
 * @author Alex
 */

public class DAOJuegos  extends AbstractDAO{
    public DAOJuegos(Connection con, aplicacion.FachadaAplicacion fa){
        super.setConexion(con);
        super.setFachadaAplicacion(fa);
    }
    
    public java.util.List<Juego> consultarJuegosTienda(String categoria, String desarrolladora, String nombre){
        
        java.util.List<Juego> resultado = new java.util.ArrayList<Juego>();
        Juego jactual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;
        
        con=this.getConexion();
        try{
        stmc= con.prepareStatement("select j.id, j.nombre, j.edadrecomendada, j.desarrolladora, j.pais"
        +"from Juego as j, TenerCategoria as c, Desarrolladora as d"
        +"where j.nombre like c.juego "
        +"and j.desarrolladora like d.nombre "
        +"and j.nombre like %?% "
        +"and j.desarrolladora like ? "
        +"and c.categoria like ?");
        stmc.setString(1, nombre);
        stmc.setString(2, desarrolladora);
        stmc.setString(3, categoria);
        
        rst=stmc.executeQuery();
        while(rst.next()){
            jactual = new Juego(rst.getInt("j.id"), rst.getString("j.nombre"), rst.getInt("j.edadrecomendada"), null, new Desarrolladora(rst.getString("desarrolladora"), rst.getString("pais")));
        }
        
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al buscar en la tienda");
        }
        return resultado;
    }
}

