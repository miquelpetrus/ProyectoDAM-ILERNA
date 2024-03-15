package controllers;

import java.awt.Window;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import clases.Users;

public class HibernateUtil {

    public static SessionFactory buildSessionFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("hibernate-config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Eliminar comillas alrededor de :3306 si están presentes
        String url = properties.getProperty("hibernate.connection.url").replaceAll("^\"|\"$", "");

        properties.setProperty("hibernate.connection.url", url);

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);

        // Cargar mapeos de clases
        configuration.addResource("Users.hbm.xml");
        configuration.addResource("Socios.hbm.xml");
        configuration.addResource("Facturas.hbm.xml");
        configuration.addResource("Productos.hbm.xml");
        configuration.addResource("Terceros.hbm.xml");
        configuration.addResource("LineasFacturas.hbm.xml");
        configuration.addResource("Bancos.hbm.xml");
        configuration.addResource("MovimientosBancarios.hbm.xml");
        configuration.addResource("ParticipEventos.hbm.xml");
        configuration.addResource("Eventos.hbm.xml");
        configuration.addResource("FamiliaProducto.hbm.xml");
        // Agrega aquí todos los demás mapeos de clases que necesites

        StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());
        return sessionFactory;
    }


	public static void abrirVentana(JPanel vistaAnterior, String tituloVistaAnterior) {

		try {
			JFrame frame = new JFrame(tituloVistaAnterior);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().add(vistaAnterior);
			frame.pack();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cerrarVentana(java.awt.Component componente) {
		Window ventana = SwingUtilities.getWindowAncestor(componente);
		if (ventana != null) {
			ventana.dispose();
		}
	}

}
