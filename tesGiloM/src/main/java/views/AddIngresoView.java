/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.util.Date;

import javax.swing.DefaultComboBoxModel;

import org.hibernate.SessionFactory;

import clases.Bancos;
import clases.Eventos;
import clases.Socios;
import clases.Terceros;
import controllers.BancosController;
import controllers.EventosController;
import controllers.HibernateUtil;
import controllers.MovsBancariosController;
import controllers.SociosController;
import controllers.TercerosController;

/**
 *
 * @author miquelpetrus
 */
public class AddIngresoView extends javax.swing.JPanel {

    private SessionFactory sessionFactory;
	/**
     * Creates new form AddIngresoView
     */
    public AddIngresoView() {
        initComponents();
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        cargarTerceros();
        cargarEventos();
        cargarSocios();
        cargarBancos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFecha = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabelTercero = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelImporte = new javax.swing.JLabel();
        jTextFieldImporte = new javax.swing.JTextField();
        jLabelEvento = new javax.swing.JLabel();
        jComboBoxEvento = new javax.swing.JComboBox<>();
        jLabelSocio = new javax.swing.JLabel();
        jComboBoxSocio = new javax.swing.JComboBox<>();
        jButtonCerrar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jComboBoxBanco = new javax.swing.JComboBox<>();
        jLabelBanco = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelObs = new javax.swing.JLabel();
        jTextFieldObs = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(243, 243, 243));

        jLabelFecha.setText("Fecha Ingreso:");

        jLabelTercero.setText("Tercero:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelImporte.setText("Importe: ");

        jTextFieldImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldImporteActionPerformed(evt);
            }
        });

        jLabelEvento.setText("Evento:");

        jComboBoxEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelSocio.setText("Socio:");

        jComboBoxSocio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jComboBoxBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelBanco.setText("Banco destino:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Añadir Ingreso");

        jLabelObs.setText("Obsrvaciones:");

        jTextFieldObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxBanco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTercero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 158, Short.MAX_VALUE))
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxSocio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldImporte))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelObs, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldObs))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelTercero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxSocio)
                    .addComponent(jLabelSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelObs, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldObs, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldImporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldImporteActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
    	HibernateUtil.cerrarVentana(jButtonCerrar);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        Date fecha = jDateChooser1.getDate();
        Terceros terceroSeleccionado = (Terceros) jComboBox1.getSelectedItem();
        int idTercero = 0;
		if (terceroSeleccionado != null) {
			idTercero = terceroSeleccionado.getId();
		}
        Bancos bancoSeleccionado = (Bancos) jComboBoxBanco.getSelectedItem();
        int banco = bancoSeleccionado.getId();
        double importe = Double.parseDouble(jTextFieldImporte.getText());
        Eventos eventoSeleccionado = (Eventos) jComboBoxEvento.getSelectedItem();
        Socios socioSeleccionado = (Socios) jComboBoxSocio.getSelectedItem();
        int idSocio = 0;
		if (socioSeleccionado != null) {
			idSocio = socioSeleccionado.getId();
		}
		String obs = jTextFieldObs.getText();
        String tipo = "Ingreso";
    	
    	System.out.println("Fecha: " + fecha + " Tercero: " + idTercero + " Banco: " + banco + " Importe: " + importe + " Evento: " + eventoSeleccionado + " Socio: " + idSocio);
    	
        MovsBancariosController.crearIngreso(fecha, idTercero, banco, idSocio, eventoSeleccionado, obs, importe, tipo);
        HibernateUtil.cerrarVentana(this);
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jTextFieldObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObsActionPerformed

    private void cargarTerceros() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        // Añadir opción vacía
        model.addElement(null); 
        
        for (Terceros tercero: TercerosController.getAllProveedores()) {
            model.addElement(tercero);
        }
        
        jComboBox1.setModel(model);
    }
    
    private void cargarEventos() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        // Añadir opción vacía
        model.addElement(null); 
        
        for (Eventos evento: EventosController.getAllEventos()) {
            model.addElement(evento);
        }
        
        jComboBoxEvento.setModel(model);
    }
    
    private void cargarSocios() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        // Añadir opción vacía
        model.addElement(null); 
        
        for (Socios socio: SociosController.getAllSocios()) {
            model.addElement(socio);
        }
        
        jComboBoxSocio.setModel(model);
    }
    
    private void cargarBancos() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        
        for (Bancos banco: BancosController.getAllBancos()) {
            model.addElement(banco);
        }
        
        jComboBoxBanco.setModel(model);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxBanco;
    private javax.swing.JComboBox<String> jComboBoxEvento;
    private javax.swing.JComboBox<String> jComboBoxSocio;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBanco;
    private javax.swing.JLabel jLabelEvento;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelImporte;
    private javax.swing.JLabel jLabelObs;
    private javax.swing.JLabel jLabelSocio;
    private javax.swing.JLabel jLabelTercero;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldImporte;
    private javax.swing.JTextField jTextFieldObs;
    // End of variables declaration//GEN-END:variables
}
