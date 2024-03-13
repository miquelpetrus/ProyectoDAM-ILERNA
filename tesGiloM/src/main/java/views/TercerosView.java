/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.Productos;
import clases.Terceros;
import controllers.HibernateUtil;
import controllers.SociosController;

/**
 *
 * @author miquelpetrus
 */
public class TercerosView extends javax.swing.JPanel {

    /**
     * Creates new form ProveedoresView
     */
    private DefaultTableModel tableModel;
    private SessionFactory sessionFactory;
    
    public TercerosView() {
        initComponents();
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        initializeTableModel();
        loadTerceroData();
    }
    
    private void initializeTableModel() {
        Object[] columnNames = {"Id", "Nombre", "CIF", "Teléfono", "Email", "Dirección"};
        Object[][] data = {};  // Puedes inicializarlo con datos si los tienes al inicio
        tableModel = new DefaultTableModel(data, columnNames) {
            private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                // Deshabilitar la edición directa de celdas
                return false;
            }
        };
        jTable1.setModel(tableModel);
        
        // Establecer el tamaño de las columnas
        int[] columnWidths = {30, 150, 80, 80, 170, 170}; // Ajusta los tamaños según tus necesidades

        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = jTable1.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
    }
    
    private void loadTerceroData() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Utiliza HQL para obtener todos los usuarios de la base de datos
                String hql = "FROM Terceros";
                Query<Terceros> query = session.createQuery(hql, Terceros.class);
                List<Terceros> terceros = query.list();

                // Limpia la tabla antes de cargar nuevos datos
                tableModel.setRowCount(0);

                // Agrega los usuarios al modelo de la tabla
                for (Terceros tercero : terceros) {
                    tableModel.addRow(new Object[]{
                    		tercero.getId(),
                    		tercero.getNombre(),
                    		tercero.getCif(),
                    		tercero.getTelefono(),
                    		tercero.getEmail(),
                    		tercero.getDireccion(),
                    });
                }

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                // Maneja cualquier excepción que pueda ocurrir al cargar datos
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
        jButtonCrearProv = new javax.swing.JButton();
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

        jButtonCrearProv.setText("Crear Tercero");
        jButtonCrearProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearProvActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Terceros");

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
                        .addGap(134, 134, 134)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCrearProv, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(497, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCrearProv, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
    	HibernateUtil.cerrarVentana(jTable1);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonCrearProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearProvActionPerformed
        // TODO add your handling code here:
    	HibernateUtil.abrirVentana(new AddTercerosView(), "Crear Tercero");
    	HibernateUtil.cerrarVentana(this);
    }//GEN-LAST:event_jButtonCrearProvActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int column = jTable1.getSelectedColumn();

        // Verifica que el clic sea en una fila válida
        if (row != -1 && column != -1) {
            // Obtén los datos de la fila seleccionada
            Object[] datosFila = new Object[tableModel.getColumnCount()];
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                datosFila[i] = tableModel.getValueAt(row, i);
            }

            // Muestra un menú emergente con opciones
            javax.swing.JPopupMenu popupMenu = new javax.swing.JPopupMenu();

            // Opción para editar el evento
            javax.swing.JMenuItem editarMenuItem = new javax.swing.JMenuItem("Editar Socio");
            editarMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    abrirVistaEdicion(datosFila);
                }
            });
            popupMenu.add(editarMenuItem);
            
            // Opción para eliminar el evento
            javax.swing.JMenuItem eliminarMenuItem = new javax.swing.JMenuItem("Eliminar Socio");
            eliminarMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                	//Elimina el usuario
                	SociosController.eliminarSocio((int) datosFila[0]);
                	//Actualiza la tabla
                	loadTerceroData();
                }
            });
            popupMenu.add(eliminarMenuItem);
            
            // Muestra el menú emergente en la posición del clic
            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    	
    }//GEN-LAST:event_jTable1MouseClicked
    
	private void abrirVistaEdicion(Object[] datosFila) {
		// Abre la vista de edición
		HibernateUtil.abrirVentana(new EditTercerosView(datosFila), "Editar Tercero");
		HibernateUtil.cerrarVentana(this);
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonCrearProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
