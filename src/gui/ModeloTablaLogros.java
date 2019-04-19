/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Logro;
import javax.swing.table.*;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaLogros extends AbstractTableModel{
    private java.util.List<Logro> logros;

    public ModeloTablaLogros(){
        this.logros=new java.util.ArrayList<Logro>();
    }

    public int getColumnCount (){
        return 2;
    }

    public int getRowCount(){
        return logros.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Logro"; break;
            case 1: nombre= "Puntos"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.Integer.class; break;
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
            case 0: resultado= logros.get(row).getNombre(); break;
            case 1: resultado= logros.get(row).getPuntos(); break;
            case 2: resultado= logros.get(row).getDescripcion(); break;
            
        }
        return resultado;
    }
    
    public Logro getJuegoAt(int row){
        return logros.get(row);
    }

    public void setFilas(java.util.List<Logro> logros){
        this.logros=logros;
        fireTableDataChanged();
    }

    public Logro obtenerLogro(int i){
        return this.logros.get(i);
    }
}
