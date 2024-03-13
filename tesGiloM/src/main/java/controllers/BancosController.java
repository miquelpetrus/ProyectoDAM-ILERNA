package controllers;

import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import clases.Bancos;

public class BancosController {

	public static List<Bancos> getAllBancos() {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			String hql = "FROM Bancos";
			Query<Bancos> query = session.createQuery(hql, Bancos.class);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static Bancos getBancosById(int id) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			return session.get(Bancos.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null; // or throw an exception based on your error handling strategy
		}
	}

	public static void crearBanco(String nombre, String entidad, String iban, String contacto) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				Bancos nuevoBanco = new Bancos();
				nuevoBanco.setNombre(nombre);
				nuevoBanco.setEntidad(entidad);
				nuevoBanco.setIban(iban);
				nuevoBanco.setContacto(contacto);

				session.save(nuevoBanco);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al crear el banco");

			} finally {
				session.close();
			}
		}
	}

}
