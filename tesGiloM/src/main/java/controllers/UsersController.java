package controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import clases.Users;


public class UsersController {
	
    private SessionFactory sessionFactory;
    private static String nombreUsuario; // Variable de sesión para el nombre del usuario
    
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
	            UsuarioSesion.setNombreUsuario(user.getName()); // almacena el nombre del usuario en la variable de sesión
	            break; 
			} else {
				mensaje = "Usuario incorrecto";
			}
	    }

	    return mensaje;
	}


}