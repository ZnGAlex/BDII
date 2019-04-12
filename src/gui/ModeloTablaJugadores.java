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
public class ModeloTablaJugadores extends AbstractTableModel{
    private java.util.List<Jugador> jugadores;

    public ModeloTablaJugadores(){
        this.jugadores=new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount (){
        return 1;
    }

    @Override
    public int getRowCount(){
        return jugadores.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
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
            case 0: resultado= jugadores.get(row).getNick(); break;
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
