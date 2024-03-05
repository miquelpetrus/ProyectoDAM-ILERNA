package controllers;

import clases.Proveedores;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class ProveedoresController {
    
    public static List<Proveedores> getAllProveedores() {
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            String hql = "FROM Proveedores";
            Query<Proveedores> query = session.createQuery(hql, Proveedores.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    
    public static Proveedores getProveedorById(int id) {
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            return session.get(Proveedores.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // or throw an exception based on your error handling strategy
        }
    }

	
}
