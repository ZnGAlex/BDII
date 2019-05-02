/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Categoria;
import aplicacion.Desarrolladora;
import aplicacion.Usuario;
import aplicacion.Juego;
import aplicacion.Jugador;
import java.awt.Toolkit;

/**
 *
 * @author alumnogreibd
 */
public class VMisJuegos extends javax.swing.JDialog {
    
    private Usuario usuario;
    java.util.List<Juego> juegos;
    boolean compartido;
    private boolean externo;
    private final aplicacion.FachadaAplicacion fa;
    /**
     * Creates new form VMisJuegos
     * @param parent
     * @param modal
     * @param fa
     */
    
    public void inicializarBoxes(){
         //Inicializar listado de categorias de boxCategorias
        java.util.List<Categoria> categorias = fa.obtenerCategorias();
        boxCategorias.addItem("");
        for(Categoria cat: categorias){
            boxCategorias.addItem(cat.getNombre());
        }
        
        //Inicializar listado de Desarrolladoras de boxDesarrolladora
        java.util.List<Desarrolladora> desarrolladoras = fa.obtenerDesarrolladoras();
        boxDesarrolladora.addItem("");
        for(Desarrolladora des: desarrolladoras){
            boxDesarrolladora.addItem(des.getNombre());
        }
    }
    
    public VMisJuegos(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Usuario usuario, boolean externo) {
        super(parent, modal);
        //Almacenamos una referencia a la fachada de aplicación para poder tener todas las funcionalidades disponibles
        this.fa = fa;
        this.usuario = usuario;
        
        initComponents();
        //Centramos en pantalla la ventana, para evitar que aparezca en la esquina superior izquierda
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 -this.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 -this.getHeight()/2);
        //Hacemos la ventana visible para el usuario
        this.inicializarBoxes();
        btnJugar.setEnabled(false);
        btnVerDetalles.setEnabled(false);
        btnVerLogros.setEnabled(false);
        btnCompartir.setEnabled(false);
        
        this.externo = externo;
        if(externo){
            btnJugar.setVisible(false);
            btnCompartir.setVisible(false);
            btnVerDetalles.setVisible(false);
            btnVerLogros.setVisible(false);
        }
        
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
        etiquetaCategoria = new javax.swing.JLabel();
        boxCategorias = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        boxDesarrolladora = new javax.swing.JComboBox();
        btnJugar = new javax.swing.JButton();
        btnVerDetalles = new javax.swing.JButton();
        btnVerLogros = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJuegos = new javax.swing.JTable();
        btnCompartir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaCategoria.setText("Categoría:");

        jLabel1.setText("Desarrolladora:");

        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        btnVerDetalles.setText("Ver detalles");
        btnVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetallesActionPerformed(evt);
            }
        });

        btnVerLogros.setText("Ver logros");
        btnVerLogros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerLogrosActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaJuegos.setModel(new ModeloTablaJuegos());
        tablaJuegos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaJuegosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaJuegos);

        btnCompartir.setText("Compartir");
        btnCompartir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompartirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etiquetaCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxDesarrolladora, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnJugar)
                                .addGap(59, 59, 59)
                                .addComponent(btnVerDetalles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerLogros))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(btnBuscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnCompartir)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCategoria)
                    .addComponent(boxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(boxDesarrolladora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVerDetalles)
                    .addComponent(btnJugar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVerLogros)
                        .addComponent(btnCompartir)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String categoria=(String)boxCategorias.getSelectedItem();
        String desarrolladora=(String) boxDesarrolladora.getSelectedItem();
        if(!externo){
            juegos = fa.consultarJuegosPropios(categoria,desarrolladora, CampoNombre.getText(), (Jugador)this.usuario);
        } else {
            juegos = fa.consultarJuegosCompartidos(categoria,desarrolladora,CampoNombre.getText(),(Jugador)this.usuario);
        }
        ((ModeloTablaJuegos)tablaJuegos.getModel()).setFilas(juegos);
        btnJugar.setEnabled(false);
        btnVerDetalles.setEnabled(false);
        btnVerLogros.setEnabled(false);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        // TODO add your handling code here:
        Juego juego=((ModeloTablaJuegos)tablaJuegos.getModel()).getJuegoAt(tablaJuegos.getSelectedRow());
        fa.jugar((Jugador)this.usuario,juego);
        fa.muestraJugar((Jugador)this.usuario, juego);
        
    }//GEN-LAST:event_btnJugarActionPerformed

    private void tablaJuegosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaJuegosMouseClicked
        // TODO add your handling code here:
        btnJugar.setEnabled(true);
        btnVerDetalles.setEnabled(true);
        btnVerLogros.setEnabled(true);
        btnCompartir.setEnabled(true);
        Juego juego=((ModeloTablaJuegos)tablaJuegos.getModel()).getJuegoAt(tablaJuegos.getSelectedRow());
        compartido = fa.visibilidadCompra((Jugador)this.usuario, juego);
        if(compartido == true){
            btnCompartir.setText("No compartir");
        }
        else{
            btnCompartir.setText("Compartir");
        }
    }//GEN-LAST:event_tablaJuegosMouseClicked

    private void btnVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetallesActionPerformed
        // TODO add your handling code here:
        fa.muestraVVerDetalles(((ModeloTablaJuegos)tablaJuegos.getModel()).getJuegoAt(tablaJuegos.getSelectedRow()), (Jugador)this.usuario);
    }//GEN-LAST:event_btnVerDetallesActionPerformed

    private void btnVerLogrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerLogrosActionPerformed
        // TODO add your handling code here:
        Juego juego = ((ModeloTablaJuegos)tablaJuegos.getModel()).getJuegoAt(tablaJuegos.getSelectedRow());
        fa.muestraVVerLogros(juego, (Jugador)this.usuario);
    }//GEN-LAST:event_btnVerLogrosActionPerformed

    private void btnCompartirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompartirActionPerformed
            // TODO add your handling code here:
        Juego juego = ((ModeloTablaJuegos)tablaJuegos.getModel()).getJuegoAt(tablaJuegos.getSelectedRow());
        
        if(compartido == true){
            compartido=false;
            btnCompartir.setText("No compartir");
        }
        else{
            compartido=true;
            btnCompartir.setText("Compartir");
            
        }
        fa.cambiarVisibilidadCompra((Jugador)this.usuario, juego, compartido);
    }//GEN-LAST:event_btnCompartirActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JComboBox boxCategorias;
    private javax.swing.JComboBox boxDesarrolladora;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCompartir;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JButton btnVerLogros;
    private javax.swing.JLabel etiquetaCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaJuegos;
    // End of variables declaration//GEN-END:variables
}
