package clases;

public class Bancos {
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	private String web;
	private String horario;
	private String logo;

	public Bancos() {
	}

	public Bancos(String nombre, String direccion, String telefono, String correo, String web, String horario,
			String logo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.web = web;
		this.horario = horario;
		this.logo = logo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public String getWeb() {
		return web;
	}

	public String getHorario() {
		return horario;
	}

	public String getLogo() {
		return logo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "Bancos{" + "nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", correo="
				+ correo + ", web=" + web + ", horario=" + horario + ", logo=" + logo + '}';
	}

}
