package clases;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Gastos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idGasto;
	private String fecha;
	private String concepto;
	private double importe;
	private String tipoGasto;
	private String observaciones;
	private int idProveedor;
	private int idEvento;
	private int idFactura;
	private int pagado;
	private int idBanco;

	public Gastos() {
	}
	
	public Gastos(int idGasto, String fecha, String concepto, double importe, String tipoGasto, String observaciones,
			int idProveedor, int idEvento, int idFactura, int pagado, int idBanco) {
		this.idGasto = idGasto;
		this.fecha = fecha;
		this.concepto = concepto;
		this.importe = importe;
		this.tipoGasto = tipoGasto;
		this.observaciones = observaciones;
		this.idProveedor = idProveedor;
		this.idEvento = idEvento;
		this.idFactura = idFactura;
		this.pagado = pagado;
		this.idBanco = idBanco;
	}

	public int getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getPagado() {
		return pagado;
	}

	public void setPagado(int pagado) {
		this.pagado = pagado;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
	
	
}
