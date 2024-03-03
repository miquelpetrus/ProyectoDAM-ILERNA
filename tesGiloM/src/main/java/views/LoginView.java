/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.awt.Window;
import javax.swing.SwingUtilities;

import org.hibernate.SessionFactory;

import controllers.HibernateUtil;
import controllers.UsersController;

/**
 *
 * @author miquelpetrus
 */
public class LoginView extends javax.swing.JPanel {

    private final SessionFactory sessionFactory;
    private MainApp mainApp;
    
    
    public LoginView(MainApp mainApp) {
        initComponents();
        this.mainApp = mainApp;
        this.sessionFactory = HibernateUtil.buildSessionFactory();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLogin = new javax.swing.JLabel();
        jLabelUsr = new javax.swing.JLabel();
        jTextUsr = new javax.swing.JTextField();
        jLabelPSW = new javax.swing.JLabel();
        jPasswordPSW = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonLogin = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jTextAreaMnsj = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabelLogin.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogin.setText("Login");

        jLabelUsr.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabelUsr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsr.setText("Usuario:");
        jLabelUsr.setToolTipText("");

        jTextUsr.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabelPSW.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabelPSW.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPSW.setText("Contraseña:");

        jButtonLogin.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jTextAreaMnsj.setEditable(false);
        jTextAreaMnsj.setColumns(20);
        jTextAreaMnsj.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabelUsr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelPSW, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextUsr)
                            .addComponent(jPasswordPSW, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addComponent(jTextAreaMnsj, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelLogin)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordPSW, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPSW, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextAreaMnsj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
        String usuario = jTextUsr.getText();
        char[] passwordChars = jPasswordPSW.getPassword();
        String password = String.valueOf(passwordChars);

        
		String mensaje = UsersController.validarUsuario(usuario, password);
		jTextAreaMnsj.setText(mensaje);
		
        // Después de validar al usuario, oculta o muestra las opciones del menú
        mainApp.setMenuVisibility(mensaje.equals("Usuario correcto"));
        
        // Cierra la LoginView si el usuario es correcto
        if (mensaje.equals("Usuario correcto")) {
            Window window = SwingUtilities.getWindowAncestor(this);
            window.dispose();
        }

    }//GEN-LAST:event_jButtonLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelPSW;
    private javax.swing.JLabel jLabelUsr;
    private javax.swing.JPasswordField jPasswordPSW;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaMnsj;
    private javax.swing.JTextField jTextUsr;
    // End of variables declaration//GEN-END:variables
}
