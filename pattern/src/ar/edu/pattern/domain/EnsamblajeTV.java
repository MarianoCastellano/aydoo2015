package ar.edu.pattern.domain;

import ar.edu.pattern.factory.TvAbstractFactory;

public class EnsamblajeTV {

	public TV ensamblar(TvAbstractFactory abstractFactory) {
		Color color = abstractFactory.crearColor();
		TV tv = abstractFactory.crearTV();
		return color.colorear(tv);
	}
}