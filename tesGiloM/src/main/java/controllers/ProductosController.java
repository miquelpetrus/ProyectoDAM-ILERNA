package controllers;

import org.hibernate.Session;
import org.hibernate.Transaction;

import clases.Productos;

public class ProductosController {
	
    public static void crearProducto(String nombre, String descripcion, double precioCompra, int proveedor, int familiaProducto) {
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Aquí debes realizar la lógica para crear un nuevo producto
                // Puedes utilizar la entidad de productos y persistirla en la base de datos

                // Ejemplo (debes adaptarlo a tu modelo de datos):
                Productos nuevoProducto = new Productos();
                nuevoProducto.setNombre(nombre);
                nuevoProducto.setDescripcion(descripcion);
                nuevoProducto.setPrecio(precioCompra);
                nuevoProducto.setIdProveedor(proveedor);
                nuevoProducto.setIdFamilia(familiaProducto);

                session.save(nuevoProducto);

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
    
    public static void actualizarProducto(int id, String nombre, String descripcion, double precioCompra, int proveedor, int familiaProducto) {
        try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();

                // Ejemplo (debes adaptarlo a tu modelo de datos):
                Productos producto = session.get(Productos.class, id);
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setPrecio(precioCompra);
                producto.setIdProveedor(proveedor);
                producto.setIdFamilia(familiaProducto);

                session.update(producto);

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
                // Maneja cualquier excepción que pueda ocurrir al actualizar el producto
            } finally {
                session.close();
            }
        }
    }
    
	public static void eliminarProducto(int id) {
		try (Session session = HibernateUtil.buildSessionFactory().openSession()) {
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();

				// Ejemplo (debes adaptarlo a tu modelo de datos):
				Productos producto = session.get(Productos.class, id);
				session.delete(producto);

				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
				// Maneja cualquier excepción que pueda ocurrir al eliminar el producto
			} finally {
				session.close();
			}
		}
	}
}
