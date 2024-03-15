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
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("hibernate-config.properties")) {
            properties.load(fis);
            String url = properties.getProperty("hibernate.connection.url");

            // Obtener la IP y el nombre de la base de datos del URL de conexión
            int indexInicio = url.indexOf("//") + 2;
            int indexFin = url.indexOf(":", indexInicio);
            String ip = url.substring(indexInicio, indexFin);

            indexInicio = url.indexOf("/", indexFin) + 1;
            String database = url.substring(indexInicio);

            // Rellenar los campos de texto con la IP y el nombre de la base de datos obtenidos
            jTextNomIP.setText(ip);
            jTextNomBBDD.setText(database);

            // Rellenar los campos de texto con el usuario y la contraseña
            jTextNomUsr.setText(properties.getProperty("hibernate.connection.username"));
            jTextNomPSW.setText(properties.getProperty("hibernate.connection.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelConf = new javax.swing.JPanel();
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
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanelConf.setBackground(new java.awt.Color(243, 243, 243));

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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Configurar aplicación");

        javax.swing.GroupLayout jPanelConfLayout = new javax.swing.GroupLayout(jPanelConf);
        jPanelConf.setLayout(jPanelConfLayout);
        jPanelConfLayout.setHorizontalGroup(
            jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelConfLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(jTextNomIP, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanelConfLayout.setVerticalGroup(
            jPanelConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
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
                .addContainerGap(75, Short.MAX_VALUE))
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
        String ip = jTextNomIP.getText().trim();
        String database = jTextNomBBDD.getText().trim();
        String user = jTextNomUsr.getText().trim();
        String password = jTextNomPSW.getText().trim();

        // Cargar la configuración existente desde el archivo hibernate-config.properties
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("hibernate-config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Actualizar la propiedad hibernate.connection.url con la IP proporcionada por el usuario
        String connectionUrl = "jdbc:mysql://" + ip + ":3306/" + database;
        properties.setProperty("hibernate.connection.url", connectionUrl);
        properties.setProperty("hibernate.connection.username", user);
        properties.setProperty("hibernate.connection.password", password);

        // Guardar la configuración actualizada en el archivo hibernate-config.properties
        try (FileOutputStream fos = new FileOutputStream("hibernate-config.properties")) {
            properties.store(fos, "Configuración Hibernate");
            JOptionPane.showMessageDialog(this, "Configuración guardada correctamente");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la configuración");
        }
    }


    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
        // Obtener la ventana padre
    	HibernateUtil.cerrarVentana(this);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

	public Session openSession() {
		// TODO Auto-generated method stub
		return null;
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblNomBBDD;
    private javax.swing.JLabel jLblNomIP;
    private javax.swing.JLabel jLblNomPSW;
    private javax.swing.JLabel jLblNomUsr;
    private javax.swing.JPanel jPanelConf;
    private javax.swing.JTextField jTextNomBBDD;
    private javax.swing.JTextField jTextNomIP;
    private javax.swing.JTextField jTextNomPSW;
    private javax.swing.JTextField jTextNomUsr;
    // End of variables declaration//GEN-END:variables

}
