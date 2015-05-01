package ar.edu.pattern;

public class LCD extends TV {

	private double costoFabricacion;

	public LCD(String marca, int pulgada, String color, String descripcion, double precio, double costoFabricacion) {
		super(marca, pulgada, color, descripcion, precio);
		this.costoFabricacion = costoFabricacion;
	}

	public LCD() {
		setDescripcion("LCD");
	}

	public double getCostoFabricacion() {
		return costoFabricacion;
	}

	public void setCostoFabricacion(double costoFabricacion) {
		this.costoFabricacion = costoFabricacion;
	}

}