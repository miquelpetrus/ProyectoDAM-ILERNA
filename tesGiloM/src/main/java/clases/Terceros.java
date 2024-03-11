package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "terceros")
public class Terceros {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String contacto;
	@Column(unique = true)
	private String cif;
	private String poblacion;
	private String cp;
	private String provincia;
	@Column(unique = true)
	private String email;
	
	public Terceros() {
	}
	
	public Terceros(int id, String nombre, String direccion, String telefono, String contacto,
			String cif, String poblacion, String cp, String provincia, String email) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.contacto = contacto;
		this.cif = cif;
		this.poblacion = poblacion;
		this.cp = cp;
		this.provincia = provincia;
		this.email = email;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
    @Override
    public String toString() {
        return this.nombre; // or whatever property you want to display
    }

}
