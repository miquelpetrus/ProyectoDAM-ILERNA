package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facturas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String idFactura;
	private Date fecha;
	private int idTercero;
	private double baseImponible;
	private double iva;
	private double total;
	private boolean pagado;
	private int idUser;
	private int idEvento;
	private String formaDePago;

	public Facturas() {
	}

	public Facturas(int id, String idFactura, Date fecha, int idTercero, double baseImponible, double iva, double total,
			boolean pagado, int idUser, int idEvento) {
		this.id = id;
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.idTercero = idTercero;
		this.baseImponible = baseImponible;
		this.iva = iva;
		this.total = total;
		this.pagado = false;
		this.idUser = idUser;
		this.idEvento = idEvento;
	}

	public int getIdTercero() {
		return idTercero;
	}

	public void setIdTercero(int idTercero) {
		this.idTercero = idTercero;
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

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

}
