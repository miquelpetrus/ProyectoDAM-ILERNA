
package views;

import java.util.Date;
import java.util.List;


import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.hibernate.SessionFactory;

import clases.Productos;
import clases.Terceros;
import clases.Eventos;
import clases.LineasFacturas;
import controllers.EventosController;
import controllers.FacturasController;
import controllers.HibernateUtil;
import controllers.ProductosController;
import controllers.TercerosController;
import controllers.UsuarioSesion;

/**
 *
 * @author Miquel
 */
public class AddFacturaView extends javax.swing.JPanel {

	private SessionFactory sessionFactory;
	private DefaultTableModel modeloTabla;
	
	
	private double sumaBaseImponible = 0.0;
	private double sumaIVA = 0.0;
	private double sumaTotal = 0.0;
	
    public AddFacturaView() {
        initComponents();
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        UsuarioSesion.getInstancia();
		int idUsuario = UsuarioSesion.getIdUsuario();
        System.out.println("El id del usuario es: " + idUsuario);
        cargarProveedores();
        cargarProductos();
        cargarEventos();
        initializeTableModel();
    }
    
    private void initializeTableModel() {
        Object[] columnNames = {"idFactura", "idProducto", "cantidad", "precio", "iva", "descuento", "Total"};
        Object[][] data = {};  // Puedes inicializarlo con datos si los tienes al inicio
        modeloTabla = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Deshabilitar la edición directa de celdas
                return false;
            }
        };
        jTable1.setModel(modeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSelectProv = new javax.swing.JLabel();
        jComboBoxProv = new javax.swing.JComboBox<>();
        jLabelSelectProd = new javax.swing.JLabel();
        jComboBoxProd = new javax.swing.JComboBox<>();
        jLabelSelectCant = new javax.swing.JLabel();
        jComboBoxCant = new javax.swing.JComboBox<>();
        jButtonAnyadir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelTotal = new javax.swing.JLabel();
        jTextFieldBaseImponible = new javax.swing.JTextField();
        jTextFieldBaseIVA = new javax.swing.JTextField();
        jTextFieldTotal = new javax.swing.JTextField();
        jButtonCerrar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jLabelSelectIdFac = new javax.swing.JLabel();
        jTextFieldIdFac = new javax.swing.JTextField();
        jLabelSelectIVA = new javax.swing.JLabel();
        jComboBoxIVA = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelEvento = new javax.swing.JLabel();
        jComboBoxEvento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));

        jLabelSelectProv.setText("Selecciona Proveedor");

        jComboBoxProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelSelectProd.setText("Selecciona Producto");

        jComboBoxProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelSelectCant.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSelectCant.setText("Cantidad: ");

        jComboBoxCant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jButtonAnyadir.setText("Añadir");
        jButtonAnyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnyadirActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabelTotal.setText("Total Factura");

        jTextFieldBaseImponible.setEditable(false);
        jTextFieldBaseImponible.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldBaseIVA.setEditable(false);
        jTextFieldBaseIVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextFieldTotal.setEditable(false);
        jTextFieldTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Grabar Factura");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jLabelSelectIdFac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSelectIdFac.setText("Nº Factura: ");

        jLabelSelectIVA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSelectIVA.setText("IVA: ");

        jComboBoxIVA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "21", "10", "4", "0", " " }));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Fecha fact: ");

        jLabel2.setText("Base Imponible");

        jLabel3.setText("IVA");

        jLabel4.setText("Total");

        jLabelEvento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelEvento.setText("Evento:");

        jComboBoxEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Crear Factura");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 268, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBaseImponible, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldBaseIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelSelectProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelSelectProv, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxProv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxProd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSelectIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelSelectCant, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAnyadir, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabelSelectIdFac, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldIdFac, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSelectIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSelectCant, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCant, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelSelectProv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxProv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSelectIdFac, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIdFac, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSelectProd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxProd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAnyadir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBaseIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBaseImponible, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
    	HibernateUtil.cerrarVentana(this);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        // Obtener la información necesaria para la factura
        String idFactura = jTextFieldIdFac.getText();
        Terceros proveedorSeleccionado = (Terceros) jComboBoxProv.getSelectedItem();
        // Otros datos necesarios para la factura (fecha, etc.)
        Date fecha = jDateChooser1.getDate();
        // Obtener las sumas desde los JTextField
        double baseImponible = Double.parseDouble(jTextFieldBaseImponible.getText());
        double baseIVA = Double.parseDouble(jTextFieldBaseIVA.getText());
        double total = Double.parseDouble(jTextFieldTotal.getText());
        UsuarioSesion.getInstancia();
		int idUsuario = UsuarioSesion.getIdUsuario();
		Eventos eventoSeleccionado = (Eventos) jComboBoxEvento.getSelectedItem();
		int idEvento = eventoSeleccionado.getId();

        // Llamar al método de FacturasController para guardar la factura
        FacturasController.guardarFactura(idFactura, proveedorSeleccionado, fecha, baseImponible, baseIVA, total, idUsuario, idEvento);
        HibernateUtil.abrirVentana(new FacturasView(), "Facturas");
        HibernateUtil.cerrarVentana(this);
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonAnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnyadirActionPerformed
        // TODO add your handling code here:
		String idFactura = jTextFieldIdFac.getText();
	    Terceros proveedorSeleccionado = (Terceros) jComboBoxProv.getSelectedItem();
        int idProveedor = proveedorSeleccionado.getId();
	    Productos productoSeleccionado = (Productos) jComboBoxProd.getSelectedItem();
        int idProducto = productoSeleccionado.getId();
	    int cantidad = Integer.parseInt((String) jComboBoxCant.getSelectedItem());
	    int iva = Integer.parseInt((String) jComboBoxIVA.getSelectedItem());
	    double total = 0;
	    boolean traspasado = false;
	    
	    // Llamar al controlador para insertar en LineasFacturas
	    FacturasController.insertarLineaFactura(idFactura, idProveedor, idProducto, cantidad, iva, total, traspasado);

	    // Actualizar la tabla o realizar cualquier acción adicional si es necesario
	    actualizarTabla(idFactura);
    }//GEN-LAST:event_jButtonAnyadirActionPerformed
	
	private void actualizarTabla(String idFactura) {
	    // Limpiar els contenido actual de la tabla
	    modeloTabla.setRowCount(0);

	    // Obtener las líneas de factura de la base de datos para un idFactura específico
	    List<LineasFacturas> lineasFacturas = FacturasController.getLineasFacturasByIdFactura(idFactura);

	    // Llenar la tabla con las líneas de factura para el idFactura específico
	    for (LineasFacturas lineaFactura : lineasFacturas) {
	        Object[] fila = {
	        	lineaFactura.getIdFactura(),
	            lineaFactura.getIdProducto(),   
	            lineaFactura.getCantidad(),
	            lineaFactura.getPrecio(),
	            lineaFactura.getIva(),
	            lineaFactura.getDescuento(),
	            lineaFactura.getTotal()
	        };
	        modeloTabla.addRow(fila);
	        
	        // Actualizar las sumas
	        sumaBaseImponible += lineaFactura.getPrecio() * lineaFactura.getCantidad();
	        sumaIVA += lineaFactura.getIva();
	        sumaTotal += lineaFactura.getTotal();
	    }
	    
	    // Actualizar los JTextField con las sumas calculadas
	    jTextFieldBaseImponible.setText(String.valueOf(sumaBaseImponible));
	    jTextFieldBaseIVA.setText(String.valueOf(sumaIVA));
	    jTextFieldTotal.setText(String.valueOf(sumaTotal));
	    
	    // Asignar el modelo actualizado a la tabla
	    jTable1.setModel(modeloTabla);
	}

    
    private void cargarProveedores() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for (Terceros proveedor : TercerosController.getAllProveedores()) {
            model.addElement(proveedor);
        }
        
        jComboBoxProv.setModel(model);
    }
    
    private void cargarProductos() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for (Productos productos : ProductosController.getAllProductos()) {
            model.addElement(productos);
        }
        
        jComboBoxProd.setModel(model);
    }
    
    private void cargarEventos() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for (Eventos evento : EventosController.getAllEventos()) {
            model.addElement(evento);
        }
        
        jComboBoxEvento.setModel(model);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnyadir;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboBoxCant;
    private javax.swing.JComboBox<String> jComboBoxEvento;
    private javax.swing.JComboBox<String> jComboBoxIVA;
    private javax.swing.JComboBox<String> jComboBoxProd;
    private javax.swing.JComboBox<String> jComboBoxProv;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelEvento;
    private javax.swing.JLabel jLabelSelectCant;
    private javax.swing.JLabel jLabelSelectIVA;
    private javax.swing.JLabel jLabelSelectIdFac;
    private javax.swing.JLabel jLabelSelectProd;
    private javax.swing.JLabel jLabelSelectProv;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldBaseIVA;
    private javax.swing.JTextField jTextFieldBaseImponible;
    private javax.swing.JTextField jTextFieldIdFac;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
