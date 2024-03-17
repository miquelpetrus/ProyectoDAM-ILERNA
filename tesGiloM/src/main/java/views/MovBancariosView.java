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

import clases.Eventos;
import clases.MovimientosBancarios;
import clases.Socios;
import clases.Terceros;
import controllers.BancosController;
import controllers.HibernateUtil;
import controllers.MovsBancariosController;

/**
 *
 * @author Miquel
 */
public class MovBancariosView extends javax.swing.JPanel {

    private SessionFactory sessionFactory;
    private DefaultTableModel tableModel;
    private MovsBancariosController movsBancariosController;
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
        actualizaSaldos();
    }
    
    private void initializeTableModel() {
        Object[] columnNames = {"Fecha", "Evento", "Tercero", "Socio", "Observaciones", "Ingreso", "Gasto"};
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
        int[] columnWidths = {80, 150, 150, 180, 150, 100, 100}; // Ajusta los tamaños según tus necesidades

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
                            movbanc.getFechaEnFormato(),
                            movbanc.getEvento().getNombre(),
                            (tercero != null) ? tercero.getNombre() : "",
                            (socio != null) ? socio.getNombre() : "",
                            movbanc.getConcepto(),
                            movbanc.getImporte() + "€",
                            0 // Gasto será 0 ya que es un ingreso
                        });
                    } else {
                        tableModel.addRow(new Object[]{
                            movbanc.getFechaEnFormato(),
                            movbanc.getEvento().getNombre(),
                            (tercero != null) ? tercero.getId() : "",
                            (socio != null) ? socio.getNombre() : "",
                            movbanc.getConcepto(),
                            0, // Ingreso será 0 ya que es un gasto
                            movbanc.getImporte() + "€"
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
        jLabelNomBanco = new javax.swing.JLabel();
        jLabelIngresos = new javax.swing.JLabel();
        jLabelGastos = new javax.swing.JLabel();
        jLabelSaldo = new javax.swing.JLabel();
        jLabelIngresosR = new javax.swing.JLabel();
        jLabelGastosR = new javax.swing.JLabel();
        jLabelSaldoR = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));

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
        jTableMovs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMovsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMovs);

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jLabelNomBanco.setBackground(new java.awt.Color(0, 102, 255));
        jLabelNomBanco.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelNomBanco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelIngresos.setText("Ingresos");

        jLabelGastos.setText("Gastos");

        jLabelSaldo.setText("Saldo");

        jLabelIngresosR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelGastosR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabelSaldoR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movimientos Bancarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIngresosR, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSaldoR, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelGastosR, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabelEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFiltrarAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelNomBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(555, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelEjercicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFiltrarAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNomBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIngresosR, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelGastosR, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelSaldoR, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
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

    private void jTableMovsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMovsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableMovsMouseClicked
    
    private void filterMovimientosByYear(int year) {
        // Definir nombres de las columnas
        String[] columnNames = {"Fecha", "Evento", "Tercero", "Socio", "Ingreso", "Gasto"};

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
        int[] columnWidths = {80, 150, 150, 180, 100, 100}; // Ajusta los tamaños según tus necesidades

        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = jTableMovs.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
        
        // Calcular los saldos después de filtrar los movimientos por año
        double sumaIngresos = movsBancariosController.calcularSumaIngresos(year);
        double sumaGastos = movsBancariosController.calcularSumaGastos(year);
        double saldo = movsBancariosController.calcularSaldo(year);

        // Actualizar las etiquetas con los nuevos saldos
        jLabelIngresosR.setText(String.valueOf(sumaIngresos) + "€");
        jLabelGastosR.setText(String.valueOf(sumaGastos) + "€");
        jLabelSaldoR.setText(String.valueOf(saldo) + "€");

    }
    
	private void actualizaSaldos() {
	    movsBancariosController = new MovsBancariosController();

	    double sumaIngresos = movsBancariosController.calcularSumaIngresos();
	    double sumaGastos = movsBancariosController.calcularSumaGastos();
	    double saldo = movsBancariosController.calcularSaldo();

	    jLabelIngresosR.setText(String.valueOf(sumaIngresos) + "€");
	    jLabelGastosR.setText(String.valueOf(sumaGastos) + "€");
	    jLabelSaldoR.setText(String.valueOf(saldo) + "€");
	}
	


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonFiltrarAnio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEjercicio;
    private javax.swing.JLabel jLabelGastos;
    private javax.swing.JLabel jLabelGastosR;
    private javax.swing.JLabel jLabelIngresos;
    private javax.swing.JLabel jLabelIngresosR;
    private javax.swing.JLabel jLabelNomBanco;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JLabel jLabelSaldoR;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMovs;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables
}
