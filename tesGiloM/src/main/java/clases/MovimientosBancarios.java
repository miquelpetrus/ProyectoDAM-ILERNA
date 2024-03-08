package clases;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovimientosBancarios {
	
    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Eventos evento;
    
	public Eventos getEvento() {
		return evento;
	}
	
	public void setEvento(Eventos evento) {
		this.evento = evento;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date fecha;
	private String concepto;
	private double cantidad;
	private String tipo;
	private int idBanco;
	private int idUser;
	
	public MovimientosBancarios() {
		super();
	}
	
	public MovimientosBancarios(int id, Date fecha, String concepto, double cantidad, String tipo, int idBanco,
			int idUser) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.concepto = concepto;
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.idBanco = idBanco;
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	

}
