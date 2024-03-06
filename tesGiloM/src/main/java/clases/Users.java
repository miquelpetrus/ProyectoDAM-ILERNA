package clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Users {
	
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String name;
	private String apellido1;
	private String apellido2;
	private String password;
	private String email;
	private String nif;
	private String role;
	private int idSocio;
	
	public Users(String name, String apellido1, String apellido2, String password, String email, String nif, String role, String status) {
        this.name = name;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.password = password;
        this.email = email;
        this.nif = nif;
        this.role = role;
    }
	
	public Users(String name, String apellido1, String apellido2, String password, String email, String nif, String role, String status, int idSocio) {
        this.name = name;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.password = password;
        this.email = email;
        this.nif = nif;
        this.role = role;
        this.idSocio = idSocio;
    }
	
	public Users() {
        this.name = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.password = "";
        this.email = "";
        this.nif = "";
    }
	
    public int getId() {
        return id;
    }
    
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	
	
}