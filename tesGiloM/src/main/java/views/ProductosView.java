package views;

import clases.Productos;
import controllers.HibernateUtil;
import controllers.ProductosController;

import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author miquelpetrus
 */
public class ProductosView extends javax.swing.JPanel {

    /**
     * Creates new form ProductosView
     */
    private DefaultTableModel tableModel;
    private SessionFactory sessionFactory;
    
    public ProductosView() {
        initComponents();
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        initializeTableModel();
        loadProductData();
    }

    private void initializeTableModel() {
        Object[] columnNames = {"id", "Nombre", "Descripción", "precio", "Família", "Proveedor"};
        Object[][] data = {};  // Puedes inicializarlo con datos si los tienes al inicio
        tableModel = new DefaultTableModel(data, columnNames) {
            private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                // Deshabilitar la edición directa de celdas
                return false;
            }
        };
        jTableProducts.setModel(tableModel);
        
        // Establecer el tamaño de las columnas
        int[] columnWidths = {30, 150, 180, 70, 100, 150}; // Ajusta los tamaños según tus necesidades

        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = jTableProducts.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
    }
    
    private void loadProductData() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Utiliza HQL para obtener todos los usuarios de la base de datos
                String hql = "FROM Productos";
                Query<Productos> query = session.createQuery(hql, Productos.class);
                List<Productos> productos = query.list();

                // Limpia la tabla antes de cargar nuevos datos
                tableModel.setRowCount(0);

                // Agrega los usuarios al modelo de la tabla
                for (Productos producto : productos) {
                    tableModel.addRow(new Object[]{
                            producto.getId(),
                            producto.getNombre(),
                            producto.getDescripcion(),
                            producto.getPrecio(),
                            producto.getIdFamilia(),
                            producto.getIdTercero(),
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
        jTableProducts = new javax.swing.JTable();
        jButtonCerrar = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProducts);

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonAdd.setText("Crear Producto");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(357, 357, 357))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(190, 190, 190)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(630, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(512, Short.MAX_VALUE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
            try {

            HibernateUtil.abrirVentana(new AddProductosView(), "Crear Producto");         
            HibernateUtil.cerrarVentana(jTableProducts);

        } catch (Exception e) {
            e.printStackTrace();
		} 
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTableProducts.getSelectedRow();
        int column = jTableProducts.getSelectedColumn();

        // Verifica que el clic sea en una fila válida
        if (row != -1 && column != -1) {
            // Obtén los datos de la fila seleccionada
            Object[] datosFila = new Object[tableModel.getColumnCount()];
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                datosFila[i] = tableModel.getValueAt(row, i);
            }

            // Muestra un menú emergente con opciones
            javax.swing.JPopupMenu popupMenu = new javax.swing.JPopupMenu();

            // Opción para editar el producto
            javax.swing.JMenuItem editarMenuItem = new javax.swing.JMenuItem("Editar Producto");
            editarMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    abrirVistaEdicion(datosFila);
                }
            });
            popupMenu.add(editarMenuItem);

            // Opción para eliminar el producto
            javax.swing.JMenuItem eliminarMenuItem = new javax.swing.JMenuItem("Eliminar Producto");
            eliminarMenuItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    // Aquí puedes llamar al método para procesar la eliminación del producto
                    eliminarProducto(datosFila);
                }
            });
            popupMenu.add(eliminarMenuItem);

            // Muestra el menú emergente en la posición del clic
            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        HibernateUtil.cerrarVentana(this);
    }
    
 // Método para abrir la vista de edición con los datos de la fila
    private void abrirVistaEdicion(Object[] datosFila) {
        // Crea una nueva instancia de la vista de edición y pásale los datos
        HibernateUtil.abrirVentana(new EditarProductosView(datosFila), "Editar Producto");
    }
    
	private void eliminarProducto(Object[] datosFila) {
	    try {
	        // Obtén el ID del producto a partir de los datos de la fila
	        int idProducto = (int) datosFila[0]; // Ajusta según la posición del ID en tus datos

	        // Llama al método del controlador para eliminar el producto
	        ProductosController.eliminarProducto(idProducto);

	        // Actualiza la tabla después de eliminar el producto
	        loadProductData();
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Maneja cualquier excepción que pueda ocurrir al eliminar el producto
	    }
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    // End of variables declaration//GEN-END:variables
}
