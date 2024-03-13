package controllers;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.Eventos;
import clases.Productos;

public class EventosController {

	private SessionFactory sessionFactory;

	public EventosController() {
		this.sessionFactory = HibernateUtil.buildSessionFactory();
	}

	public static List<Eventos> getAllEventos() {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			String hql = "FROM Eventos";
			Query<Eventos> query = session.createQuery(hql, Eventos.class);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static Eventos getEventoById(int id) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			return session.get(Eventos.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void crearEvento(String nombre, Date fecha, String lugar, String descripcion, int aforo) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				Eventos nuevoEvento = new Eventos();
				nuevoEvento.setNombre(nombre);
				nuevoEvento.setFecha(fecha);
				nuevoEvento.setLugar(lugar);
				nuevoEvento.setDescripcion(descripcion);
				nuevoEvento.setAforo(aforo);

				session.save(nuevoEvento);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al crear el evento");
			} finally {
				session.close();
			}
		}
	}

	public static void actualizarEvento(int id, String nombre, Date fecha, String lugar, String descripcion,
			int aforo) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				Eventos evento = session.get(Eventos.class, id);
				evento.setNombre(nombre);
				evento.setFecha(fecha);
				evento.setLugar(lugar);
				evento.setDescripcion(descripcion);
				evento.setAforo(aforo);

				session.update(evento);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al actualizar el evento");
			} finally {
				session.close();
			}
		}
	}

	public static void eliminarEvento(int id) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				Eventos evento = session.get(Eventos.class, id);
				session.delete(evento);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al eliminar el evento");
			} finally {
				session.close();
			}
		}
	}

}
