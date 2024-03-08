package controllers;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import clases.Bancos;


public class BancosController {
	
    public static List<Bancos> getAllBancos() {
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            String hql = "FROM Bancos";
            Query<Bancos> query = session.createQuery(hql, Bancos.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    
    public static String getNomBancoById(int idBanco) {
        String nomBanco = null;
        
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Transaction transaction = null;
            
            try {
                transaction = session.beginTransaction();
                
                // Utiliza HQL para obtener el nombre del banco
                String hql = "SELECT nombre FROM Banco WHERE id = :idBanco";
                Query<String> query = session.createQuery(hql, String.class);
                query.setParameter("idBanco", idBanco);
                nomBanco = query.uniqueResult();
                
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                // Maneja cualquier excepción que pueda ocurrir al obtener el nombre del banco
            }
        }
        
        return nomBanco;
    }
    
    public static void crearBanco(String nombre, String entidad, String iban, String contacto) {
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Aquí debes realizar la lógica para crear un nuevo producto
                // Puedes utilizar la entidad de productos y persistirla en la base de datos

                // Ejemplo (debes adaptarlo a tu modelo de datos):
                Bancos nuevoBanco = new Bancos();
                nuevoBanco.setNombre(nombre);
                nuevoBanco.setEntidad(entidad);
                nuevoBanco.setIban(iban);
                nuevoBanco.setContacto(contacto);

                session.save(nuevoBanco);

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
