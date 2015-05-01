package ar.edu.pattern.factory;

import ar.edu.pattern.domain.Azul;
import ar.edu.pattern.domain.Color;
import ar.edu.pattern.domain.LCD;
import ar.edu.pattern.domain.TV;

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