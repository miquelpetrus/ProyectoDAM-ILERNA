package controllers;

import clases.Productos;
import clases.Proveedores;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    
    public static void crearProveedor(String nombre, String cif, String direccion, String telefono, String email) {
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Aquí debes realizar la lógica para crear un nuevo producto
                // Puedes utilizar la entidad de productos y persistirla en la base de datos

                // Ejemplo (debes adaptarlo a tu modelo de datos):
                Proveedores nuevoProveedor = new Proveedores();
                nuevoProveedor.setCif(cif);
                nuevoProveedor.setNombre(nombre);
                nuevoProveedor.setDireccion(direccion);
                nuevoProveedor.setTelefono(telefono);
                nuevoProveedor.setEmail(email);

                session.save(nuevoProveedor);

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
