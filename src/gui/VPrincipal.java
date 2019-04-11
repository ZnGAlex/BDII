package gui;


public class VPrincipal extends javax.swing.JFrame {
  
    aplicacion.FachadaAplicacion fa;
    ModeloTablaJuegos mtJuegos;
    
    /** Creates new form VPrincipal */
    public VPrincipal(aplicacion.FachadaAplicacion fa) {
        this.fa=fa;
        initComponents();
    }
    
    public VPrincipal(aplicacion.FachadaAplicacion fa,int ELIMINARESTO) {
        this.fa=fa;
        initComponents();
        
        this.mtJuegos = new ModeloTablaJuegos();
        tablaJuegos.setModel(mtJuegos);
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupAdministracion = new javax.swing.JPopupMenu();
        btnPerfil = new javax.swing.JButton();
        btnAmigos = new javax.swing.JButton();
        btnJuegos = new javax.swing.JButton();
        etiquetaCarrito = new javax.swing.JLabel();
        btnCarrito = new javax.swing.JButton();
        scrollPaneJuegos = new javax.swing.JScrollPane();
        tablaJuegos = new javax.swing.JTable();
        etiquetaCategorias = new javax.swing.JLabel();
        boxCategorias = new javax.swing.JComboBox();
        etiquetaDesarrolladora = new javax.swing.JLabel();
        boxDesarrolladora = new javax.swing.JComboBox();
        etiquetaNombre = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnDetalles = new javax.swing.JButton();
        btnAnadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tienda de Videojuegos");
        setName("vPrincipal"); // NOI18N
        setResizable(false);

        btnPerfil.setText("Mi perfil");

        btnAmigos.setText("Mis amigos");

        btnJuegos.setText("Mis juegos");

        etiquetaCarrito.setText("0");

        btnCarrito.setText("Carrito");

        tablaJuegos.setModel(new ModeloTablaJuegos());
        scrollPaneJuegos.setViewportView(tablaJuegos);

        etiquetaCategorias.setText("Categorías");

        boxCategorias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        etiquetaDesarrolladora.setText("Desarrolladora");

        boxDesarrolladora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        etiquetaNombre.setText("Nombre");

        btnBuscar.setText("Buscar");

        btnDetalles.setText("Ver detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        btnAnadir.setText("Añadir al Carrito");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAnadir)
                                .addGap(18, 18, 18)
                                .addComponent(btnDetalles))
                            .addComponent(scrollPaneJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(0, 100, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaCategorias)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(etiquetaDesarrolladora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxDesarrolladora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(etiquetaNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoNombre))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnPerfil)
                                .addGap(18, 18, 18)
                                .addComponent(btnAmigos)
                                .addGap(18, 18, 18)
                                .addComponent(btnJuegos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCarrito)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiquetaCarrito)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPerfil)
                    .addComponent(btnAmigos)
                    .addComponent(btnJuegos)
                    .addComponent(etiquetaCarrito)
                    .addComponent(btnCarrito))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCategorias)
                    .addComponent(boxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaDesarrolladora)
                    .addComponent(boxDesarrolladora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaNombre)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalles)
                    .addComponent(btnAnadir))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Biblioteca Informática");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetallesActionPerformed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxCategorias;
    private javax.swing.JComboBox boxDesarrolladora;
    private javax.swing.JButton btnAmigos;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCarrito;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnJuegos;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JLabel etiquetaCarrito;
    private javax.swing.JLabel etiquetaCategorias;
    private javax.swing.JLabel etiquetaDesarrolladora;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JPopupMenu popupAdministracion;
    private javax.swing.JScrollPane scrollPaneJuegos;
    private javax.swing.JTable tablaJuegos;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables

}
