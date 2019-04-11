/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Toolkit;

/**
 *
 * @author alumnogreibd
 */
public class VMiPerfil extends javax.swing.JDialog {

    /**
     * Creates new form VMiPerfil
     */
    public VMiPerfil(java.awt.Frame parent, boolean modal, boolean modoExterno) {
        super(parent, modal);
        initComponents();
        
        //Centramos en pantalla la ventana, para evitar que aparezca en la esquina superior izquierda
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 -this.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 -this.getHeight()/2);
        
        //El modo externo sirve para mostrar información de un usuario a un amigo, sin que  éste pueda
        //  modificar datos del usuario ni ocultar/compartir logros
        if(modoExterno){    
            this.campoAnoNacimiento.setEditable(false);
            this.campoMesNacimiento.setEditable(false);
            this.campoDiaNacimiento.setEditable(false);
            this.campoClave.setEditable(false);
            this.campoCorreo.setEditable(false);
            
            this.btnActualizarDatos.setEnabled(false);
            this.btnActualizarDatos.setVisible(false);
            
            this.btnCompartirLogro.setEnabled(false);
            this.btnCompartirLogro.setVisible(false);
            
            this.btnOcultarLogro.setEnabled(false);
            this.btnOcultarLogro.setVisible(false);
            
            this.btnVerSusJuegos.setEnabled(true);
            this.btnVerSusJuegos.setVisible(true);
            
            System.out.println("Modo externo activado");
            
        // El modo interno tiene utilidad si queremos mostrar la información de un usuario
        //  a él mismo, permitiéndole modificar diferentes datos y la visibilidad de los logros
        }else{
            
            this.campoAnoNacimiento.setEditable(true);
            this.campoMesNacimiento.setEditable(true);
            this.campoDiaNacimiento.setEditable(true);
            this.campoClave.setEditable(true);
            this.campoCorreo.setEditable(true);
            
            this.btnActualizarDatos.setEnabled(true);
            this.btnActualizarDatos.setVisible(true);
            
            this.btnCompartirLogro.setEnabled(true);
            this.btnCompartirLogro.setVisible(true);
            
            this.btnOcultarLogro.setEnabled(true);
            this.btnOcultarLogro.setVisible(true);
            
            this.btnVerSusJuegos.setEnabled(false);
            this.btnVerSusJuegos.setVisible(false);
            
            System.out.println("Modo externo desactivado");
        }
        
        this.setVisible(true);  //Hacemos que la ventana sea visible por el usuario
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
        etiquetaClave = new javax.swing.JLabel();
        campoClave = new javax.swing.JTextField();
        etiquetaFechaNacimiento = new javax.swing.JLabel();
        campoDiaNacimiento = new javax.swing.JTextField();
        etiquetaBarra1 = new javax.swing.JLabel();
        etiquetaBarra2 = new javax.swing.JLabel();
        campoMesNacimiento = new javax.swing.JTextField();
        campoAnoNacimiento = new javax.swing.JTextField();
        etiquetaCorreo = new javax.swing.JLabel();
        campoCorreo = new javax.swing.JTextField();
        btnActualizarDatos = new javax.swing.JButton();
        etiquetaLogros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLogros = new javax.swing.JTable();
        btnCompartirLogro = new javax.swing.JButton();
        btnOcultarLogro = new javax.swing.JButton();
        btnVerSusJuegos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaNombre.setText("Nombre:");

        campoNombre.setEditable(false);

        etiquetaClave.setText("Clave:");

        etiquetaFechaNacimiento.setText("Fecha Nacimiento:");

        etiquetaBarra1.setText("/");

        etiquetaBarra2.setText("/");

        etiquetaCorreo.setText("Correo:");

        btnActualizarDatos.setText("Actualizar Datos");

        etiquetaLogros.setText("Logros:");

        tablaLogros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaLogros);

        btnCompartirLogro.setText("Compartir Logro");

        btnOcultarLogro.setText("Ocultar Logro");
        btnOcultarLogro.setEnabled(false);

        btnVerSusJuegos.setText("Ver sus juegos");
        btnVerSusJuegos.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizarDatos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(etiquetaNombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(etiquetaClave))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(etiquetaFechaNacimiento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoDiaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etiquetaBarra1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(campoMesNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etiquetaBarra2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoAnoNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(etiquetaCorreo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoClave)
                                    .addComponent(campoCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(etiquetaLogros)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCompartirLogro)
                                .addGap(118, 118, 118)
                                .addComponent(btnOcultarLogro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                .addComponent(btnVerSusJuegos)
                                .addGap(99, 99, 99))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaClave)
                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaFechaNacimiento)
                    .addComponent(campoDiaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaBarra1)
                    .addComponent(etiquetaBarra2)
                    .addComponent(campoMesNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAnoNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaCorreo)
                    .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnActualizarDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiquetaLogros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompartirLogro)
                    .addComponent(btnOcultarLogro)
                    .addComponent(btnVerSusJuegos))
                .addContainerGap(45, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarDatos;
    private javax.swing.JButton btnCompartirLogro;
    private javax.swing.JButton btnOcultarLogro;
    private javax.swing.JButton btnVerSusJuegos;
    private javax.swing.JTextField campoAnoNacimiento;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JTextField campoDiaNacimiento;
    private javax.swing.JTextField campoMesNacimiento;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel etiquetaBarra1;
    private javax.swing.JLabel etiquetaBarra2;
    private javax.swing.JLabel etiquetaClave;
    private javax.swing.JLabel etiquetaCorreo;
    private javax.swing.JLabel etiquetaFechaNacimiento;
    private javax.swing.JLabel etiquetaLogros;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLogros;
    // End of variables declaration//GEN-END:variables
}
