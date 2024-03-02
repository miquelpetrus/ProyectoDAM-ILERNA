package controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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

}
