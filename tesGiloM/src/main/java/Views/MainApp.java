package Views;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 *
 * @author miquelpetrus
 */
public class MainApp extends javax.swing.JFrame {

    private Configuration hibernateConfiguration;
    private static SessionFactory sessionFactory;
    
    public MainApp() {
        initComponents();
        cargarConfiguracionHibernate();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
            try {
                File configFile = new File("hibernate-config.properties");
                if (configFile.exists()) {
                    FileReader reader = new FileReader(configFile);
                    hibernateConfiguration = new Configuration();
                    hibernateConfiguration.getProperties().load(reader);
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            try (Session session = sessionFactory.openSession()) {
            // Aquí puedes realizar operaciones en la base de datos usando la sesión
            // Por ejemplo, podrías realizar consultas o transacciones
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
        private static void cargarConfiguracionHibernate() {
            try {
                // Configura y carga la configuración de Hibernate desde hibernate.cfg.xml
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                sessionFactory = configuration.buildSessionFactory();

                System.out.println("Configuración de Hibernate cargada correctamente.");
            } catch (Exception e) {
                System.err.println("Error al cargar la configuración de Hibernate: " + e.getMessage());
                e.printStackTrace();
            }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuConf = new javax.swing.JMenuItem();
        jMenuConnect = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenuGest = new javax.swing.JMenu();
        jMenuPed = new javax.swing.JMenuItem();
        jMenuFac = new javax.swing.JMenuItem();
        jMenuBancos = new javax.swing.JMenuItem();
        jMenuMiembros = new javax.swing.JMenu();
        jMenuUsers = new javax.swing.JMenuItem();
        jMenuSocios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jMenuFile.setText("File");
        jMenuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFileActionPerformed(evt);
            }
        });

        jMenuConf.setText("Configuración");
        jMenuConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConfActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuConf);

        jMenuConnect.setText("Conectar");
        jMenuFile.add(jMenuConnect);

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuSalir);

        jMenuBar1.add(jMenuFile);

        jMenuGest.setText("Gestión");

        jMenuPed.setText("Pedidos");
        jMenuGest.add(jMenuPed);

        jMenuFac.setText("Facturas");
        jMenuFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFacActionPerformed(evt);
            }
        });
        jMenuGest.add(jMenuFac);

        jMenuBancos.setText("Bancos");
        jMenuGest.add(jMenuBancos);

        jMenuBar1.add(jMenuGest);

        jMenuMiembros.setText("Miembros");

        jMenuUsers.setText("Usuarios");
        jMenuMiembros.add(jMenuUsers);

        jMenuSocios.setText("Socios");
        jMenuMiembros.add(jMenuSocios);

        jMenuBar1.add(jMenuMiembros);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuFacActionPerformed

    private void jMenuConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConfActionPerformed
        // TODO add your handling code here:
        try {
            ConfiguracionView configuracionView = new ConfiguracionView();

            // Crear un nuevo JFrame para la ventana de configuración
            JFrame configFrame = new JFrame("Configuración");
            configFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo la ventana de configuración al presionar la 'X'
            configFrame.getContentPane().add(configuracionView);
            configFrame.pack();
            configFrame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuConfActionPerformed

    private void jMenuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuFileActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirActionPerformed

    /** Esto es una idea para poder mostrar las diferentes vistas en una misma ventana 
    private void mostrarVistaEnPanel(JPanel vista) {
    System.out.println("Mostrando vista en el panel");
    System.out.println("Tamaño de la vista: " + vista.getSize());
    System.out.println("Tamaño del panel principal: " + jPanelPrincipal.getSize());
    jPanelPrincipal.removeAll();
    jPanelPrincipal.add(vista);
    jPanelPrincipal.revalidate();
    jPanelPrincipal.repaint();
    } */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuBancos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuConf;
    private javax.swing.JMenuItem jMenuConnect;
    private javax.swing.JMenuItem jMenuFac;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuGest;
    private javax.swing.JMenu jMenuMiembros;
    private javax.swing.JMenuItem jMenuPed;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JMenuItem jMenuSocios;
    private javax.swing.JMenuItem jMenuUsers;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}
