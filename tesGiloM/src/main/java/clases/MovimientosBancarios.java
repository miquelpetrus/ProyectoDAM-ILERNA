package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovimientosBancarios {

	@ManyToOne(fetch = FetchType.LAZY)
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
    private int idSocio;
    private int idTercero;
    private double importe;
    private String tipo;
    private int idBanco;
    private int idUser;

    public MovimientosBancarios() {
        super();
    }

	public MovimientosBancarios(int id, Date fecha, String concepto, double importe, String tipo, int idBanco,
			int idUser) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.concepto = concepto;
		this.importe = importe;
		this.tipo = tipo;
		this.idBanco = idBanco;
		this.idUser = idUser;
	}

	public MovimientosBancarios(int id, Date fecha, Eventos evento, int idSocio, int idBanco, double importe) {
		this.id = id;
		this.fecha = fecha;
	    this.evento = evento;
		this.idSocio = idSocio;
		this.idBanco = idBanco;
		this.importe = importe;
	}

	public MovimientosBancarios(int id, Date fecha, Eventos evento, int idTercero, int idSocio, int idBanco,
			double importe, String tipo) {
		this.id = id;
		this.fecha = fecha;
	    this.evento = evento;
		this.idTercero = idTercero;
		this.idSocio = idSocio;
		this.idBanco = idBanco;
		this.importe = importe;
		this.tipo = tipo;
	}


	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public int getIdTercero() {
		return idTercero;
	}

	public void setIdTercero(int idTercero) {
		this.idTercero = idTercero;
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
	
    public String getFechaEnFormato() {
        // Define el formato deseado para la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        // Formatea la fecha y devuelve la representación en formato de cadena
        return sdf.format(this.fecha);
    }

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String importe) {
		this.concepto = importe;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
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
