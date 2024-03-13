package views;

import clases.Socios;
import controllers.HibernateUtil;
import controllers.SociosController;
import controllers.UsersController;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.awt.Window;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author miquelpetrus
 */
public class SociosView extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private SessionFactory sessionFactory;

    public SociosView() {
        initComponents();
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        initializeTableModel();
        loadUserData();
    }

    private void initializeTableModel() {
        Object[] columnNames = {"id", "Nombre", "Apellido 1", "Apellido 2", "NIF", "Email", "Telefono", "Estado"};
        Object[][] data = {};  // Puedes inicializarlo con datos si los tienes al inicio
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Deshabilitar la edición directa de celdas
                return false;
            }
        };
        jTableUsers.setModel(tableModel);
        
        // Establecer el tamaño de las columnas
        int[] columnWidths = {30, 150, 150, 150, 90, 170, 70, 50}; // Ajusta los tamaños según tus necesidades

        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = jTableUsers.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
    }
    
    private void loadUserData() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Utiliza HQL para obtener todos los usuarios de la base de datos
                String hql = "FROM Socios";
                Query<Socios> query = session.createQuery(hql, Socios.class);
                List<Socios> socios = query.list();

                // Limpia la tabla antes de cargar nuevos datos
                tableModel.setRowCount(0);

                // Agrega los usuarios al modelo de la tabla
                for (Socios socio : socios) {
                    tableModel.addRow(new Object[]{
                            socio.getId(),
                            socio.getNombre(),
                            socio.getApellido1(),
                            socio.getApellido2(),
                            socio.getNif(),
                            socio.getEmail(),
                            socio.getTelefono(),
                            socio.isEstado()
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsers = new javax.swing.JTable();
        jButtonCrearNuevo = new javax.swing.JButton();
        jButtonCerrar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));

        jTableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Apellido 1", "Apellido 2", "NIF", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsers);
        if (jTableUsers.getColumnModel().getColumnCount() > 0) {
            jTableUsers.getColumnModel().getColumn(0).setResizable(false);
        }

        jButtonCrearNuevo.setText("Crear Socio");
        jButtonCrearNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearNuevoActionPerformed(evt);
            }
        });

        jButtonCerrar1.setText("Cerrar");
        jButtonCerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrar1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Socios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 554, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jButtonCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCrearNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCrearNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jButtonCerrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearNuevoActionPerformed
        // TODO add your handling code here:
        try {

        	HibernateUtil.abrirVentana(new AddSociosView(), "Crear nuevo socio");
            
        	HibernateUtil.cerrarVentana(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonCrearNuevoActionPerformed

    private void jButtonCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrar1ActionPerformed
        HibernateUtil.cerrarVentana(this);
    }//GEN-LAST:event_jButtonCerrar1ActionPerformed

    private void jTableUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsersMouseClicked
        int row = jTableUsers.getSelectedRow();
        int column = jTableUsers.getSelectedColumn();

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
                	loadUserData();
                }
            });
            popupMenu.add(eliminarMenuItem);
            
            // Muestra el menú emergente en la posición del clic
            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTableUsersMouseClicked
                                  
    
	private void abrirVistaEdicion(Object[] datosFila) {
		HibernateUtil.abrirVentana(new EditSociosView(datosFila), "Editar socio");
		HibernateUtil.cerrarVentana(this);
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar1;
    private javax.swing.JButton jButtonCrearNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsers;
    // End of variables declaration//GEN-END:variables
}
