/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Categoria;
import aplicacion.Juego;
import java.sql.*;

/**
 *
 * @author Usuario
 */
class DAOCategorias extends AbstractDAO{
    
    public DAOCategorias(Connection con, aplicacion.FachadaAplicacion fa) {
        super.setConexion(con);
        super.setFachadaAplicacion(fa);
    }
    
    /**
     * Consulta todas las categorías existentes en la BD
     * @return listado de categorías
     */
    public java.util.List<Categoria> obtenerCategorias() {

        java.util.List<Categoria> resultado = new java.util.ArrayList<>();
        Categoria catActual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("select * from Categoria");;

            rst = stmc.executeQuery();
            while (rst.next()) {
                catActual = new Categoria(rst.getString("nombre"), rst.getString("descripcion"));
                resultado.add(catActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al obtener las categorias");
        } finally {
            try {
                stmc.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public java.util.List<Categoria> obtenerCategoriasJuego(Juego juego){
        java.util.List<Categoria> resultado = new java.util.ArrayList<Categoria>();
        Categoria catactual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;
        con=this.getConexion();
        try {
            stmc=con.prepareStatement("select c.nombre, c.descripcion "
                    + "from categoria as c, tenercategoria as t "
                    + "where c.nombre = t.categoria "
                    + "and t.juego = ? ");
            stmc.setInt(0, juego.getId());
            rst=stmc.executeQuery();
            while(rst.next()){
                catactual = new Categoria(rst.getString("nombre"), rst.getString("descripcion"));
                resultado.add(catactual);
            }
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error, obtencion de categorias fallida");
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
