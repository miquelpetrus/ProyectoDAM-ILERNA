package views;

import java.awt.Window;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controllers.HibernateUtil;
import controllers.UsersController;
import controllers.UsuarioSesion;

/**
 *
 * @author miquelpetrus
 */
public class ConfiguracionView extends javax.swing.JPanel {

    private Configuration hibernateConfiguration;
	private SessionFactory sessionFactory;

    
    public ConfiguracionView() {
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        initComponents();
        cargarConfiguracion();
        }

    private void cargarConfiguracion() {
        cargarCampoDesdeConfiguracion("server", jTextNomSrv);
        cargarCampoDesdeConfiguracion("ip", jTextNomIP);
        cargarCampoDesdeConfiguracion("database", jTextNomBBDD);
        cargarCampoDesdeConfiguracion("user", jTextNomUsr);
        cargarCampoDesdeConfiguracion("password", jTextNomPSW);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelConf = new javax.swing.JPanel();
        jLblNomSrv = new javax.swing.JLabel();
        jTextNomSrv = new javax.swing.JTextField();
        jLblNomIP = new javax.swing.JLabel();
        jTextNomIP = new javax.swing.JTextField();
        jLblNomBBDD = new javax.swing.JLabel();
        jTextNomBBDD = new javax.swing.JTextField();
        jLblNomUsr = new javax.swing.JLabel();
        jTextNomUsr = new javax.swing.JTextField();
        jLblNomPSW = new javax.swing.JLabel();
        jTextNomPSW = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();
        jButtonCrearAdmin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaNoAdmin = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanelConf.setBackground(new java.awt.Color(204, 204, 204));

        jLblNomSrv.setText("Nombre Servidor");

        jTextNomSrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomSrvActionPerformed(evt);
            }
        });

        jLblNomIP.setText("Dirección IP");

        jTextNomIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomIPActionPerformed(evt);
            }
        });

        jLblNomBBDD.setText("Nombre BBDD");

        jTextNomBBDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomBBDDActionPerformed(evt);
            }
        });

        jLblNomUsr.setText("Nombre Usuario");

        jTextNomUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomUsrActionPerformed(evt);
            }
        });

        jLblNomPSW.setText("Nombre PSW");

        jTextNomPSW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomPSWActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonCrearAdmin.setText("Crear admin");
        jButtonCrearAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearAdminActionPerformed(evt);
            }
        });

        jTextAreaNoAdmin.setBackground(new java.awt.Color(204, 204, 204));
        jTextAreaNoAdmin.setColumns(20);
        jTextAreaNoAdmin.setForeground(new java.awt.Color(255, 0, 51));
        jTextAreaNoAdmin.setRows(5);
        jTextAreaNoAdmin.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTextAreaNoAdminAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jTextAreaNoAdmin);

        javax.swing.GroupLayout jPanelConfLayout = new javax.swing.GroupLayout(jPanelConf);
        jPanelConf.setLayout(jPanelConfLayout);
        jPanelConfLayout.setHorizontalGroup(
            jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfLayout.createSequentialGroup()
                .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelConfLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelConfLayout.createSequentialGroup()
                                .addComponent(jLblNomPSW, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextNomPSW, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelConfLayout.createSequentialGroup()
                                    .addComponent(jLblNomUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextNomUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelConfLayout.createSequentialGroup()
                                    .addComponent(jLblNomBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextNomBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelConfLayout.createSequentialGroup()
                                    .addComponent(jLblNomIP, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextNomIP, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelConfLayout.createSequentialGroup()
                                    .addComponent(jLblNomSrv, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextNomSrv, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCrearAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanelConfLayout.setVerticalGroup(
            jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNomSrv, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNomSrv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNomIP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNomIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNomBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNomBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNomUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNomUsr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblNomPSW, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNomPSW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCrearAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelConf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNomSrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomSrvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomSrvActionPerformed

    private void jTextNomIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomIPActionPerformed

    private void jTextNomBBDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomBBDDActionPerformed

    }//GEN-LAST:event_jTextNomBBDDActionPerformed

    private void jTextNomUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomUsrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomUsrActionPerformed

    private void jTextNomPSWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomPSWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomPSWActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        String server = jTextNomSrv.getText();
        String ip = jTextNomIP.getText();
        String database = jTextNomBBDD.getText();
        String user = jTextNomUsr.getText();
        String password = jTextNomPSW.getText();

        // Guardar la configuración en un archivo de propiedades
        Properties properties = new Properties();
        properties.setProperty("ip", ip);
        properties.setProperty("database", database);
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        properties.setProperty("server", server);

        try (FileOutputStream fos = new FileOutputStream("hibernate-config.properties")) {
            properties.store(fos, "Configuración Hibernate");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
        // Obtener la ventana padre
    	HibernateUtil.cerrarVentana(this);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonCrearAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearAdminActionPerformed
        // TODO add your handling code here:
    	UsersController.createDefaultAdminUser(sessionFactory);
        jTextAreaNoAdmin.setText("Usuario admin creado");
    }//GEN-LAST:event_jButtonCrearAdminActionPerformed

    private void jTextAreaNoAdminAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextAreaNoAdminAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAreaNoAdminAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonCrearAdmin;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLblNomBBDD;
    private javax.swing.JLabel jLblNomIP;
    private javax.swing.JLabel jLblNomPSW;
    private javax.swing.JLabel jLblNomSrv;
    private javax.swing.JLabel jLblNomUsr;
    private javax.swing.JPanel jPanelConf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaNoAdmin;
    private javax.swing.JTextField jTextNomBBDD;
    private javax.swing.JTextField jTextNomIP;
    private javax.swing.JTextField jTextNomPSW;
    private javax.swing.JTextField jTextNomSrv;
    private javax.swing.JTextField jTextNomUsr;
    // End of variables declaration//GEN-END:variables

    private void cargarCampoDesdeConfiguracion(String clave, JTextField campo) {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("hibernate-config.properties");
            properties.load(fis);
            fis.close();

            campo.setText(properties.getProperty(clave));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public Session openSession() {
		// TODO Auto-generated method stub
		return null;
	}

}
