package clases;

public class LineasFacturas {
	private int id;
	private int idFactura;
	private int idProducto;
	private int cantidad;
	private double precio;
	private double importe;

	public LineasFacturas(int id, int idFactura, int idProducto, int cantidad, double precio, double importe) {
		this.id = id;
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.importe = importe;
	}

	public LineasFacturas(int idFactura, int idProducto, int cantidad, double precio, double importe) {
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.importe = importe;
	}

	public LineasFacturas() {
	}

	public int getId() {
		return id;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public double getImporte() {
		return importe;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "LineasFacturas{" + "id=" + id + ", idFactura=" + idFactura + ", idProducto=" + idProducto
				+ ", cantidad=" + cantidad + ", precio=" + precio + ", importe=" + importe + '}';
	}

}
