package views;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import controllers.HibernateUtil;
import controllers.UsuarioSesion;

/**
 *
 * @author miquelpetrus
 */
public class MainApp extends javax.swing.JFrame{
	
	DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	String horaFormateada = LocalDateTime.now().format(formatoHora);
	
	public MainApp() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        if (!existeArchivoConfiguracion()) {
            crearArchivoConfiguracion();
            abrirVistaConfiguracion();
        } else {
        	HibernateUtil.buildSessionFactory();
        }

    }
    
    private boolean existeArchivoConfiguracion() {
        File archivoConfiguracion = new File("hibernate-config.properties");
        return archivoConfiguracion.exists();
    }

    private void crearArchivoConfiguracion() {
        try {
            File archivoConfiguracion = new File("hibernate-config.properties");
            archivoConfiguracion.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void abrirVistaConfiguracion() {
        ConfiguracionView configuracionView = new ConfiguracionView();
        // Mostrar la vista de configuración...
	        JFrame configFrame = new JFrame("Configuración");
	        configFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        configFrame.getContentPane().add(configuracionView);
	        configFrame.pack();
	        configFrame.setVisible(true);
	        configFrame.setLocationRelativeTo(null);
        // Cambiar el enfoque después de que la aplicación esté completamente inicializada
        EventQueue.invokeLater(() -> {
            configFrame.toFront();
            configFrame.repaint();
            configFrame.requestFocus();
        });
    }
    
    public void actualizarTextoBienvenida() {
        jLabelBienvenida.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        jLabelBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBienvenida.setText("<html>Bienvenido a MolíGest, <br>" + UsuarioSesion.getNombreUsuario() + "<br>" + horaFormateada + "</html>");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/FondoJPanel.png");
    	Image img = backgroundImage.getImage();

    	jPanelPrincipal = new javax.swing.JPanel() {
    	    @Override
    	    protected void paintComponent(Graphics g) {
    	        super.paintComponent(g);

    	        // Obtén las dimensiones originales de la imagen
    	        int imgWidth = img.getWidth((ImageObserver) this);
    	        int imgHeight = img.getHeight((ImageObserver) this);

    	        // Calcula las nuevas dimensiones para que ocupe el 50% del espacio
    	        int newWidth = this.getWidth() / 3;
    	        int newHeight = (int) ((double) newWidth / imgWidth * imgHeight);

    	        // Dibuja la imagen ajustada en el centro del JPanel
    	        g.drawImage(img, (this.getWidth() - newWidth) / 2, (this.getHeight() - newHeight) / 2, newWidth, newHeight, this);
    	    }
    	};
        jLabelBienvenida = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuConf = new javax.swing.JMenuItem();
        jMenuConnect = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenuGest = new javax.swing.JMenu();
        jMenuPed = new javax.swing.JMenuItem();
        jMenuFac = new javax.swing.JMenuItem();
        jMenuProductos = new javax.swing.JMenuItem();
        jMenuEventos = new javax.swing.JMenuItem();
        jMenuBancos = new javax.swing.JMenuItem();
        jMenuMiembros = new javax.swing.JMenu();
        jMenuUsers = new javax.swing.JMenuItem();
        jMenuSocios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        jLabelBienvenida.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabelBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelBienvenida.setText("\n");
        jLabelBienvenida.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addComponent(jLabelBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(391, Short.MAX_VALUE)
                .addComponent(jLabelBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setMargin(new java.awt.Insets(4, 4, 4, 4));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(164, 36));

        jMenuFile.setText("Archivo");
        jMenuFile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuFile.setMargin(new java.awt.Insets(3, 10, 3, 10));
        jMenuFile.setPreferredSize(new java.awt.Dimension(80, 32));
        jMenuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFileActionPerformed(evt);
            }
        });

        jMenuConf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuConf.setText("Configuración");
        jMenuConf.setPreferredSize(new java.awt.Dimension(124, 32));
        jMenuConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConfActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuConf);

        jMenuConnect.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuConnect.setText("Conectar");
        jMenuConnect.setPreferredSize(new java.awt.Dimension(103, 32));
        jMenuConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConnectActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuConnect);

        jMenuSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuSalir.setText("Salir");
        jMenuSalir.setPreferredSize(new java.awt.Dimension(73, 32));
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuSalir);

        jMenuBar1.add(jMenuFile);

        jMenuGest.setText("Gestión");
        jMenuGest.setPreferredSize(new java.awt.Dimension(80, 32));
        jMenuGest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuPed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuPed.setText("Pedidos");
        jMenuPed.setPreferredSize(new java.awt.Dimension(90, 32));
        jMenuGest.add(jMenuPed);

        jMenuFac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuFac.setText("Facturas");
        jMenuFac.setPreferredSize(new java.awt.Dimension(92, 32));
        jMenuFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFacActionPerformed(evt);
            }
        });
        jMenuGest.add(jMenuFac);

        jMenuProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuProductos.setText("Productos");
        jMenuProductos.setPreferredSize(new java.awt.Dimension(102, 32));
		jMenuProductos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuProductosActionPerformed(evt);
			}
		});
        jMenuGest.add(jMenuProductos);

        jMenuEventos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuEventos.setText("Eventos");
        jMenuEventos.setPreferredSize(new java.awt.Dimension(89, 32));
        jMenuGest.add(jMenuEventos);

        jMenuBancos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuBancos.setText("Bancos");
        jMenuBancos.setPreferredSize(new java.awt.Dimension(86, 32));
        jMenuGest.add(jMenuBancos);

        jMenuBar1.add(jMenuGest);

        jMenuMiembros.setText("Miembros");
        jMenuMiembros.setPreferredSize(new java.awt.Dimension(80, 32));
        jMenuMiembros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuUsers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuUsers.setText("Usuarios");
        jMenuUsers.setPreferredSize(new java.awt.Dimension(101, 32));
        jMenuUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsersActionPerformed(evt);
            }
        });
        jMenuMiembros.add(jMenuUsers);

        jMenuSocios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuSocios.setText("Socios");
        jMenuSocios.setPreferredSize(new java.awt.Dimension(86, 32));
        jMenuSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSociosActionPerformed(evt);
            }
        });
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
    	try {
			HibernateUtil.abrirVentana(new FacturasView(), "Facturas");
		} catch (Exception e) {
			e.printStackTrace();
    	}

    }//GEN-LAST:event_jMenuFacActionPerformed

    private void jMenuConfActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        try {
            ConfiguracionView configuracionView = new ConfiguracionView();
            HibernateUtil.abrirVentana(configuracionView, "Configuración");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jMenuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuFileActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenuUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsersActionPerformed
        // TODO add your handling code here:
        try {
            UsersView usersView = new UsersView();
            HibernateUtil.abrirVentana(usersView, "Usuarios");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuUsersActionPerformed

    private void jMenuSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSociosActionPerformed
        // TODO add your handling code here:
        try {

            SociosView sociosView = new SociosView();
            HibernateUtil.abrirVentana(sociosView, "Socios");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuSociosActionPerformed

    private void jMenuConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConnectActionPerformed
        // TODO add your handling code here:
        try {

            LoginView loginView = new LoginView(this);
            HibernateUtil.abrirVentana(loginView, "Conectar");

        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_jMenuConnectActionPerformed
    
    private void jMenuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConnectActionPerformed
        // TODO add your handling code here:
        try {
            ProductosView productosView = new ProductosView();
            HibernateUtil.abrirVentana(productosView, "Productos");

        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

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
                MainApp mainapp = new MainApp(); // instancia de la clase MainApp
                mainapp.setVisible(true);
                mainapp.setMenuAdminVisibility(true); // muestra las opciones de menú de administrador
                mainapp.setMenuVisibility(false); // oculta las opciones de menú hasta que el usuario se conecte
                mainapp.setLocationRelativeTo(null); // para que se muestre en el centro de la pantalla
                mainapp.setIconImage(new ImageIcon("src/main/resources/images/icono.png").getImage());
                mainapp.setTitle("MolíGest");
            }
        });
    }
    
    public void setMenuVisibility(boolean visible) {
        jMenuGest.setVisible(visible);
        jMenuMiembros.setVisible(visible);
    }
    
	public void setMenuAdminVisibility(boolean visible) {
		jMenuConf.setVisible(visible);
		jMenuConnect.setVisible(visible);
		jMenuSalir.setVisible(visible);
	}
	

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBienvenida;
    private javax.swing.JMenuItem jMenuBancos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuConf;
    private javax.swing.JMenuItem jMenuConnect;
    private javax.swing.JMenuItem jMenuEventos;
    private javax.swing.JMenuItem jMenuFac;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuGest;
    private javax.swing.JMenu jMenuMiembros;
    private javax.swing.JMenuItem jMenuPed;
    private javax.swing.JMenuItem jMenuProductos;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JMenuItem jMenuSocios;
    private javax.swing.JMenuItem jMenuUsers;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}
