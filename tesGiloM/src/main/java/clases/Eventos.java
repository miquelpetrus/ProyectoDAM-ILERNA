package clases;

public class Eventos {
	private int id;
	private String nombre;
	private String fecha;
    private String descripcion;
    private String lugar;
    private String precio;
    
    
	public Eventos() {
	}
	
	public Eventos(int id, String nombre, String fecha, String descripcion, String lugar, String precio) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	

}
