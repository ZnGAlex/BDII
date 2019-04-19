/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Complemento;
import javax.swing.table.*;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaComplementos  extends AbstractTableModel{
    private java.util.List<Complemento> complementos;

    public ModeloTablaComplementos(){
        this.complementos=new java.util.ArrayList<Complemento>();
    }

    public int getColumnCount (){
        return 1;
    }

    public int getRowCount(){
        return complementos.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Complemento"; break;
            
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

    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= complementos.get(row).getNombre(); break;
            case 1: resultado= complementos.get(row).getDescripcion(); break;
            
        }
        return resultado;
    }
    
    public Complemento getJuegoAt(int row){
        return complementos.get(row);
    }

    public void setFilas(java.util.List<Complemento> complementos){
        this.complementos=complementos;
        fireTableDataChanged();
    }

    public Complemento obtenerComplemento(int i){
        return this.complementos.get(i);
    }
}
