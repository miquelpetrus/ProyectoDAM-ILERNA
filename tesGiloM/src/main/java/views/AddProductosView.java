/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.awt.Window;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import org.hibernate.SessionFactory;

import controllers.FamiliaProductoController;
import controllers.HibernateUtil;
import controllers.ProductosController;
import controllers.TercerosController;
import clases.FamiliaProducto;
import clases.Terceros;

/**
 *
 * @author miquelpetrus
 */
public class AddProductosView extends javax.swing.JPanel {

    /**
     * Creates new form ProductoView
     */
    private SessionFactory sessionFactory;
    
    public AddProductosView() {
        initComponents();
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        cargarTerceros();
        cargarFamiliaProducto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomP = new javax.swing.JLabel();
        jTextNomP = new javax.swing.JTextField();
        jLabelDescP = new javax.swing.JLabel();
        jTextDescP = new javax.swing.JTextField();
        jLabelPrecioC = new javax.swing.JLabel();
        jTextPrecioC = new javax.swing.JTextField();
        jLabelProducto = new javax.swing.JLabel();
        jComboBoxFam = new javax.swing.JComboBox<>();
        jLabelFamilia = new javax.swing.JLabel();
        jComboBoxProv = new javax.swing.JComboBox<>();
        jButtonCerrar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCrearFam = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));

        jLabelNomP.setText("Nombre artículo:");

        jLabelDescP.setText("Descripción artículo:");

        jLabelPrecioC.setText("Precio compra:");

        jLabelProducto.setText("Tercero:");

        jComboBoxFam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelFamilia.setText("Familia producto:");

        jComboBoxProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jButtonCrearFam.setText("Crear Familia Prod.");
        jButtonCrearFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearFamActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Añadir Producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCrearFam, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDescP, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPrecioC, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNomP, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextDescP)
                                    .addComponent(jTextPrecioC)
                                    .addComponent(jTextNomP)
                                    .addComponent(jComboBoxProv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxFam, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNomP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextNomP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDescP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecioC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextPrecioC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxProv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCrearFam, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
    	        String nombre = jTextNomP.getText();
    	        String descripcion = jTextDescP.getText();	
    	        double precioCompra = Double.parseDouble(jTextPrecioC.getText());
    	        // Obtener el proveedor seleccionado y su ID
    	        Terceros terceroSeleccionado = (Terceros) jComboBoxProv.getSelectedItem();
    	        // Obtener la familia de productos seleccionada y su ID
    	        FamiliaProducto familiaSeleccionada = (FamiliaProducto) jComboBoxFam.getSelectedItem();
    	        ProductosController.crearProducto(nombre, descripcion, precioCompra, terceroSeleccionado, familiaSeleccionada);
    	        HibernateUtil.abrirVentana(new ProductosView(), "Productos");
    	        HibernateUtil.cerrarVentana(this);
    	        this.sessionFactory.close();
    	                
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
        HibernateUtil.cerrarVentana(this);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonCrearFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearFamActionPerformed
        // TODO add your handling code here:
    	HibernateUtil.abrirVentana(new AddFamiliaProductoView(), "Crear Familia Producto");
    	HibernateUtil.cerrarVentana(this);
    }//GEN-LAST:event_jButtonCrearFamActionPerformed
    
    // A continuación, se añaden los métodos para cargar los proveedores y las familias de productos
    
    private void cargarTerceros() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for (Terceros tercero: TercerosController.getAllProveedores()) {
            model.addElement(tercero);
        }
        
        jComboBoxProv.setModel(model);
    }
    
    private void cargarFamiliaProducto() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for (FamiliaProducto familiaProducto : FamiliaProductoController.getAllFamiliaProducto()) {
            model.addElement(familiaProducto);
        }
        
        jComboBoxFam.setModel(model);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonCrearFam;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboBoxFam;
    private javax.swing.JComboBox<String> jComboBoxProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDescP;
    private javax.swing.JLabel jLabelFamilia;
    private javax.swing.JLabel jLabelNomP;
    private javax.swing.JLabel jLabelPrecioC;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JTextField jTextDescP;
    private javax.swing.JTextField jTextNomP;
    private javax.swing.JTextField jTextPrecioC;
    // End of variables declaration//GEN-END:variables
}
