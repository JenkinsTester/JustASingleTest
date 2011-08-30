package test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
 * Tests mit Parametern: mehrere Durchlaeufe mit unterschiedlichen 
 * Werten koennen durchgefuehrt werden um die Methode effizienter zu testen
 * 
 * Nachteil: man kann immer nur eine Methode effizient testen, da die Werte
 * logischerweise an die Methode angepasst werden muessen.
 */

@RunWith(Parameterized.class)
public class ParametricCalculatorTest { 

	int value1, value2, result;

	private static Calculator calculator = 
		new Calculator();

	public ParametricCalculatorTest(int value1, int value2, int result) {
		super();
		this.value1 = value1;
		this.value2 = value2;
		this.result = result;
	}

	@Parameters
	public static Collection values() {
		return Arrays.asList(new Object[][] {
				{1, 1, 2 }, // 1+1=2
				{2, 2, 4 }, // 2+2=4
				{2, 2, 5 },  // 2+2=5 ???
				{5, 5, 10 } // 5+5=10

		});
	}

	@Before
	public void clearCalculator() {
		calculator.clear();
	}

	@Test
	public void verifySum() throws Exception{
		calculator.add(value1);
		calculator.add(value2);
		assertEquals(calculator.getResult(), result); 
	}
}