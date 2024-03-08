package controllers;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import clases.Ingresos;
import clases.MovimientosBancarios;


public class IngresosController {
	
	public static List<MovimientosBancarios> getAllIngresos() {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			String hql = "FROM MovimientosBancarios WHERE tipoMovimiento = 'Ingreso'";
			Query<MovimientosBancarios> query = session.createQuery(hql, MovimientosBancarios.class);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static void crearIngreso(Date fecha, int idTercero, int idSocio, int idEvento, double importe) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				// Aquí debes realizar la lógica para crear un nuevo producto
				// Puedes utilizar la entidad de productos y persistirla en la base de datos

				// Ejemplo (debes adaptarlo a tu modelo de datos):
				Ingresos nuevoIngreso = new Ingresos();
                nuevoIngreso.setFecha(fecha);
                nuevoIngreso.setIdTercero(idTercero);
                nuevoIngreso.setIdSocio(idSocio);
                nuevoIngreso.setIdEvento(idEvento);
                nuevoIngreso.setImporte(importe);

				session.save(nuevoIngreso);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
		}
	}

	public static Ingresos getIngresoById(int id) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			return session.get(Ingresos.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null; // or throw an exception based on your error handling strategy
		}
	}


}
