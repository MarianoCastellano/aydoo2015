package ar.edu.pattern;

public class EnsamblajeTV {

	public TV ensamblar(TvAbstractFactory abstractFactory) {
		Color color = abstractFactory.crearColor();
		TV tv = abstractFactory.crearTV();
		return color.colorear(tv);
	}
}