package views;

import clases.Users;
import controllers.HibernateUtil;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
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
        Object[] columnNames = {"id", "Nombre", "Apellido 1", "Apellido 2", "NIF", "Email", "Rol", "Password"};
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
                            user.getRole(),
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jButtonCrearNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jButtonCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(814, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonCrearNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(589, 589, 589)
                    .addComponent(jButtonCerrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearNuevoActionPerformed
        // TODO add your handling code here:
        try {

            AddUsersView addUsersView = new AddUsersView();

            // Crear un nuevo JFrame para la ventana de socios
            JFrame addUsersFrame = new JFrame("Añadir nuevo usuario");
            addUsersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addUsersFrame.getContentPane().add(addUsersView);
            addUsersFrame.pack();
            addUsersFrame.setVisible(true);
            addUsersFrame.setLocationRelativeTo(null);
            
            Window window = SwingUtilities.getWindowAncestor(this);
            // Cerrar la ventana actual
            window.dispose();

        } catch (Exception e) {
            e.printStackTrace();
		} finally {
			this.sessionFactory.close();
		}
    }//GEN-LAST:event_jButtonCrearNuevoActionPerformed

    private void jButtonCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrar1ActionPerformed
        // TODO add your handling code here:
    	this.sessionFactory.close();
        Window window = SwingUtilities.getWindowAncestor(this);
        // Cerrar la ventana actual
        window.dispose();
    }//GEN-LAST:event_jButtonCerrar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar1;
    private javax.swing.JButton jButtonCrearNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsers;
    // End of variables declaration//GEN-END:variables
}
