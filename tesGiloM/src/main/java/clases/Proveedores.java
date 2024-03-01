package clases;

public class Proveedores {
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	private String contacto;

	public Proveedores() {
	}

	public Proveedores(int id, String nombre, String direccion, String telefono, String correo, String contacto) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.contacto = contacto;
	}

	public Proveedores(String nombre, String direccion, String telefono, String correo, String contacto) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.contacto = contacto;
	}

	public Proveedores(int id, String nombre, String direccion, String telefono, String contacto) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.contacto = contacto;
	}

	public Proveedores(String nombre, String direccion, String telefono, String contacto) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.contacto = contacto;
	}

	public Proveedores(String nombre, String direccion, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Proveedores(int id, String nombre, String direccion, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Proveedores(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Proveedores(int id, String nombre, String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Proveedores(String nombre) {
		this.nombre = nombre;
	}

	public Proveedores(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Proveedores(int id) {
		this.id = id;
	}


}
