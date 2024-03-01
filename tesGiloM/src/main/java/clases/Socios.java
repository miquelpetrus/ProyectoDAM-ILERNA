package clases;

public class Socios {
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String email;
	private String direccion;
	private String fechaNacimiento;
	private String fechaIngreso;
	private String fechaBaja;
	private String estado;

	public Socios(String nombre, String apellido, String dni, String telefono, String email, String direccion,
			String fechaNacimiento, String fechaIngreso, String fechaBaja, String estado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
	}

	public Socios() {
		this.nombre = "";
		this.apellido = "";
		this.dni = "";
		this.telefono = "";
		this.email = "";
		this.direccion = "";
		this.fechaNacimiento = "";
		this.fechaIngreso = "";
		this.fechaBaja = "";
		this.estado = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre;
		}
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		if (apellido != null) {
			this.apellido = apellido;
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni != null) {
			this.dni = dni;
		}
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono != null) {
			this.telefono = telefono;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null) {
			this.email = email;
		}
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion != null) {
			this.direccion = direccion;
		}
	}

	public String getFechaNacimiento() {
        return fechaNacimiento;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


}
