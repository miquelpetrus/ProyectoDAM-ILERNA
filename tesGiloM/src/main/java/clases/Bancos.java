package clases;

public class Bancos {
	private String nombre;
    private int id;
    private int saldo;
    
	public Bancos(String nombre, int id, int saldo) {
		this.nombre = nombre;
		this.id = id;
		this.saldo = saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	

}
