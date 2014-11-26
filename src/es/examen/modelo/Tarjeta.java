package es.examen.modelo;

public class Tarjeta {
	private int id;
	private int numero;
	private int cupoMaximo;
	private int cupoDisponible;
	private String tipo;
	private int numeroComprobacion;
	public Tarjeta() {
		super();
	}
	public Tarjeta(int numero, int cupoMaximo, int cupoDisponible, String tipo,
			int numeroComprobacion) {
		super();
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
	}
	public Tarjeta(int id, int numero, int cupoMaximo, int cupoDisponible,
			String tipo, int numeroComprobacion) {
		super();
		this.id = id;
		this.numero = numero;
		this.cupoMaximo = cupoMaximo;
		this.cupoDisponible = cupoDisponible;
		this.tipo = tipo;
		this.numeroComprobacion = numeroComprobacion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCupoMaximo() {
		return cupoMaximo;
	}
	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}
	public int getCupoDisponible() {
		return cupoDisponible;
	}
	public void setCupoDisponible(int cupoDisponible) {
		this.cupoDisponible = cupoDisponible;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNumeroComprobacion() {
		return numeroComprobacion;
	}
	public void setNumeroComprobacion(int numeroComprobacion) {
		this.numeroComprobacion = numeroComprobacion;
	}
	
}
