package clases;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Eventos {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private Date fecha;
        private String descripcion;
        private String lugar;
        private String precio;
    
    
	public Eventos() {
	}
	
	public Eventos(int id, String nombre, Date fecha, String descripcion, String lugar) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.lugar = lugar;
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

	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
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
