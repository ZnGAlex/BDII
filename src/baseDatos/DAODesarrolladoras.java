/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Desarrolladora;
import java.sql.*;

/**
 *
 * @author Usuario
 */
public class DAODesarrolladoras extends AbstractDAO{
    
    public DAODesarrolladoras(Connection con, aplicacion.FachadaAplicacion fa) {
        super.setConexion(con);
        super.setFachadaAplicacion(fa);
    }
    
    public java.util.List<Desarrolladora> obtenerDesarrolladoras() {
        java.util.List<Desarrolladora> resultado = new java.util.ArrayList<>();
        Desarrolladora dactual;
        PreparedStatement stmc = null;
        ResultSet rst;
        Connection con;

        con = this.getConexion();
        try {
            stmc = con.prepareStatement("select * from Desarrolladora");;

            rst = stmc.executeQuery();
            while (rst.next()) {
                dactual = new Desarrolladora(rst.getString("nombre"), rst.getString("pais"));
                resultado.add(dactual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraAvisoCorrecto("Error al obtener las desarrolladoras");
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
