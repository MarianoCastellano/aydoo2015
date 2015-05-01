package ar.edu.pattern.domain;

public abstract class Color {

	private String descripcion;

	public abstract TV colorear(TV tv);

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}