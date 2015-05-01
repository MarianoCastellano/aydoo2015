package ar.edu.pattern;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.pattern.domain.EnsamblajeTV;
import ar.edu.pattern.domain.TV;
import ar.edu.pattern.factory.FactoryLCDAzul;
import ar.edu.pattern.factory.FactoryLEDAmarillo;
import ar.edu.pattern.factory.TvAbstractFactory;

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
