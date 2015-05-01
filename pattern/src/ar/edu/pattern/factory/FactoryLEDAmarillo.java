package ar.edu.pattern.factory;

import ar.edu.pattern.domain.Amarillo;
import ar.edu.pattern.domain.Color;
import ar.edu.pattern.domain.LED;
import ar.edu.pattern.domain.TV;

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