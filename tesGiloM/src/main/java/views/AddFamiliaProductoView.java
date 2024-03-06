package views;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.FamiliaProducto;
import controllers.HibernateUtil;

/**
 *
 * @author miquelpetrus
 */
public class AddFamiliaProductoView extends javax.swing.JPanel {

    private SessionFactory sessionFactory;
	/**
     * Creates new form FamiliaProducto
     */
    public AddFamiliaProductoView() {
        initComponents();
        this.sessionFactory = HibernateUtil.buildSessionFactory();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextNombre = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jTextDesc = new javax.swing.JTextField();
        jLabeDesc = new javax.swing.JLabel();
        jButtonCerrar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();

        jLabelNombre.setText("Nombre:");

        jLabeDesc.setText("Descripción:");

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Guardar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabeDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextNombre)
                            .addComponent(jTextDesc)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed

        HibernateUtil.cerrarVentana(this);
    	
    	
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        // Guardar los datos
    	String nombre = jTextNombre.getText();
    	String desc = jTextDesc.getText();
    	
    	FamiliaProducto familiaProducto = new FamiliaProducto();
    	familiaProducto.setNombre(nombre);
    	familiaProducto.setDescripcion(desc);
    	
        try (Session session = sessionFactory.openSession()) {
            // Iniciar una transacción
            Transaction tx = session.beginTransaction();

            // Guardar la nueva entidad en la base de datos
            session.save(familiaProducto);

            // Confirmar la transacción
            tx.commit();

            // Cerrar la sesión
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar cualquier excepción que pueda ocurrir al guardar datos
        }
        sessionFactory.close();
    	HibernateUtil.cerrarVentana(this);
    	HibernateUtil.abrirVentana(new ProductosView(), "Productos");
    }//GEN-LAST:event_jButtonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JLabel jLabeDesc;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JTextField jTextDesc;
    private javax.swing.JTextField jTextNombre;
    // End of variables declaration//GEN-END:variables
}
