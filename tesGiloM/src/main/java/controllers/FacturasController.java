package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import clases.Facturas;
import clases.LineasFacturas;
import clases.Productos;
import clases.Terceros;

public class FacturasController {

	private SessionFactory sessionFactory;

	public static List<Facturas> getAllFacturas() {
		List<Facturas> usuarios = null;
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			// Utiliza HQL para obtener todos los usuarios de la base de datos
			String hql = "FROM Facturas";
			Query<Facturas> query = session.createQuery(hql, Facturas.class);
			usuarios = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public static List<LineasFacturas> getAllLineasFacturas() {
		List<LineasFacturas> usuarios = null;
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			// Utiliza HQL para obtener todos los usuarios de la base de datos
			String hql = "FROM LineasFacturas";
			Query<LineasFacturas> query = session.createQuery(hql, LineasFacturas.class);
			usuarios = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			// Maneja cualquier excepción que pueda ocurrir al obtener todos los usuarios
		}
		return usuarios;
	}

	public static List<LineasFacturas> getLineasFacturasByIdFactura(String idFactura) {
		Session session = null;
		List<LineasFacturas> lineasFacturas = new ArrayList<>();

		try {
			session = HibernateUtil.buildSessionFactory().openSession();
			String hql = "FROM LineasFacturas lf WHERE lf.idFactura = :idFactura";
			Query query = session.createQuery(hql);
			query.setParameter("idFactura", idFactura);
			lineasFacturas = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return lineasFacturas;
	}

	public static void insertarLineaFactura(String idFactura, int idProveedor, int IdProducto, int cantidad, int iva,
			double total) {
		try {
			// Inicializar la sesión de Hibernate
			Session session = HibernateUtil.buildSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Productos producto = ProductosController.getProductoById(IdProducto);
			Terceros tercero = TercerosController.getProveedorById(idProveedor);

			// Obtener el precio y el porcentaje de IVA del producto
			double precioProducto = producto.getPrecio();
			double porcentajeIVA = iva;

			// Calcular el importe sin IVA
			double importeSinIVA = cantidad * precioProducto;

			// Calcular el IVA
			double ivaTotal = importeSinIVA * (porcentajeIVA / 100.0);

			// Calcular el total (importe con IVA)
			double importeTotal = importeSinIVA + ivaTotal;

			// Crear una nueva instancia de LineasFacturas
			LineasFacturas lineaFactura = new LineasFacturas();
			lineaFactura.setIdFactura(idFactura);
			lineaFactura.setIdTercero(tercero.getId());
			lineaFactura.setIdProducto(producto.getId());
			lineaFactura.setCantidad(cantidad);
			lineaFactura.setPrecio(precioProducto);
			lineaFactura.setIva(porcentajeIVA);
			lineaFactura.setTotal(importeTotal);

			System.out.println("Linea de factura creada: " + lineaFactura);

			// Guardar la nueva línea de factura
			session.save(lineaFactura);

			// Realizar la transacción
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al insertar la línea de factura", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void guardarFactura(String idFactura, int idTercero, Date fecha, double baseImponible, double baseIVA,
			double total, int idUser, int idEvento) {
		// Obtén la sesión de Hibernate (asegúrate de tener la configuración adecuada)
		Session session = HibernateUtil.buildSessionFactory().openSession();

		// Inicia una transacción
		Transaction transaction = null;

		try {
			// Inicia la transacción
			transaction = session.beginTransaction();

			// Crea la entidad Facturas con los datos proporcionados
			Facturas factura = new Facturas();
			factura.setIdFactura(idFactura);
			factura.setIdTercero(idTercero);
			factura.setFecha(fecha);
			factura.setBaseImponible(baseImponible);
			factura.setIva(baseIVA);
			factura.setTotal(total);
			factura.setIdUser(idUser);
			factura.setIdEvento(idEvento);

			// Guarda la factura en la base de datos
			session.save(factura);

			// Confirma la transacción
			transaction.commit();
		} catch (Exception e) {
			// Si hay algún error, realiza un rollback de la transacción
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al guardar la factura", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			// Cierra la sesión de Hibernate
			session.close();
		}
	}

}
