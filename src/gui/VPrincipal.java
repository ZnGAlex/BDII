package gui;

import aplicacion.*;
public class VPrincipal extends javax.swing.JFrame {
  
    FachadaAplicacion fa;
    Usuario usuario;
    java.util.List<Juego> juegos;
    java.util.List<Juego> carrito;
    
    /** Creates new form VPrincipal */
    public VPrincipal(aplicacion.FachadaAplicacion fa) {
        this.fa=fa;
        initComponents();
        btnAnadir.setEnabled(false);
        btnDetalles.setEnabled(false);
    }
    
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
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        btnAmigos.setText("Mis amigos");
        btnAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmigosActionPerformed(evt);
            }
        });

        btnJuegos.setText("Mis juegos");
        btnJuegos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuegosActionPerformed(evt);
            }
        });

        etiquetaCarrito.setText("0");

        btnCarrito.setText("Carrito");
        btnCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarritoActionPerformed(evt);
            }
        });

        tablaJuegos.setModel(new ModeloTablaJuegos());
        tablaJuegos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaJuegosMouseClicked(evt);
            }
        });
        tablaJuegos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaJuegosKeyPressed(evt);
            }
        });
        scrollPaneJuegos.setViewportView(tablaJuegos);

        etiquetaCategorias.setText("Categorías");

        etiquetaDesarrolladora.setText("Desarrolladora");

        boxDesarrolladora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDesarrolladoraActionPerformed(evt);
            }
        });

        etiquetaNombre.setText("Nombre");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnDetalles.setText("Ver detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });

        btnAnadir.setText("Añadir al Carrito");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

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
                                .addComponent(boxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etiquetaDesarrolladora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxDesarrolladora, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

   
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        // TODO add your handling code here:
        fa.muestraVVerDetalles(((ModeloTablaJuegos)tablaJuegos.getModel()).getJuegoAt(tablaJuegos.getSelectedRow()));
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void boxDesarrolladoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDesarrolladoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxDesarrolladoraActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        juegos = fa.consultarJuegosTienda((String)boxCategorias.getSelectedItem(),(String) boxDesarrolladora.getSelectedItem(), textoNombre.getText());
        ((ModeloTablaJuegos)tablaJuegos.getModel()).setFilas(juegos);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaJuegosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaJuegosKeyPressed
        tablaJuegosMouseClicked(null);
    }//GEN-LAST:event_tablaJuegosKeyPressed

    private void tablaJuegosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaJuegosMouseClicked
        int row = tablaJuegos.getSelectedRow();
        Integer id = (Integer) ((ModeloTablaJuegos)tablaJuegos.getModel()).getValueAt(row, 4);
        
        btnAnadir.setEnabled(!fa.usuarioTieneJuego(usuario.getNick(),id));
        btnDetalles.setEnabled(true);
    }//GEN-LAST:event_tablaJuegosMouseClicked

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        // TODO add your handling code here:
        carrito.add(((ModeloTablaJuegos)tablaJuegos.getModel()).getJuegoAt(tablaJuegos.getSelectedRow()));
        Integer numero = Integer.parseInt(etiquetaCarrito.getText());
        numero++;
        etiquetaCarrito.setText(numero.toString());
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        // TODO add your handling code here:
        fa.muestraVMiPerfil(usuario);
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmigosActionPerformed
        // TODO add your handling code here:
        fa.muestraVMisAmigos(usuario);
    }//GEN-LAST:event_btnAmigosActionPerformed

    private void btnJuegosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJuegosActionPerformed
        // TODO add your handling code here:
        fa.muestraVMisJuegos(usuario);
    }//GEN-LAST:event_btnJuegosActionPerformed

    private void btnCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarritoActionPerformed
        // TODO add your handling code here:
        fa.muestraVCarrito(usuario,carrito);
    }//GEN-LAST:event_btnCarritoActionPerformed

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
