package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import controllers.HibernateUtil;
import controllers.UsersController;
import controllers.UsuarioSesion;

/**
 *
 * @author miquelpetrus
 */
public class MainApp extends javax.swing.JFrame{
	
	DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	String horaFormateada = LocalDateTime.now().format(formatoHora);

	/**
	 * Creates new form MainApp
	 */
	
	public MainApp() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        try {
            if (!existeArchivoConfiguracion()) {
                crearArchivoConfiguracion();
                abrirVistaConfiguracion();
            } else {
                HibernateUtil.buildSessionFactory();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
        HibernateUtil.abrirVentana(configuracionView, "Configuración");
    }
    
    public void actualizarTextoBienvenida() {
        int idUsuario = UsuarioSesion.getIdUsuario();
        String nombreUsuario = UsersController.getNombreUsuarioById(idUsuario);
        jLabelBienvenida.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        jLabelBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBienvenida.setText("<html>Bienvenido a MolíGest, <br>" + nombreUsuario + "<br>" + horaFormateada + "</html>");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jLabelBienvenida = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuConf = new javax.swing.JMenuItem();
        jMenuConnect = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenuGest = new javax.swing.JMenu();
        jMenuProv = new javax.swing.JMenuItem();
        jMenuFac = new javax.swing.JMenuItem();
        jMenuProductos = new javax.swing.JMenuItem();
        jMenuEventos = new javax.swing.JMenuItem();
        jMenuCuentas = new javax.swing.JMenu();
        jMenuBancos = new javax.swing.JMenuItem();
        jMenuIngresos = new javax.swing.JMenuItem();
        jMenuGastos = new javax.swing.JMenuItem();
        jMenuMiembros = new javax.swing.JMenu();
        jMenuUsers = new javax.swing.JMenuItem();
        jMenuSocios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setBackground(new java.awt.Color(243, 243, 243));

        jLabelBienvenida.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabelBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelBienvenida.setText("Bienvenido, \n");
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
                .addContainerGap(351, Short.MAX_VALUE)
                .addComponent(jLabelBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setMargin(new java.awt.Insets(4, 4, 4, 4));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(164, 36));

        jMenuFile.setText("Archivo");
        jMenuFile.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jMenuFile.setMargin(new java.awt.Insets(3, 10, 3, 10));
        jMenuFile.setPreferredSize(new java.awt.Dimension(80, 32));
        jMenuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFileActionPerformed(evt);
            }
        });

        jMenuConf.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuConf.setText("Configuración");
        jMenuConf.setPreferredSize(new java.awt.Dimension(124, 32));
        jMenuConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConfActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuConf);

        jMenuConnect.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuConnect.setText("Conectar");
        jMenuConnect.setPreferredSize(new java.awt.Dimension(103, 32));
        jMenuConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConnectActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuConnect);

        jMenuSalir.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
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
        jMenuGest.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuGest.setPreferredSize(new java.awt.Dimension(80, 32));

        jMenuProv.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuProv.setText("Proveedores");
        jMenuProv.setPreferredSize(new java.awt.Dimension(90, 32));
        jMenuProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProvActionPerformed(evt);
            }
        });
        jMenuGest.add(jMenuProv);

        jMenuFac.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuFac.setText("Facturas");
        jMenuFac.setPreferredSize(new java.awt.Dimension(92, 32));
        jMenuFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFacActionPerformed(evt);
            }
        });
        jMenuGest.add(jMenuFac);

        jMenuProductos.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuProductos.setText("Productos");
        jMenuProductos.setPreferredSize(new java.awt.Dimension(102, 32));
        jMenuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProductosActionPerformed(evt);
            }
        });
        jMenuGest.add(jMenuProductos);

        jMenuEventos.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuEventos.setText("Eventos");
        jMenuEventos.setPreferredSize(new java.awt.Dimension(89, 32));
        jMenuEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEventosActionPerformed(evt);
            }
        });
        jMenuGest.add(jMenuEventos);

        jMenuCuentas.setText("Cuentas");
        jMenuCuentas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuCuentas.setPreferredSize(new java.awt.Dimension(101, 32));

        jMenuBancos.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuBancos.setText("Bancos");
        jMenuBancos.setPreferredSize(new java.awt.Dimension(86, 32));
        jMenuBancos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBancosActionPerformed(evt);
            }
        });
        jMenuCuentas.add(jMenuBancos);

        jMenuIngresos.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuIngresos.setText("Ingresos");
        jMenuIngresos.setPreferredSize(new java.awt.Dimension(86, 32));
        jMenuIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIngresosActionPerformed(evt);
            }
        });
        jMenuCuentas.add(jMenuIngresos);

        jMenuGastos.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuGastos.setText("Gastos");
        jMenuGastos.setPreferredSize(new java.awt.Dimension(86, 32));
        jMenuGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGastosActionPerformed(evt);
            }
        });
        jMenuCuentas.add(jMenuGastos);

        jMenuGest.add(jMenuCuentas);

        jMenuBar1.add(jMenuGest);

        jMenuMiembros.setText("Miembros");
        jMenuMiembros.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuMiembros.setPreferredSize(new java.awt.Dimension(80, 32));

        jMenuUsers.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        jMenuUsers.setText("Usuarios");
        jMenuUsers.setPreferredSize(new java.awt.Dimension(101, 32));
        jMenuUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsersActionPerformed(evt);
            }
        });
        jMenuMiembros.add(jMenuUsers);

        jMenuSocios.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
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
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // A partir de aquí van las acciones de los botones del menú
    
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

    private void jMenuProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProvActionPerformed
        // TODO add your handling code here:
		try {
			ProveedoresView proveedoresView = new ProveedoresView();
			HibernateUtil.abrirVentana(proveedoresView, "Proveedores");

		} catch (Exception e) {
			e.printStackTrace();
		}
    }//GEN-LAST:event_jMenuProvActionPerformed

    private void jMenuBancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBancosActionPerformed
        // TODO add your handling code here:
    	 try {
    	      BancosView bancosView = new BancosView();
    	      HibernateUtil.abrirVentana(bancosView, "Bancos");
			} catch (Exception e) {
				e.printStackTrace();
			}
    }//GEN-LAST:event_jMenuBancosActionPerformed

    private void jMenuEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEventosActionPerformed
        // TODO add your handling code here:
		try {
			EventosView eventosView = new EventosView();
			HibernateUtil.abrirVentana(eventosView, "Eventos");

		} catch (Exception e) {
			e.printStackTrace();
		}
    }//GEN-LAST:event_jMenuEventosActionPerformed

    private void jMenuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProductosActionPerformed
        // TODO add your handling code here:
        try {
            ProductosView productosView = new ProductosView();
            HibernateUtil.abrirVentana(productosView, "Productos");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuProductosActionPerformed

    private void jMenuIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIngresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuIngresosActionPerformed

    private void jMenuGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGastosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuGastosActionPerformed
    

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
    // Muestro y oculto las opciones del menú según el usuario que se conecte
    
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
    private javax.swing.JMenu jMenuCuentas;
    private javax.swing.JMenuItem jMenuEventos;
    private javax.swing.JMenuItem jMenuFac;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuGastos;
    private javax.swing.JMenu jMenuGest;
    private javax.swing.JMenuItem jMenuIngresos;
    private javax.swing.JMenu jMenuMiembros;
    private javax.swing.JMenuItem jMenuProductos;
    private javax.swing.JMenuItem jMenuProv;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JMenuItem jMenuSocios;
    private javax.swing.JMenuItem jMenuUsers;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}
