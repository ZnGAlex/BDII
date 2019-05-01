/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Toolkit;
import aplicacion.Juego;
import aplicacion.Jugador;
import javax.swing.JOptionPane;

/**
 *
 * @author alumnogreibd
 */
public class VJugar extends javax.swing.JDialog {

    private Jugador jugador;
    private Juego juego;
    private int retransmitiendo;

    private final aplicacion.FachadaAplicacion fa;

    /**
     * Creates new form VJugar
     *
     * @param parent
     * @param modal
     * @param fa
     */
    public VJugar(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa, Jugador j, Juego ju) {

        super(parent, modal);
        //Almacenamos una referencia a la fachada de aplicación para poder tener todas las funcionalidades disponibles
        this.fa = fa;
        this.juego = ju;
        this.jugador = j;
        this.retransmitiendo = 0;
        initComponents();
        this.etiquetaRetransmitiendo.setVisible(false);
        //Centramos en pantalla la ventana, para evitar que aparezca en la esquina superior izquierda
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - this.getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - this.getHeight() / 2);
        //Hacemos la ventana visible para el usuario
        this.setVisible(true);
        

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent w) {
                salir();
            }
        });

    }

    void salir() {
        if(this.retransmitiendo==1){
        fa.dejarRetransmitir(jugador, juego);
        }
        fa.dejarJugar(jugador, juego);
        this.dispose();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TextoJuego = new javax.swing.JTextArea();
        etiquetaRetransmitiendo = new javax.swing.JLabel();
        btnRetransmitir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), java.awt.Color.lightGray));

        TextoJuego.setColumns(20);
        TextoJuego.setRows(5);
        jScrollPane1.setViewportView(TextoJuego);

        etiquetaRetransmitiendo.setFont(new java.awt.Font("Droid Sans Mono", 1, 18)); // NOI18N
        etiquetaRetransmitiendo.setForeground(new java.awt.Color(0, 0, 255));
        etiquetaRetransmitiendo.setText("***** Retransmitiendo *****");

        btnRetransmitir.setText("Retransmitir");
        btnRetransmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetransmitirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRetransmitir)
                        .addGap(386, 386, 386))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(etiquetaRetransmitiendo)
                        .addGap(272, 272, 272))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(etiquetaRetransmitiendo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnRetransmitir)
                .addGap(57, 57, 57))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetransmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetransmitirActionPerformed
        // TODO add your handling code here:
        if(this.retransmitiendo==0){
            this.retransmitiendo=1;
            fa.retransmitir(jugador, juego);
            this.etiquetaRetransmitiendo.setVisible(true);
        }
        else{
            this.retransmitiendo=0;
            fa.dejarRetransmitir(jugador, juego);
            this.etiquetaRetransmitiendo.setVisible(false);
        }
    }//GEN-LAST:event_btnRetransmitirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TextoJuego;
    private javax.swing.JButton btnRetransmitir;
    private javax.swing.JLabel etiquetaRetransmitiendo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
