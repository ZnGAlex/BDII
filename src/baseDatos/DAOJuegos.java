/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.*;

/**
 *
 * @author Alex
 */

public class DAOJuegos  extends AbstractDAO{
    public DAOJuegos(Connection con, aplicacion.FachadaAplicacion fa){
        super.setConexion(con);
        super.setFachadaAplicacion(fa);
    }
}

