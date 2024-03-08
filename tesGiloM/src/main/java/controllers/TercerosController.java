package controllers;

import clases.Productos;
import clases.Terceros;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
            return null; // or throw an exception based on your error handling strategy
        }
    }
    
    public static void crearTercero(String nombre, String cif, String direccion, String telefono, String email) {
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Aquí debes realizar la lógica para crear un nuevo producto
                // Puedes utilizar la entidad de productos y persistirla en la base de datos

                // Ejemplo (debes adaptarlo a tu modelo de datos):
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
                // Maneja cualquier excepción que pueda ocurrir al crear el producto
			} finally {
				session.close();
			}
        }
    }

	
}
