/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.Juego;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaJuegos extends AbstractTableModel{
    private java.util.List<Juego> juegos;

    public ModeloTablaJuegos(){
        this.juegos=new java.util.ArrayList<Juego>();
    }

    public int getColumnCount (){
        return 3;
    }

    public int getRowCount(){
        return juegos.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Juego"; break;
            case 1: nombre= "Edad"; break;
            case 2: nombre= "Desarrolladora"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.Integer.class; break;
            case 2: clase=java.lang.String.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= juegos.get(row).getNombre(); break;
            case 1: resultado= juegos.get(row).getEdadRecomendada(); break;
            case 2: resultado=juegos.get(row).getDesarrolladora().getNombre();break;
            case 3: resultado=juegos.get(row).getId();break;
        }
        return resultado;
    }
    
    public Juego getJuegoAt(int row){
        return juegos.get(row);
    }

    public void setFilas(java.util.List<Juego> juegos){
        this.juegos=juegos;
        fireTableDataChanged();
    }

    public Juego obtenerLibro(int i){
        return this.juegos.get(i);
    }

}
