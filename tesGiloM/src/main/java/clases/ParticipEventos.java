package clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ParticipEventos {
	
    @ManyToOne
    @JoinColumn(name = "idSocio")
    private Socios socio;

    // Otros campos y métodos de la clase

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }
    
    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Eventos evento;

    // Otros campos y métodos de la clase

    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	String nombre;
	int idEvento;
	int idSocio;
	int numParticipantes;
	boolean pagado;
	
	public ParticipEventos() {

	}
	
	public ParticipEventos(String nombre, Eventos evento, Socios socio, int numParticipantes, boolean pagado) {
		this.nombre = nombre;
		this.evento = evento;
		this.socio = socio;
		this.numParticipantes = numParticipantes;
		this.pagado = pagado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumParticipantes() {
		return numParticipantes;
	}

	public void setNumParticipantes(int numParticipantes) {
		this.numParticipantes = numParticipantes;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	

}
