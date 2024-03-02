package clases;

public class Ingresos {
	private int idIngreso;
	private String fecha;
	private String concepto;
	private double importe;
	private int idSocio;
	private int idEvento;
	
	public Ingresos() {
	}
	
	public Ingresos(int idIngreso, String fecha, String concepto, double importe, int idSocio, int idEvento) {
		this.idIngreso = idIngreso;
		this.fecha = fecha;
		this.concepto = concepto;
		this.importe = importe;
		this.idSocio = idSocio;
		this.idEvento = idEvento;
	}

	public String getFecha() {
		return fecha;
	}
	
	public int getIdIngreso() {
		return idIngreso;
	}
	
	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
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
	
	
}
