package clases;

public class Facturas {
	private int idFactura;
	private String fecha;
	private int idCliente;

	public Facturas(int idFactura, String fecha, int idCliente) {
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.idCliente = idCliente;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public String getFecha() {
		return fecha;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String toString() {
		return "ID: " + idFactura + " Fecha: " + fecha + " ID Cliente: " + idCliente;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void mostrarDatos() {
		System.out.println("ID: " + idFactura + " Fecha: " + fecha + " ID Cliente: " + idCliente);
	}

	public void mostrarDatos(String mensaje) {
		System.out.println(mensaje + " ID: " + idFactura + " Fecha: " + fecha + " ID Cliente: " + idCliente);
	}

	public void mostrarDatos(int id) {
		if (id == idFactura) {
			System.out.println("ID: " + idFactura + " Fecha: " + fecha + " ID Cliente: " + idCliente);
		}
	}

	public void mostrarDatos(String mensaje, int id) {
		if (id == idFactura) {
			System.out.println(mensaje + " ID: " + idFactura + " Fecha: " + fecha + " ID Cliente: " + idCliente);
		}
	}

	public void mostrarDatos(int id, String mensaje){
        if(id == idFactura){
            System.out.println(mensaje + " ID: " + idFactura + " Fecha: " + fecha + " ID Cliente: " + idCliente);
        }
    }

	public void mostrarDatos(String mensaje, int id, String mensaje2){
        if(id == idFactura){
            System.out.println(mensaje + " ID: " + idFactura + " Fecha: " + fecha + " ID Cliente: " + idCliente + " " + mensaje2);
        }
	}

}
