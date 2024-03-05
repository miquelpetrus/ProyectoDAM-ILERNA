package controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	
	public static String validarUsuario(String usuario, String password) {
	    List<Users> usuarios = getAllUsers();
	    
	    String mensaje = "";

	    for (Users user : usuarios) {
	        if (user.getEmail().trim().equals(usuario) && user.getPassword().trim().equals(password)) {
	            mensaje = "Usuario correcto";
	            UsuarioSesion.setIdUsuario(user.getId());
	            break; 
			} else {
				mensaje = "Usuario incorrecto";
			}
	    }

	    return mensaje;
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


}