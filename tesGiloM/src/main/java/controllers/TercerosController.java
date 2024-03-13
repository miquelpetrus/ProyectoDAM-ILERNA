package controllers;

import clases.Terceros;

import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TercerosController {

	public static List<Terceros> getAllProveedores() {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			String hql = "FROM Terceros";
			Query<Terceros> query = session.createQuery(hql, Terceros.class);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static Terceros getProveedorById(int id) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			return session.get(Terceros.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void crearTercero(String nombre, String cif, String direccion, String telefono, String email) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				Terceros nuevoTercero = new Terceros();
				nuevoTercero.setCif(cif);
				nuevoTercero.setNombre(nombre);
				nuevoTercero.setDireccion(direccion);
				nuevoTercero.setTelefono(telefono);
				nuevoTercero.setEmail(email);

				session.save(nuevoTercero);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al crear el tercero");
			} finally {
				session.close();
			}
		}
	}

	public void actualizarTercero(int id, String nombre, String cif, String direccion, String telefono, String email) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				Terceros tercero = session.get(Terceros.class, id);
				tercero.setCif(cif);
				tercero.setNombre(nombre);
				tercero.setDireccion(direccion);
				tercero.setTelefono(telefono);
				tercero.setEmail(email);

				session.update(tercero);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al actualizar el tercero");
			} finally {
				session.close();
			}
		}
	}

	public void eliminarTercero(int id) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				Terceros tercero = session.get(Terceros.class, id);
				session.delete(tercero);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al eliminar el tercero");
			} finally {
				session.close();
			}
		}
	}

}
