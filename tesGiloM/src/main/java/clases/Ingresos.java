package clases;

public class Ingresos {
	private String fecha;
	private String concepto;
	private double monto;

	public Ingresos(String fecha, String concepto, double monto) {
		this.fecha = fecha;
		this.concepto = concepto;
		this.monto = monto;
	}

	public String getFecha() {
		return fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public double getMonto() {
		return monto;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String toString() {
		return "Fecha: " + fecha + ", Concepto: " + concepto + ", Monto: " + monto;
	}

}
