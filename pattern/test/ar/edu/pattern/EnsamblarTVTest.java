package ar.edu.pattern;

import org.junit.Assert;
import org.junit.Test;

public class EnsamblarTVTest {

	@Test
	public void ensamblarTVDeberiaCrearLCDAzulCuandoSeCreaConFactoryLCDAzul() {
		TvAbstractFactory factoryLCDAzul = new FactoryLCDAzul();
		EnsamblajeTV ensamblajeTV = new EnsamblajeTV();

		TV ensamblarTV = ensamblajeTV.ensamblar(factoryLCDAzul);

		Assert.assertEquals("Azul", ensamblarTV.getColor());
	}

	@Test
	public void ensamblarTVDeberiaCrearLEDAmarilloCuandoSeCreaConFactoryLEDAmarillo() {
		TvAbstractFactory factoryLEDAmarillo = new FactoryLEDAmarillo();
		EnsamblajeTV ensamblajeTV = new EnsamblajeTV();

		TV ensamblarTV = ensamblajeTV.ensamblar(factoryLEDAmarillo);

		Assert.assertEquals("Amarillo", ensamblarTV.getColor());
	}

}
