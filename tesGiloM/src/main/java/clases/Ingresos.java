package clases;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Ingresos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idIngreso;
	private Date fecha;
	private String concepto;
	private double importe;
	private int idTercero;
	private int idSocio;
	private int idUser;
	private int idEvento;
	
	public Ingresos() {
	}
	
	public Ingresos(int idIngreso, Date fecha, String concepto, int idTercero, double importe, int idUser, int idEvento) {
		this.idIngreso = idIngreso;
		this.fecha = fecha;
		this.concepto = concepto;
		this.importe = importe;
		this.idTercero = idTercero;
		this.idEvento = idEvento;
		this.idUser = idUser;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public int getIdTercero() {
		return idTercero;
	}
	
	public void setIdTercero(int idTercero) {
		this.idTercero = idTercero;
	}
	
	public int getIdIngreso() {
		return idIngreso;
	}
	
	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
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
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
}
