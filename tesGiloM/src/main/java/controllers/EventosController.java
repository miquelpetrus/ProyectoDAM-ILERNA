package controllers;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import clases.Eventos;
import clases.Productos;

public class EventosController {
	
    private SessionFactory sessionFactory;
    
	public EventosController() {
		this.sessionFactory = HibernateUtil.buildSessionFactory();
	}
	
	public static void crearEvento(String nombre, Date fecha, String lugar, String descripcion) {
		// TODO Auto-generated method stub
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Aquí debes realizar la lógica para crear un nuevo producto
                // Puedes utilizar la entidad de productos y persistirla en la base de datos

                // Ejemplo (debes adaptarlo a tu modelo de datos):
                Eventos nuevoEvento = new Eventos();
                nuevoEvento.setNombre(nombre);
                nuevoEvento.setFecha(fecha);
                nuevoEvento.setLugar(lugar);
                nuevoEvento.setDescripcion(descripcion);


                session.save(nuevoEvento);

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
