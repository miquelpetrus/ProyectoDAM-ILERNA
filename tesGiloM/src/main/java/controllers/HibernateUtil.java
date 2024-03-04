package controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import clases.Bancos;
import clases.Eventos;
import clases.Facturas;
import clases.FamiliaProducto;
import clases.Gastos;
import clases.Ingresos;
import clases.LineasFacturas;
import clases.Productos;
import clases.Proveedores;
import clases.Roles;
import clases.Socios;
import clases.Users;

public class HibernateUtil {
	
    public static SessionFactory buildSessionFactory() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("hibernate-config.properties")) {
            prop.load(fis);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String ip = prop.getProperty("ip");
        String database = prop.getProperty("database");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        // Configuración de Hibernate con la información cargada desde el archivo de propiedades
        Configuration cfg = new Configuration()
                .setProperty("hibernate.connection.url", "jdbc:mysql://" + ip + "/" + database)
                .setProperty("hibernate.connection.username", user)
                .setProperty("hibernate.connection.password", password)
                .configure();

        return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());

    }
    
    private static void createDefaultAdminUser(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            // Verificar si el usuario admin ya existe
            Users adminUser = session.createQuery("FROM Users WHERE email = :email", Users.class)
                    .setParameter("email", "admin@aavvmolidespla.org")
                    .uniqueResult();

            if (adminUser == null) {
                // Crear el usuario admin si no existe
                adminUser = new Users("Admin", "", "", "admin", "admin@example.com", "", "admin", "");
                session.save(adminUser);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
