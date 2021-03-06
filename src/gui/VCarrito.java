package gui;

import aplicacion.Juego;
import aplicacion.Jugador;
import aplicacion.Usuario;
import java.awt.Toolkit;

/**
 *
 * @author alumnogreibd
 */
public class VCarrito extends javax.swing.JDialog {
    private final VPrincipal vPrincipal;
    private final Usuario usuario;
    private java.util.List<Juego> juegos;
    
    private final aplicacion.FachadaAplicacion fa;
    /**
     * Creates new form VCarrito
     * @param VPrincipal
     * @param parent
     * @param modal
     * @param fa
     * @param usuario
     * @param juegos
     */
    public VCarrito(gui.VPrincipal VPrincipal, java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Usuario usuario, java.util.List<Juego> juegos) {
        
        super(parent, modal);
        //Almacenamos una referencia a la fachada de aplicación para poder tener todas las funcionalidades disponibles
        this.fa = fa;    
        this.usuario = usuario;
        this.juegos = juegos;
        this.vPrincipal = VPrincipal;
        initComponents();
        
        ((ModeloTablaJuegos)tablaJuegos.getModel()).setFilas(juegos);
        
        //Centramos en pantalla la ventana, para evitar que aparezca en la esquina superior izquierda
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 -this.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 -this.getHeight()/2);
        //Hacemos la ventana visible para el usuario
        this.setVisible(true);  
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent w) {
                salir();
            }
        });
        
    }
    
    //Con esta función los cambios que realizamos en esta ventana son transmitidos a la ventana princpal
    public void salir(){
        vPrincipal.actualizarCarrito(this.juegos);
        this.dispose();
    }
    
    //Vaciamos el carrito y repintamos la tabla para que se vea vacío
    public void vaciarCarrito(){
        this.juegos.clear();
        ((ModeloTablaJuegos)tablaJuegos.getModel()).setFilas(juegos);
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
        btnVaciarCarrito = new javax.swing.JButton();
        btnEliminarDelCarrito = new javax.swing.JButton();
        btnRealizarCompra = new javax.swing.JButton();
        btnVerDetalles = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJuegos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnVaciarCarrito.setText("Vaciar carrito");
        btnVaciarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarCarritoActionPerformed(evt);
            }
        });

        btnEliminarDelCarrito.setText("Eliminar del Carrito");
        btnEliminarDelCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDelCarritoActionPerformed(evt);
            }
        });

        btnRealizarCompra.setText("Realizar Compra");
        btnRealizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarCompraActionPerformed(evt);
            }
        });

        btnVerDetalles.setText("Ver Detalles");
        btnVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetallesActionPerformed(evt);
            }
        });

        tablaJuegos.setModel(new ModeloTablaJuegos());
        jScrollPane1.setViewportView(tablaJuegos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVaciarCarrito)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnEliminarDelCarrito)
                            .addGap(83, 83, 83)
                            .addComponent(btnRealizarCompra)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerDetalles))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnVaciarCarrito)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerDetalles)
                    .addComponent(btnRealizarCompra)
                    .addComponent(btnEliminarDelCarrito))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVaciarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarCarritoActionPerformed
            vaciarCarrito();
    }//GEN-LAST:event_btnVaciarCarritoActionPerformed

    private void btnEliminarDelCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDelCarritoActionPerformed
        Juego j = ((ModeloTablaJuegos)tablaJuegos.getModel()).getJuegoAt(tablaJuegos.getSelectedRow()); //Sacamos el juego que tiene el usuario seleccionado
        this.juegos.remove(j);      //Eliminamos el juego de la tabla
        ((ModeloTablaJuegos)tablaJuegos.getModel()).setFilas(juegos);   //Rehacemos la lista que enseñamos sin el juego seleccionado
    }//GEN-LAST:event_btnEliminarDelCarritoActionPerformed

    private void btnVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetallesActionPerformed
        fa.muestraVVerDetalles(((ModeloTablaJuegos)tablaJuegos.getModel()).getJuegoAt(tablaJuegos.getSelectedRow()), null);
    }//GEN-LAST:event_btnVerDetallesActionPerformed

    private void btnRealizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarCompraActionPerformed

        fa.comprarListaJuegos((Jugador)this.usuario, this.juegos);  //Realizamos de forma atómica la compra de todos los juegos de la lista
        vaciarCarrito();        //Vaciamos el carrito
        salir();                //Cerramos la ventana actualizando en la ventana principal la lista del carrito
    }//GEN-LAST:event_btnRealizarCompraActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarDelCarrito;
    private javax.swing.JButton btnRealizarCompra;
    private javax.swing.JButton btnVaciarCarrito;
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaJuegos;
    // End of variables declaration//GEN-END:variables
}
