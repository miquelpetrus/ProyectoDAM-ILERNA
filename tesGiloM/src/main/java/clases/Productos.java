package clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Productos {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String descripcion;
	private double precio;
	private int idFamilia;
	private int idProveedor;
	
	
	public Productos(int id, String nombre, String descripcion, double precio, int idFamilia, int idProveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.idFamilia = idFamilia;
		this.idProveedor = idProveedor;
	}
	
	public int getIdProveedor() {
		return idProveedor;
	}
	
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getIdFamilia() {
		return idFamilia;
	}
	
	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}

	public Productos() {
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
