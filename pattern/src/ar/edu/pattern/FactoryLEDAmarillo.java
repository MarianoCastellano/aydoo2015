package ar.edu.pattern;

public class FactoryLEDAmarillo extends TvAbstractFactory {

	@Override
	public TV crearTV() {
		return new LED();
	}

	@Override
	public Color crearColor() {
		return new Amarillo();
	}

}