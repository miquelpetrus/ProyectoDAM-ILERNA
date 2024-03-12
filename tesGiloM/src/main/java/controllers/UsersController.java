package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.Users;


public class UsersController {
	
    private SessionFactory sessionFactory;
    private static String nombreUsuario; 
    UsuarioSesion usuarioSesion = UsuarioSesion.getInstancia();
    
    public static List<Users> getAllUsers() {
        List<Users> usuarios = null;
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            // Utiliza HQL para obtener todos los usuarios de la base de datos
            String hql = "FROM Users";
            Query<Users> query = session.createQuery(hql, Users.class);
            usuarios = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            // Maneja cualquier excepción que pueda ocurrir al obtener todos los usuarios
        }
        return usuarios;
	}
    
	public static String getNombreUsuarioById(int id) {
        List<Users> usuarios = getAllUsers();
        String nombreUsuario = "";
        String apellido1Usuario = "";
        for (Users user : usuarios) {
            if (user.getId() == id) {
                nombreUsuario = user.getName();
                apellido1Usuario = user.getApellido1();
                break;
            }
        }
        return nombreUsuario + " " + apellido1Usuario;
	}
	
	public static boolean validarUsuario(String usuario, String password) {
	    List<Users> usuarios = getAllUsers();
	    
	    String passwordEncriptado = encriptarPassword(password);

	    for (Users user : usuarios) {
	    	if (!(user.getEmail().trim().equals(usuario))) {
	    		JOptionPane.showMessageDialog(null, "El usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
        		return false;
        	}
	    	if (user.getEmail().trim().equals(usuario) && !user.getPassword().trim().equals(passwordEncriptado)) {
	    	    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
	    	    return false;  // Contraseña incorrecta
	    	}
	        if (user.getEmail().trim().equals(usuario) && user.getPassword().trim().equals(passwordEncriptado)) {
	            UsuarioSesion.setIdUsuario(user.getId());
	            return true;  // Usuario y contraseña son válidos
	        }
	    }
	    return false;
	}
	
	public static void crearUsuario(String nombre, String apellido1, String apellido2, String nif, String email, String password) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Users user = new Users();
			user.setName(nombre);
			user.setApellido1(apellido1);
			user.setApellido2(apellido2);
			user.setNif(nif);
			user.setEmail(email);
			user.setPassword(encriptarPassword(password));
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al crear el usuario", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void actualizarUsuario(int id, String nombre, String apellido1, String apellido2, String nif, String email, String password) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Users user = session.get(Users.class, id);
            user.setName(nombre);
            user.setApellido1(apellido1);
            user.setApellido2(apellido2);
            user.setNif(nif);
            user.setEmail(email);
            user.setPassword(encriptarPassword(password));
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public static void eliminarUsuario(int id) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Users user = session.get(Users.class, id);
			session.delete(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
    // Método para crear el usuario admin por defecto
    public static void createDefaultAdminUser(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Verificar si el usuario admin ya existe
            Users adminUser = session.createQuery("FROM Users WHERE email = :email", Users.class)
                    .setParameter("email", "admin@aavv.com")
                    .uniqueResult();

            if (adminUser == null) {
                // Crear el usuario admin si no existe
                adminUser = new Users();
                adminUser.setName("admin");
                adminUser.setApellido1("admin");
                adminUser.setApellido2("admin");
                adminUser.setPassword(UsersController.encriptarPassword("admin"));
                adminUser.setEmail("admin@aavv.com");
                session.save(adminUser);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    // Método para convertir una cadena de texto a SHA-256 obtenido de https://trellat.es/codificar-texto-sha-256-java/
	public static String encriptarPassword(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} 
		catch (NoSuchAlgorithmException e) {		
			e.printStackTrace();
			return null;
		}
		    
		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		    
		for(byte b : hash) {        
			sb.append(String.format("%02x", b));
		}
		    
		return sb.toString();
	}


}