package controllers;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.Eventos;
import clases.ParticipEventos;
import clases.Socios;

public class ParticipEventosController {

	private SessionFactory sessionFactory;

	public ParticipEventosController() {
		this.sessionFactory = HibernateUtil.buildSessionFactory();
	}

	public static void addParticipantes(String nombre, Socios socio, Eventos evento, int nParticip, boolean pagado) {
		// TODO Auto-generated method stub
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				ParticipEventos nuevoParticip = new ParticipEventos();
				nuevoParticip.setNombre(nombre);
				nuevoParticip.setSocio(socio);
				nuevoParticip.setEvento(evento);
				nuevoParticip.setNumParticipantes(nParticip);
				nuevoParticip.setPagado(pagado);
				;
				session.save(nuevoParticip);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
					JOptionPane.showMessageDialog(null, "Error al añadir participante");
				}
			} finally {
				session.close();
			}
		}
	}
}
