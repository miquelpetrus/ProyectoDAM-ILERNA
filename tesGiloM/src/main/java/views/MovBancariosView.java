/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.MovimientosBancarios;
import clases.Socios;
import clases.Terceros;
import controllers.BancosController;
import controllers.HibernateUtil;

/**
 *
 * @author Miquel
 */
public class MovBancariosView extends javax.swing.JPanel {

    private SessionFactory sessionFactory;
    private DefaultTableModel tableModel;
	/**
     * Creates new form MovBancariosView
     */
    public MovBancariosView(int idBanco) {
        initComponents();
        this.sessionFactory = HibernateUtil.buildSessionFactory();
        int bancoId = idBanco;
        initializeTableModel();      
        loadBancosData(idBanco);
        jLabelNomBanco.setText(BancosController.getBancosById(idBanco).getNombre() + " " + BancosController.getBancosById(idBanco).getIban());
    }
    
    private void initializeTableModel() {
        Object[] columnNames = {"Fecha", "Tercero", "Socio", "Ingreso", "Gasto"};
        Object[][] data = {};  // Puedes inicializarlo con datos si los tienes al inicio
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Deshabilitar la edición directa de celdas
                return false;
            }
        };
        jTableMovs.setModel(tableModel);
        
        // Establecer el tamaño de las columnas
        int[] columnWidths = {80, 150, 180, 100, 100}; // Ajusta los tamaños según tus necesidades

        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = jTableMovs.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
    }
    
    private void loadBancosData(int idBanco) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Utiliza HQL para obtener todos los movimientos bancarios de tipo "Ingreso"
                String hqlIngresos = "FROM MovimientosBancarios WHERE tipo = 'Ingreso' AND idBanco = " + idBanco;
                Query<MovimientosBancarios> queryIngresos = session.createQuery(hqlIngresos, MovimientosBancarios.class);
                List<MovimientosBancarios> movsbancosIngresos = queryIngresos.list();

                // Utiliza HQL para obtener todos los movimientos bancarios de tipo "Gastos"
                String hqlGastos = "FROM MovimientosBancarios WHERE tipo = 'Gasto' AND idBanco = " + idBanco;
                Query<MovimientosBancarios> queryGastos = session.createQuery(hqlGastos, MovimientosBancarios.class);
                List<MovimientosBancarios> movsbancosGastos = queryGastos.list();

                // Combina las listas de movimientos bancarios de ingresos y gastos en una sola lista
                List<MovimientosBancarios> allMovsbancos = new ArrayList<>();
                allMovsbancos.addAll(movsbancosIngresos);
                allMovsbancos.addAll(movsbancosGastos);

                // Ordena la lista combinada por fecha
                Collections.sort(allMovsbancos, Comparator.comparing(MovimientosBancarios::getFecha));

                // Limpia la tabla antes de cargar nuevos datos
                tableModel.setRowCount(0);
                

                // Agrega los movimientos bancarios al modelo de la tabla
                for (MovimientosBancarios movbanc : allMovsbancos) {
                	Terceros tercero = session.get(Terceros.class, movbanc.getIdTercero());
                	Socios socio = session.get(Socios.class, movbanc.getIdSocio());
                    // Determina si es un ingreso o un gasto
                    if (movbanc.getTipo().equals("Ingreso")) {
                        tableModel.addRow(new Object[]{
                            movbanc.getFecha(),
                            (tercero != null) ? tercero.getNombre() : "",
                            (socio != null) ? socio.getNombre() : "",
                            movbanc.getCantidad(),
                            0 // Gasto será 0 ya que es un ingreso
                        });
                    } else {
                        tableModel.addRow(new Object[]{
                            movbanc.getFecha(),
                            (tercero != null) ? tercero.getNombre() : "",
                            (socio != null) ? socio.getNombre() : "",
                            0, // Ingreso será 0 ya que es un gasto
                            movbanc.getCantidad()
                        });
                    }
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

        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabelEjercicio = new javax.swing.JLabel();
        jButtonFiltrarAnio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMovs = new javax.swing.JTable();
        jButtonCerrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTotals = new javax.swing.JTable();
        jLabelNomBanco = new javax.swing.JLabel();

        jLabelEjercicio.setText("Ejercicio:");

        jButtonFiltrarAnio.setText("Seleccionar");
        jButtonFiltrarAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarAnioActionPerformed(evt);
            }
        });

        jTableMovs.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableMovs);

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jTableTotals.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableTotals);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonFiltrarAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(119, 119, 119)
                            .addComponent(jLabelNomBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelEjercicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFiltrarAnio, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabelNomBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFiltrarAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarAnioActionPerformed
        // TODO add your handling code here:
        // Obtener el año seleccionado por el usuario
        int year = jYearChooser1.getYear();
        
        // Filtrar los movimientos bancarios por el año seleccionado
        filterMovimientosByYear(year);
        
    }//GEN-LAST:event_jButtonFiltrarAnioActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
    	HibernateUtil.cerrarVentana(this);
    }//GEN-LAST:event_jButtonCerrarActionPerformed
    
    private void filterMovimientosByYear(int year) {
        // Definir nombres de las columnas
        String[] columnNames = {"Fecha", "Tercero", "Socio", "Ingreso", "Gasto"};

        // Crear un nuevo modelo filtrado con los nombres de las columnas definidos
        DefaultTableModel filteredModel = new DefaultTableModel(null, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Recorrer cada fila de la tabla actual
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            // Obtener la fecha de la fila actual
            Timestamp timestamp = (Timestamp) tableModel.getValueAt(i, 0); // Suponiendo que la fecha está almacenada como Timestamp

            // Convertir la fecha a LocalDate para obtener el año
            LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
            int rowYear = localDate.getYear();

            // Si la fecha corresponde al año seleccionado, agregar la fila al modelo filtrado
            if (rowYear == year) {
                Object[] rowData = new Object[columnNames.length];
                for (int j = 0; j < rowData.length; j++) {
                    rowData[j] = tableModel.getValueAt(i, j);
                }
                filteredModel.addRow(rowData);
            }
        }
        
        // Establecer el modelo filtrado en la tabla
        jTableMovs.setModel(filteredModel);
        
        // Establecer el tamaño de las columnas
        int[] columnWidths = {80, 150, 180, 100, 100}; // Ajusta los tamaños según tus necesidades

        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = jTableMovs.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonFiltrarAnio;
    private javax.swing.JLabel jLabelEjercicio;
    private javax.swing.JLabel jLabelNomBanco;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMovs;
    private javax.swing.JTable jTableTotals;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables
}
