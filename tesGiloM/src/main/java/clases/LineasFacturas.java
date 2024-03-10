package clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LineasFacturas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String idFactura;
	private int idTercero;
	private int idProducto;
	private int cantidad;
	private double precio;
	private double descuento;
	private double iva;
	private double total;

	public LineasFacturas(int id, String idFactura, int idTercero, int idProducto, int cantidad, double precio, double iva, double total) {
		this.id = id;
		this.idFactura = idFactura;
		this.idTercero = idTercero;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.iva = iva;
		this.total = total;
	}

	public LineasFacturas(String idFactura, int idProducto, int cantidad, double precio, double importe) {
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = importe;
	}

	public LineasFacturas() {
	}

	public int getId() {
		return id;
	}

	public String getIdFactura() {
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
		return total;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdFactura(String idFactura) {
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
		this.total = importe;
	}

	public double getIva() {
		return iva;
	}
	
	public void setIva(double iva) {
		this.iva = iva;
	}

	public int getIdTercero() {
		return idTercero;
	}
	
	public void setIdTercero(int idTercero) {
		this.idTercero = idTercero;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	
}
