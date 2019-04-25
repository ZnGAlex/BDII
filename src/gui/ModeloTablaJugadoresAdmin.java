/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.Jugador;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaJugadoresAdmin extends AbstractTableModel{
    private java.util.List<Jugador> jugadores;

    public ModeloTablaJugadoresAdmin(){
        this.jugadores=new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount (){
        return 4;
    }

    @Override
    public int getRowCount(){
        return jugadores.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre = "Nick"; break;
            case 1: nombre = "Correo"; break;
            case 2: nombre = "Fecha Nac."; break;
            case 3: nombre = "Baneado"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase = java.lang.String.class; break;
            case 1: clase = java.lang.String.class; break;
            case 2: clase = java.lang.String.class; break;
            case 3: clase = java.lang.String.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    @Override
    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado = jugadores.get(row).getNick(); break;
            case 1: resultado = jugadores.get(row).getCorreo(); break;
            case 2: resultado = jugadores.get(row).getFechaNacimiento(); break;
            case 3: resultado = jugadores.get(row).getBaneado(); break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Jugador> jugadores){
        this.jugadores = jugadores;
        fireTableDataChanged();
    }

    public Jugador obtenerJugador(int i){
        return this.jugadores.get(i);
    }

}