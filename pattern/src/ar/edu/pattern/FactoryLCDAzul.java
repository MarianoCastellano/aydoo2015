package ar.edu.pattern;

public class FactoryLCDAzul extends TvAbstractFactory {

	@Override
	public TV crearTV() {
		return new LCD();
	}

	@Override
	public Color crearColor() {
		return new Azul();
	}

}