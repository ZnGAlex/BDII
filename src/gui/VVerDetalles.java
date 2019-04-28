/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Complemento;
import aplicacion.Juego;
import aplicacion.Categoria;
import java.awt.Toolkit;
import aplicacion.Jugador;

/**
 *
 * @author alumnogreibd
 */
public class VVerDetalles extends javax.swing.JDialog {
    
    private Juego juego;
    private java.util.List<Complemento> complementos;
    private java.util.List<Categoria> categorias;
    private Jugador jugador;
    
    //private final VLibro padre;
    private final aplicacion.FachadaAplicacion fa;
    /**
     * Creates new form VVerDetalles
     * @param parent
     * @param modal
     * @param fa
     * @param juego
     */
    public VVerDetalles(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Juego juego, Jugador jugador) {
        
        super(parent, modal);
        //Almacenamos una referencia a la fachada de aplicación para poder tener todas las funcionalidades disponibles
        this.fa = fa;
        this.juego = juego;
        if(jugador!=null) this.jugador=jugador;
        else this.jugador = null;
        initComponents();
        //Centramos en pantalla la ventana, para evitar que aparezca en la esquina superior izquierda
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 -this.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 -this.getHeight()/2);
        //Hacemos la ventana visible para el usuario
        categorias = fa.obtenerCategoriasJuego(juego);
        ((ModeloTablaCategorias)tablaCategorias.getModel()).setFilas(categorias);
        complementos = fa.obtenerComplementos(juego);
        ((ModeloTablaComplementos)tablaComplementos.getModel()).setFilas(complementos);
        
        this.setVisible(true);  
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etiquetaComplementos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComplementos = new javax.swing.JTable();
        btnAdquirir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        DescripcionComplemento = new javax.swing.JTextArea();
        etiquetaDescripcionComplemento = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCategorias = new javax.swing.JTable();
        etiquetaDescripcionCategoria = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DescripcionCategorias = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaComplementos.setText("Complementos:");

        tablaComplementos.setModel(new ModeloTablaComplementos());
        tablaComplementos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaComplementosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaComplementos);

        btnAdquirir.setText("Adquirir");
        btnAdquirir.setEnabled(false);
        btnAdquirir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdquirirActionPerformed(evt);
            }
        });

        DescripcionComplemento.setColumns(20);
        DescripcionComplemento.setRows(5);
        jScrollPane2.setViewportView(DescripcionComplemento);

        etiquetaDescripcionComplemento.setText("Descripción:");

        jLabel1.setText("Categorías:");

        tablaCategorias.setModel(new ModeloTablaCategorias());
        tablaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaCategorias);

        etiquetaDescripcionCategoria.setText("Descripción:");

        DescripcionCategorias.setColumns(20);
        DescripcionCategorias.setRows(5);
        jScrollPane4.setViewportView(DescripcionCategorias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaComplementos))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                                .addComponent(btnAdquirir)
                                .addGap(201, 201, 201))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                                    .addComponent(etiquetaDescripcionComplemento, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addComponent(etiquetaDescripcionCategoria, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(etiquetaComplementos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnAdquirir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaDescripcionComplemento)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(etiquetaDescripcionCategoria)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaComplementosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaComplementosMouseClicked
        // TODO add your handling code here:
        String descripcion = ((ModeloTablaComplementos)tablaComplementos.getModel()).getJuegoAt(tablaComplementos.getSelectedRow()).getDescripcion();
        this.DescripcionComplemento.setText(descripcion);
        if(jugador!=null) btnAdquirir.setEnabled(true);
    }//GEN-LAST:event_tablaComplementosMouseClicked

    private void tablaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCategoriasMouseClicked
        // TODO add your handling code here:
        String descripcion = ((ModeloTablaCategorias)tablaCategorias.getModel()).getJuegoAt(tablaCategorias.getSelectedRow()).getDescripcion();
        this.DescripcionCategorias.setText(descripcion);
    }//GEN-LAST:event_tablaCategoriasMouseClicked

    private void btnAdquirirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdquirirActionPerformed
        // TODO add your handling code here:
        Complemento c = ((ModeloTablaComplementos)tablaComplementos.getModel()).getJuegoAt(tablaComplementos.getSelectedRow());
        //fa.obtenerComplementoJugador(this., c);
    }//GEN-LAST:event_btnAdquirirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea DescripcionCategorias;
    private javax.swing.JTextArea DescripcionComplemento;
    private javax.swing.JButton btnAdquirir;
    private javax.swing.JLabel etiquetaComplementos;
    private javax.swing.JLabel etiquetaDescripcionCategoria;
    private javax.swing.JLabel etiquetaDescripcionComplemento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaCategorias;
    private javax.swing.JTable tablaComplementos;
    // End of variables declaration//GEN-END:variables

public void buscarCategorias(){
    categorias = fa.obtenerCategoriasJuego(juego);
    ((ModeloTablaCategorias)tablaCategorias.getModel()).setFilas(categorias);
}

public void buscarComplementos(){
    complementos = fa.obtenerComplementos(juego);
    ((ModeloTablaComplementos)tablaComplementos.getModel()).setFilas(complementos);
}

}
