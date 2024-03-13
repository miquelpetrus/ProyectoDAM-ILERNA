package clases;

public class Roles {
	private int id;
	private String nombre;
	private String descripcion;

	public Roles() {
	}

	public Roles(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Roles(int id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setId(int id) {
		this.id = id;
	}

}
