package clases;

public class Roles {
	private int id;
	private String nombre;

	public Roles() {
	}

	public Roles(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Roles(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
