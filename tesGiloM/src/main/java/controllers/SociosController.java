package controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import clases.Socios;

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

}
