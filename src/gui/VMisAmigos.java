/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Jugador;
import aplicacion.Usuario;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author alumnogreibd
 */
public class VMisAmigos extends javax.swing.JDialog {
    private Usuario usuario;
    
    private final aplicacion.FachadaAplicacion fa;
    /**
     * Creates new form VMisAmigos
     * @param parent
     * @param modal
     * @param fa
     */
    public VMisAmigos(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Usuario usuario) {
        
        super(parent, modal);
        //Almacenamos una referencia a la fachada de aplicación para poder tener todas las funcionalidades disponibles
        this.fa = fa;       
        this.usuario = usuario;
        initComponents();
        //Centramos en pantalla la ventana, para evitar que aparezca en la esquina superior izquierda
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 -this.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 -this.getHeight()/2);
        this.btnHacerAmigo.setEnabled(false);
        
        this.btnBloquear.setEnabled(false);
        this.btnHacerAmigo.setEnabled(false);
        this.btnVerInfoAmigo.setEnabled(false);
        //Hacemos la ventana visible para el usuario
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
        etiquetaNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSelectorAmigosTotal = new javax.swing.JToggleButton();
        ScrollTablaUsuarios = new javax.swing.JScrollPane();
        tablaJugadores = new javax.swing.JTable();
        btnBloquear = new javax.swing.JButton();
        btnVerInfoAmigo = new javax.swing.JButton();
        btnVerBloqueados = new javax.swing.JButton();
        btnHacerAmigo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaNombre.setText("Nombre:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSelectorAmigosTotal.setText("Mis Amigos");
        btnSelectorAmigosTotal.setToolTipText("");
        btnSelectorAmigosTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectorAmigosTotalActionPerformed(evt);
            }
        });

        tablaJugadores.setModel(new ModeloTablaJugadores());
        tablaJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaJugadoresMouseClicked(evt);
            }
        });
        tablaJugadores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaJugadoresKeyReleased(evt);
            }
        });
        ScrollTablaUsuarios.setViewportView(tablaJugadores);

        btnBloquear.setText("Bloquear");
        btnBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloquearActionPerformed(evt);
            }
        });

        btnVerInfoAmigo.setText("Ver info amigo");
        btnVerInfoAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoAmigoActionPerformed(evt);
            }
        });

        btnVerBloqueados.setText("Ver Bloqueados");
        btnVerBloqueados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerBloqueadosActionPerformed(evt);
            }
        });

        btnHacerAmigo.setText("Hacer amigo");
        btnHacerAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHacerAmigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etiquetaNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnBuscar))
                    .addComponent(ScrollTablaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBloquear)
                    .addComponent(btnVerInfoAmigo)
                    .addComponent(btnVerBloqueados)
                    .addComponent(btnHacerAmigo)
                    .addComponent(btnSelectorAmigosTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnSelectorAmigosTotal))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ScrollTablaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnBloquear)
                        .addGap(53, 53, 53)
                        .addComponent(btnVerInfoAmigo)
                        .addGap(55, 55, 55)
                        .addComponent(btnVerBloqueados)
                        .addGap(51, 51, 51)
                        .addComponent(btnHacerAmigo)))
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void btnSelectorAmigosTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectorAmigosTotalActionPerformed
        ((ModeloTablaJugadores) this.tablaJugadores.getModel()).setFilas(new ArrayList<>());
        this.btnVerInfoAmigo.setEnabled(false);
        this.btnHacerAmigo.setEnabled(false);
        this.btnBloquear.setEnabled(false);
        ((ModeloTablaJugadores)tablaJugadores.getModel()).setFilas(new ArrayList<>());
        
        if (this.btnSelectorAmigosTotal.isSelected()){ //TODOS LOS USUARIOS
            this.btnSelectorAmigosTotal.setText("Todos Usuarios");

        }else{ //AMIGOS
            this.btnSelectorAmigosTotal.setText("Mis Amigos");
        }
    }//GEN-LAST:event_btnSelectorAmigosTotalActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String nombre = this.campoNombre.getText();
        if(this.btnSelectorAmigosTotal.isSelected()){  //TODOS LOS USUARIOS
            ((ModeloTablaJugadores)this.tablaJugadores.getModel()).setFilas(fa.obtenerJugadores((Jugador)usuario, nombre));
        } else { //SOLO AMIGOS
            ((ModeloTablaJugadores)this.tablaJugadores.getModel()).setFilas(fa.obtenerAmigos((Jugador)usuario, nombre));
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaJugadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaJugadoresMouseClicked
        // TODO add your handling code here:
        int row = tablaJugadores.getSelectedRow();
        Jugador jugSelec = ((ModeloTablaJugadores)tablaJugadores.getModel()).obtenerJugador(row);
        
        boolean yoBloqueo = fa.estaBloqueado((Jugador)usuario,jugSelec);
        boolean elBloquea = fa.estaBloqueado(jugSelec,(Jugador)usuario);
        boolean esAmigo = fa.sonAmigos((Jugador)usuario,jugSelec);
        
        if (this.btnSelectorAmigosTotal.isSelected()){ //Todos los usuarios
            this.btnHacerAmigo.setEnabled(true);
            
            this.btnBloquear.setEnabled(!yoBloqueo);
            this.btnHacerAmigo.setEnabled(!yoBloqueo && !elBloquea && !esAmigo);
            this.btnVerInfoAmigo.setEnabled(esAmigo);
            
        }else{ //Amigos
            this.btnVerInfoAmigo.setEnabled(false);
            btnVerInfoAmigo.setEnabled(true);
            this.btnBloquear.setEnabled(true);
        }
        
    }//GEN-LAST:event_tablaJugadoresMouseClicked

    private void tablaJugadoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaJugadoresKeyReleased
        // TODO add your handling code here:
        tablaJugadoresMouseClicked(null);
    }//GEN-LAST:event_tablaJugadoresKeyReleased

    private void btnBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloquearActionPerformed
        // TODO add your handling code here:
        Jugador bloquear = ((ModeloTablaJugadores)tablaJugadores.getModel()).obtenerJugador(tablaJugadores.getSelectedRow());
        
        fa.bloquearJugador((Jugador)usuario, bloquear);
        
        this.btnBuscarActionPerformed(null);
        this.btnBloquear.setEnabled(false);
    }//GEN-LAST:event_btnBloquearActionPerformed

    private void btnHacerAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHacerAmigoActionPerformed
        // TODO add your handling code here:
        Jugador jugSelec = ((ModeloTablaJugadores)tablaJugadores.getModel()).obtenerJugador(tablaJugadores.getSelectedRow());
        fa.anhadirAmigo((Jugador)usuario, jugSelec);
    }//GEN-LAST:event_btnHacerAmigoActionPerformed

    private void btnVerInfoAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoAmigoActionPerformed
        // TODO add your handling code here:
        fa.muestraVPerfilAmigo(((ModeloTablaJugadores)tablaJugadores.getModel()).obtenerJugador(tablaJugadores.getSelectedRow()));
    }//GEN-LAST:event_btnVerInfoAmigoActionPerformed

    private void btnVerBloqueadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerBloqueadosActionPerformed
        // TODO add your handling code here:
        fa.muestraVBloqueados(usuario,this);
    }//GEN-LAST:event_btnVerBloqueadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollTablaUsuarios;
    private javax.swing.JButton btnBloquear;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnHacerAmigo;
    private javax.swing.JToggleButton btnSelectorAmigosTotal;
    private javax.swing.JButton btnVerBloqueados;
    private javax.swing.JButton btnVerInfoAmigo;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable tablaJugadores;
    // End of variables declaration//GEN-END:variables
}
