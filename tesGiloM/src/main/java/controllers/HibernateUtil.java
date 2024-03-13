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

		Configuration cfg = new Configuration().configure();

		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());

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
