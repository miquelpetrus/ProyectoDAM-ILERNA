package controllers;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.Eventos;
import clases.Facturas;
import clases.Ingresos;
import clases.MovimientosBancarios;

public class MovsBancariosController {

	public static List<MovimientosBancarios> getAllIngresos() {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			String hql = "FROM MovimientosBancarios WHERE tipo = 'Ingreso'";
			Query<MovimientosBancarios> query = session.createQuery(hql, MovimientosBancarios.class);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static List<MovimientosBancarios> getAllIngresos(int year) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			String hql = "FROM MovimientosBancarios WHERE tipo = 'Ingreso' AND YEAR(fecha) = :year";
			Query<MovimientosBancarios> query = session.createQuery(hql, MovimientosBancarios.class);
			query.setParameter("year", year);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static List<MovimientosBancarios> getAllGastos() {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			String hql = "FROM MovimientosBancarios WHERE tipo = 'Gasto'";
			Query<MovimientosBancarios> query = session.createQuery(hql, MovimientosBancarios.class);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static List<MovimientosBancarios> getAllGastos(int year) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			String hql = "FROM MovimientosBancarios WHERE tipo = 'Gasto' AND YEAR(fecha) = :year";
			Query<MovimientosBancarios> query = session.createQuery(hql, MovimientosBancarios.class);
			query.setParameter("year", year);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static Ingresos getIngresoById(int id) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			return session.get(Ingresos.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void crearIngreso(Date fecha, int idTercero, int idBanco, int idSocio, Eventos idEvento, String obs, double importe,
			String tipo) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				MovimientosBancarios nuevoIngreso = new MovimientosBancarios();
				nuevoIngreso.setFecha(fecha);
				nuevoIngreso.setIdTercero(idTercero);
				nuevoIngreso.setIdBanco(idBanco);
				nuevoIngreso.setIdSocio(idSocio);
				nuevoIngreso.setEvento(idEvento);
				nuevoIngreso.setConcepto(obs);
				nuevoIngreso.setImporte(importe);
				nuevoIngreso.setTipo(tipo);

				session.save(nuevoIngreso);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					JOptionPane.showMessageDialog(null, "Error al crear el ingreso", "Error",
							JOptionPane.ERROR_MESSAGE);
					transaction.rollback();
				}
				e.printStackTrace();
			}
		}
	}

	public static void crearGasto(Date fecha, int idTercero, int idBanco, int idSocio, Eventos evento, String obs, double importe,
			String tipo) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				MovimientosBancarios nuevoIngreso = new MovimientosBancarios();
				nuevoIngreso.setFecha(fecha);
				nuevoIngreso.setIdTercero(idTercero);
				nuevoIngreso.setIdBanco(idBanco);
				nuevoIngreso.setIdSocio(idSocio);
				nuevoIngreso.setEvento(evento);
				nuevoIngreso.setImporte(importe);
				nuevoIngreso.setConcepto(obs);
				nuevoIngreso.setTipo(tipo);

				session.save(nuevoIngreso);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					JOptionPane.showMessageDialog(null, "Error al crear el gasto", "Error", JOptionPane.ERROR_MESSAGE);
					transaction.rollback();
				}
				e.printStackTrace();
			}
		}
	}
	
    public static void pagarFactura(String idFactura) {
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                String hql = "SELECT fecha, total, idTercero, idEvento, idBanco FROM Facturas WHERE idFactura = :idFactura";
                Query<Object[]> query = session.createQuery(hql);
                query.setParameter("idFactura", idFactura);
                Object[] factura = query.uniqueResult();
                Date fecha = (Date) factura[0];
                double importe = (double) factura[1];
                int idTercero = (int) factura[2];
                int idEvento = (int) factura[3];
                int idBanco = (int) factura[4];

                // Obtenemos el evento y el banco asociado a la factura
                Eventos evento = session.get(Eventos.class, idEvento);

                // Creamos el nuevo gasto en el banco
                MovimientosBancarios nuevoGasto = new MovimientosBancarios();
                nuevoGasto.setFecha(fecha);
                nuevoGasto.setIdTercero(idTercero);
                nuevoGasto.setEvento(evento);
                nuevoGasto.setImporte(importe);
                nuevoGasto.setConcepto("Pago de factura " + idFactura);
                nuevoGasto.setTipo("Gasto");
                nuevoGasto.setIdBanco(idBanco);

                session.save(nuevoGasto);
                
                // Necesito determinar el id de la factura
                String hql2 = "SELECT id FROM Facturas WHERE idFactura = :idFactura";
                Query<Integer> query2 = session.createQuery(hql2);
                query2.setParameter("idFactura", idFactura);
                int id = query2.uniqueResult();

                // Actualizamos el estado de la factura
                Facturas facturaPagada = session.get(Facturas.class, id);
                facturaPagada.setPagado(true);
                session.update(facturaPagada);

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    JOptionPane.showMessageDialog(null, "Error al pagar la factura", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

	public double calcularSumaIngresos() {
		List<MovimientosBancarios> ingresos = getAllIngresos();
		return calcularSuma(ingresos);
	}

	public double calcularSumaGastos() {
		List<MovimientosBancarios> gastos = getAllGastos();
		return calcularSuma(gastos);
	}

	public double calcularSaldo() {
		double sumaIngresos = calcularSumaIngresos();
		double sumaGastos = calcularSumaGastos();
		return sumaIngresos - sumaGastos;
	}

	public double calcularSumaIngresos(int year) {
		List<MovimientosBancarios> ingresos = getAllIngresos(year);
		return calcularSuma(ingresos);
	}

	public double calcularSumaGastos(int year) {
		List<MovimientosBancarios> gastos = getAllGastos(year);
		return calcularSuma(gastos);
	}

	public double calcularSaldo(int year) {
		double sumaIngresos = calcularSumaIngresos(year);
		double sumaGastos = calcularSumaGastos(year);
		return sumaIngresos - sumaGastos;
	}

	// Método genérico para calcular la suma de cantidades en una lista de
	// movimientos
	private double calcularSuma(List<MovimientosBancarios> movimientos) {
		double suma = 0.0;
		for (MovimientosBancarios movimiento : movimientos) {
			suma += movimiento.getImporte();
		}
		return suma;
	}

}
