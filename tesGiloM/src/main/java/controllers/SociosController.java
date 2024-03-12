package controllers;


import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.Socios;
import clases.Users;

public class SociosController {
	
    public static List<Socios> getAllSocios() {
        List<Socios> socios = null;
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            // Utiliza HQL para obtener todos los usuarios de la base de datos
            String hql = "FROM Socios";
            Query<Socios> query = session.createQuery(hql, Socios.class);
            socios = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            // Maneja cualquier excepción que pueda ocurrir al obtener todos los usuarios
        }
        return socios;
	}
    
    public static void crearSocio(String nombre, String apellido1, String apellido2, String nif, String email, String direcion, boolean estado) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
					Socios socio = new Socios();
					socio.setNombre(nombre);
					socio.setApellido1(apellido1);
					socio.setApellido2(apellido2);
					socio.setNif(nif);
					socio.setEmail(email);
					socio.setDireccion(direcion);
					socio.setEstado(estado);				
					session.save(socio);
					session.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al crear el usuario", "Error", JOptionPane.ERROR_MESSAGE);
    	        }
    }
    
	public static void actualizarSocio(int id, String nombre, String apellido1, String apellido2, String nif, String email, String telefono, boolean estado) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
	            Socios socio = session.get(Socios.class, id);
	            socio.setNombre(nombre);
	            socio.setApellido1(apellido1);
	            socio.setApellido2(apellido2);
	            socio.setNif(nif);
	            socio.setEmail(email);
	            socio.setTelefono(telefono);
	            socio.setEstado(estado);
	            session.update(socio);
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	}
	
	public static void eliminarSocio(int id) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Socios socio = session.get(Socios.class, id);
			session.delete(socio);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el socio", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
