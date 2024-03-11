
package views;


import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import controllers.HibernateUtil;
import controllers.UsersController;
import java.awt.Color;
import java.awt.Component;

/**
 *
 * @author miquelpetrus
 */
public class LoginView extends javax.swing.JPanel {

    private final SessionFactory sessionFactory;
    private MainApp mainApp;
    
    
    public LoginView(MainApp mainApp) {
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        UsersController.createDefaultAdminUser(sessionFactory);
        initComponents();
        this.mainApp = mainApp;
    }

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
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));

        jLabelLogin.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogin.setText("Login");

        jLabelUsr.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabelUsr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsr.setText("Usuario:");
        jLabelUsr.setToolTipText("");

        jTextUsr.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        jLabelPSW.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabelPSW.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPSW.setText("Contraseña:");

        jPasswordPSW.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonLogin.setBackground(new java.awt.Color(0, 102, 204));
        jButtonLogin.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(243, 243, 243));
        jButtonLogin.setText("Login");
        jButtonLogin.setBorder(null);
        jButtonLogin.setBorderPainted(false);
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonLogin.setFocusPainted(false);
        jButtonLogin.setFocusTraversalKeysEnabled(false);
        jButtonLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonLogin.setOpaque(false);
        jButtonLogin.setRolloverEnabled(false);
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseExited(evt);
            }
        });
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jButtonLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonLoginKeyPressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconoJPanel.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelPSW, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(jLabelUsr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextUsr)
                                    .addComponent(jPasswordPSW, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabelLogin)))
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
                .addGap(18, 18, 18)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        realizarLogin();
        }
    
    private void jButtonLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonLoginKeyPressed
        // TODO add your handling code here:
        realizarLogin();
    }//GEN-LAST:event_jButtonLoginKeyPressed

    private void jButtonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseEntered
        // TODO add your handling code here:
        Component c = evt.getComponent();                   
        c.setBackground(new Color(236, 252, 250));
        c.setForeground(new Color(0, 102, 204));
    }//GEN-LAST:event_jButtonLoginMouseEntered

    private void jButtonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseExited
        // TODO add your handling code here:
        Component c = evt.getComponent();                   
        c.setBackground(new Color(0, 102, 204));
        c.setForeground(new Color(236, 252, 250));
    }//GEN-LAST:event_jButtonLoginMouseExited

        
    private void realizarLogin() {
        String usuario = jTextUsr.getText();
        char[] passwordChars = jPasswordPSW.getPassword();
        String password = new String(passwordChars);

        if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El usuario y la contraseña son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar el usuario
        boolean usuarioValido = UsersController.validarUsuario(usuario, password);

        if (usuarioValido) {
            // Configurar la visibilidad del menú y actualizar el texto de bienvenida
            mainApp.setMenuVisibility(true);
            mainApp.actualizarTextoBienvenida();

            // Cerrar la ventana actual y la sesión de Hibernate
            HibernateUtil.cerrarVentana(this);
            sessionFactory.close();
        } 
    }
                                   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelPSW;
    private javax.swing.JLabel jLabelUsr;
    private javax.swing.JPasswordField jPasswordPSW;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextUsr;
    // End of variables declaration//GEN-END:variables
}
