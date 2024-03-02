package clases;

public class Facturas {
	private int idFactura;
	private String fecha;
	private int idCliente;
	private int idProveedor;
	private String serie;
	private int numeroFac;
	private double baseImponible;
	private double iva;
	private double total;
	private double pagado;
	private int idSocio;
	private int idEvento;
	private String formaDePago;
	
	public Facturas() {
	}
	
	public Facturas(int idFactura, String fecha, int idCliente, int idProveedor, String serie, int numeroFac,
			double baseImponible, double iva, double total, double pagado, int idSocio, int idEvento,
			String formaDePago) {
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idProveedor = idProveedor;
		this.serie = serie;
		this.numeroFac = numeroFac;
		this.baseImponible = baseImponible;
		this.iva = iva;
		this.total = total;
		this.pagado = pagado;
		this.idSocio = idSocio;
		this.idEvento = idEvento;
		this.formaDePago = formaDePago;
	}
	
	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getNumeroFac() {
		return numeroFac;
	}

	public void setNumeroFac(int numeroFac) {
		this.numeroFac = numeroFac;
	}

	public double getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(double baseImponible) {
		this.baseImponible = baseImponible;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getPagado() {
		return pagado;
	}

	public void setPagado(double pagado) {
		this.pagado = pagado;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
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
