package ar.edu.pattern.factory;

import ar.edu.pattern.domain.Color;
import ar.edu.pattern.domain.TV;

public abstract class TvAbstractFactory {

	public abstract TV crearTV();

	public abstract Color crearColor();
}