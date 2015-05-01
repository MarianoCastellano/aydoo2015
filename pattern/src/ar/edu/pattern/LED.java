package ar.edu.pattern;

public class LED extends TV {

	private double tiempoRespuesta;

	public LED() {
		setDescripcion("LED");
	}

	public LED(String marca, int pulgada, String color, String descripcion, double precio, double tiempoRespuesta) {
		super(marca, pulgada, color, descripcion, precio);
		this.tiempoRespuesta = tiempoRespuesta;
	}

	public double getTiempoRespuesta() {
		return tiempoRespuesta;
	}

	public void setTiempoRespuesta(double tiempoRespuesta) {
		this.tiempoRespuesta = tiempoRespuesta;
	}

}