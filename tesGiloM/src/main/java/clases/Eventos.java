package clases;

public class Eventos {
	private int id;
	private String nombre;
	private String fecha;
	private String hora;
	private String lugar;
	private String descripcion;
	private String tipo;
	private String estado;

	public Eventos() {
	}

	public Eventos(int id, String nombre, String fecha, String hora, String lugar, String descripcion,
			String tipo, String estado) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.estado = estado;
	}

	public Eventos(String nombre, String fecha, String hora, String lugar, String descripcion, 
			String tipo, String estado) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.estado = estado;
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
