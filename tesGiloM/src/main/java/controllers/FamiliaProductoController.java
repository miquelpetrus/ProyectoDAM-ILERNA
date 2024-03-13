package controllers;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import clases.FamiliaProducto;

public class FamiliaProductoController {

	private SessionFactory sessionFactory;

	public static List<FamiliaProducto> getAllFamiliaProducto() {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			String hql = "FROM FamiliaProducto";
			Query<FamiliaProducto> query = session.createQuery(hql, FamiliaProducto.class);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static FamiliaProducto getFamiliaProductoById(int id) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			return session.get(FamiliaProducto.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
	}

}
