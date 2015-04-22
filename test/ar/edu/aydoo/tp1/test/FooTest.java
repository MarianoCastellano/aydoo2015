package ar.edu.aydoo.tp1.test;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.aydoo.tp1.Foo;

public class FooTest {

	@Test
	public void doFooShouldReturnFoo(){
        Foo foo = new Foo();
        String result = foo.doFoo();
        Assert.assertEquals("Foo.", result);
	}

}
