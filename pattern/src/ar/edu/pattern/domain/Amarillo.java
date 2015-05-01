package ar.edu.pattern.domain;

public class Amarillo extends Color {

	private boolean esPrimario;

	@Override
	public TV colorear(TV tv) {
		tv.setColor("Amarillo");
		return tv;
	};

	public boolean isEsPrimario() {
		return esPrimario;
	}

	public void setEsPrimario(boolean esPrimario) {
		this.esPrimario = esPrimario;
	}
}