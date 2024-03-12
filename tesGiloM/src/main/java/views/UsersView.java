package views;

import clases.Users;
import controllers.HibernateUtil;
import controllers.UsersController;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.awt.Window;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author miquelpetrus
 */
public class UsersView extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private DefaultTableModel tableModel;
    private SessionFactory sessionFactory;

    public UsersView() {
        initComponents();
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        initializeTableModel();
        loadUserData();
    }

    private void initializeTableModel() {
        Object[] columnNames = {"id", "Nombre", "Apellido 1", "Apellido 2", "NIF", "Email", "Password"};
        Object[][] data = {};  // Puedes inicializarlo con datos si los tienes al inicio
        tableModel = new DefaultTableModel(data, columnNames) {
            private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                // Deshabilitar la edición directa de celdas
                return false;
            }
        };
        jTableUsers.setModel(tableModel);
        
        // Establecer el tamaño de las columnas
        int[] columnWidths = {30, 150, 150, 150, 90, 180, 250}; // Ajusta los tamaños según tus necesidades

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
                String hql = "FROM Users";
                Query<Users> query = session.createQuery(hql, Users.class);
                List<Users> users = query.list();

                // Limpia la tabla antes de cargar nuevos datos
                tableModel.setRowCount(0);

                // Agrega los usuarios al modelo de la tabla
                for (Users user : users) {
                    tableModel.addRow(new Object[]{
                            user.getId(),
                            user.getName(),
                            user.getApellido1(),
                            user.getApellido2(),
                            user.getNif(),
                            user.getEmail(),
                            user.getPassword()
                    });
                }

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                // Maneja cualquier excepción que pueda ocurrir al cargar datos
            } finally {
                session.close();
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
                "id", "Nombre", "Apellido 1", "Apellido 2", "NIF", "Email", "Rol", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsers);

        jButtonCrearNuevo.setText("Crear Usuario");
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
        jLabel1.setText("Gestión de Usuarios");

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
                        .addGap(133, 133, 133)
                        .addComponent(jButtonCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCrearNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCrearNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jButtonCerrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearNuevoActionPerformed
        // TODO add your handling code here:
        try {

        	HibernateUtil.abrirVentana(new AddUsersView(), "Añadir Usuario");            
            HibernateUtil.cerrarVentana(this);

        } catch (Exception e) {
            e.printStackTrace();
		} finally {
			this.sessionFactory.close();
		}
    }//GEN-LAST:event_jButtonCrearNuevoActionPerformed

    private void jButtonCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrar1ActionPerformed
        // TODO add your handling code here:
    	this.sessionFactory.close();
    	HibernateUtil.cerrarVentana(this);
    }//GEN-LAST:event_jButtonCerrar1ActionPerformed

    private void jTableUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsersMouseClicked
        // TODO add your handling code here:
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
            javax.swing.JMenuItem editarMenuItem = new javax.swing.JMenuItem("Editar Usuario");
            editarMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    abrirVistaEdicion(datosFila);
                }
            });
            popupMenu.add(editarMenuItem);
            
            // Opción para eliminar el evento
            javax.swing.JMenuItem eliminarMenuItem = new javax.swing.JMenuItem("Eliminar Usuario");
            eliminarMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                	//Elimina el usuario
                	UsersController.eliminarUsuario((int) datosFila[0]);
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
        // Abre la vista de edición con los datos de la fila seleccionada
		HibernateUtil.abrirVentana(new EditUsersView(datosFila), "Editar Usuario");
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
