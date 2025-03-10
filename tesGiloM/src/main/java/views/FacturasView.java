/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.util.List;

import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.Bancos;
import clases.Facturas;
import controllers.HibernateUtil;
import controllers.MovsBancariosController;

/**
 *
 * @author Miquel
 */
public class FacturasView extends javax.swing.JPanel {
	
    private DefaultTableModel tableModel;
    private SessionFactory sessionFactory;

    /**
     * Creates new form FacturasView
     */
    public FacturasView() {
        initComponents();
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        initializeTableModel();
        loadFacturasData(); // lo arrango así para que se cargue la tabla al iniciar el panel
        // Es una chapucilla, pero así siempre tengo las lineas de facturas actualizadas
        Timer timer = new Timer(5000, e -> loadFacturasData());
        // Inicia el temporizador
        timer.start();
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});
    }
    
    private void initializeTableModel() {
        Object[] columnNames = {"Nº Fac.", "Fecha", "Proveedor", "Precio", "IVA", "Total", "pagado", "Evento", "idBanco"};
        Object[][] data = {};  // Puedes inicializarlo con datos si los tienes al inicio
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Deshabilitar la edición directa de celdas
                return false;
            }
        };
        jTable1.setModel(tableModel);
        // Establecer el tamaño de las columnas
        int[] columnWidths = {80, 100, 150, 70, 70, 70, 90, 150, 70}; // Ajusta los tamaños según tus necesidades

        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = jTable1.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
    }
    
    private void loadFacturasData() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Utiliza HQL para obtener todas las facturas de la base de datos
                String hql = "FROM Facturas";
                Query<Facturas> query = session.createQuery(hql, Facturas.class);
                List<Facturas> facturas = query.list();

                // Limpia la tabla antes de cargar nuevos datos
                tableModel.setRowCount(0);

                // Agrega las facturas al modelo de la tabla
                for (Facturas factura : facturas) {
                    Object[] rowData = new Object[]{
                            factura.getIdFactura(),
                            factura.getFechaEnFormato(),
                            factura.getTerceros().getNombre(),
                            factura.getBaseImponible(),
                            factura.getIva(),
                            factura.getTotal(),
                            factura.isPagado(),
                            factura.getIdEvento(),
                            (factura.getBanco() != null) ? factura.getBanco().getId() : "null" // Manejo de valores null
                    };
                    tableModel.addRow(rowData);
                }

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonCerrar = new javax.swing.JButton();
        jButtonAniadirFac = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonAniadirFac.setText("Añadir Factura");
        jButtonAniadirFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAniadirFacActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Facturas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAniadirFac, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(483, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAniadirFac, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAniadirFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAniadirFacActionPerformed
        // TODO add your handling code here:
		try {
			HibernateUtil.abrirVentana(new AddFacturaView(), "Añadir factura");
			HibernateUtil.cerrarVentana(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }//GEN-LAST:event_jButtonAniadirFacActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
    	HibernateUtil.cerrarVentana(this);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // Obtengo la fila y columna en la que se hizo clic
        int row = jTable1.getSelectedRow();
        int column = jTable1.getSelectedColumn();

        // Verifica que el clic sea en una fila válida
        if (row != -1 && column != -1) {
            // Obtén el número de factura de la fila seleccionada
            String numeroFactura = (String) jTable1.getValueAt(row, 0);
            javax.swing.JPopupMenu popupMenu = new javax.swing.JPopupMenu();

            // Muestra un menú emergente con opciones, por ejemplo, "Pagar Factura"
            javax.swing.JMenuItem pagarMenuItem = new javax.swing.JMenuItem("Pagar Factura");
            pagarMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                	
                    pagarFactura(numeroFactura);
                }
            });
            popupMenu.add(pagarMenuItem);
            
            // Muestra un menú emergente para "Asignar Banco Factura"
            javax.swing.JMenuItem selectBancoMenuItem = new javax.swing.JMenuItem("Asignar Banco");
            selectBancoMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                	
                    HibernateUtil.abrirVentana(new SelectBanco(numeroFactura), "Asignar Banco a Factura");
                }
            });
            popupMenu.add(selectBancoMenuItem);

            // Muestra el menú emergente en la posición del clic
            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Método para procesar el pago de la factura
    private void pagarFactura(String numeroFactura) {
        System.out.println("Factura pagada: " + numeroFactura);
        // Mandamos al controlador de facturas para que registre el movimiento de gasto y marque la factura como pagada
        MovsBancariosController.pagarFactura(numeroFactura);
        // Actualiza la tabla después de pagar la factura
        loadFacturasData();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAniadirFac;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
