package ar.edu.pattern.domain;

public abstract class TV {

	private String marca;
	private int pulgada;
	private String color;
	private String descripcion;
	private double precio;
	
	public TV() {
	}

	public TV(String marca, int pulgada, String color, String descripcion, double precio) {
		this.marca = marca;
		this.pulgada = pulgada;
		this.color = color;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPulgada() {
		return pulgada;
	}

	public void setPulgada(int pulgada) {
		this.pulgada = pulgada;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}