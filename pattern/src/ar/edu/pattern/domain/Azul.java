package ar.edu.pattern.domain;

public class Azul extends Color {

	private boolean esPrimario;

	@Override
	public TV colorear(TV tv) {
		tv.setColor("Azul");
		return tv;
	};

	public boolean isEsPrimario() {
		return esPrimario;
	}

	public void setEsPrimario(boolean esPrimario) {
		this.esPrimario = esPrimario;
	}
}