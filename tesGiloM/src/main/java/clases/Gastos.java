package clases;

public class Gastos {
	private int idGasto;
	private String fecha;
	private String concepto;
	private double importe;
	private String tipoGasto;

	public Gastos(int idGasto, String fecha, String concepto, double importe, String tipoGasto) {
		this.idGasto = idGasto;
		this.fecha = fecha;
		this.concepto = concepto;
		this.importe = importe;
		this.tipoGasto = tipoGasto;
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

}
