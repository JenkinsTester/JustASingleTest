package test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/*
 * Informationen zu dieser Testdatei unter:
 * http://wiki.fernuni-hagen.de/eclipse/index.php/Einf%C3%BChrung_in_JUnit
 */
public class CalculatorTest {

	private static Calculator calculator;

	/*
	 * Diese BeforeClass Methode instanziert das eigentliche zu testende Modul,
	 * die Klasse Calculator, und schaltet ihn ein.
	 */
	@BeforeClass
	public static void switchOnCalculator() {
		System.out.println("\tSwitch on calculator");
		calculator = new Calculator();
		calculator.switchOn();
	}

	/*
	 * Hier wird das Gegenteil getan, der Taschenrechner wird abgeschaltet, und
	 * das instanzierte Modul wird freigegeben.
	 */
	@AfterClass
	public static void switchOffCalculator() {
		System.out.println("\tSwitch off calculator");
		calculator.switchOff();
		calculator = null;
	}

	/*
	 * Diese Methode wird vor jedem der weiteren Tests aufgerufen. Sie stellt
	 * sicher, dass das Ergebnis geloescht wird, bevor der naechste Test
	 * aufgerufen wird.
	 */
	@Before
	public void clearCalculator() {
		calculator.clear();
	}

	/*
	 * Hier handelt es sich um einen ganz normalen Test, der auch erfolgreich
	 * abgeschlossen werden kann.
	 */
	@Test
	public void add() {
		calculator.add(1);
		calculator.add(1);
		assertEquals(calculator.getResult(), 2);
	}

	/*
	 * Dieser Test wird fehlschlagen, da das zu testende Modul hier einen Fehler
	 * enthaelt.
	 */
	@Test
	public void subtract() {
		calculator.add(10);
		calculator.subtract(2);
		assertEquals(calculator.getResult(), 8);
	}

	/*
	 * Der Test kann erfolgreich abgeschlossen werden.
	 */
	@Test
	public void divide() {
		calculator.add(8);
		calculator.divide(2);
		assertEquals(calculator.getResult(), 4);
	}

	/*
	 * Dieser Test erwartet eine Exception bei der Ausfuehrung. Deswegen wird der
	 * Annotation @Test als Parameter uebergeben.
	 */
	@Test(expected = ArithmeticException.class)
	public void divideByZero() {
		calculator.divide(0);
	}

	/*
	 * Dieser Test wird nach 100ms abgebrochen. Dies ist ein Beispiel fuer einen
	 * Timeout-Parameter der Annotation @Test
	 */
	@Test(timeout = 100)
	public void squareRoot() {
		calculator.squareRoot(100);
		assertEquals(calculator.getResult(), 10);
	}

	/*
	 * Da die entsprechende Methode im Code noch nicht implementiert ist, wird
	 * der Test ausgeschlossen.
	 */
	@Ignore("not ready yet")
	@Test
	public void multiply() {
		calculator.add(10);
		calculator.multiply(10);
		assertEquals(calculator.getResult(), 100);
	}
	
	/* testen bewusst auf Exception. Das Ergebnis bestaetigt uns
	 * das eine Exception geworfen wurde. Test bestanden! :)
	 */
	
	@Test(expected=IndexOutOfBoundsException.class)
	 public void testIndexOutOfBoundsException() {
	     ArrayList emptyList = new ArrayList();
	     Object o = emptyList.get(0);
	 }

}
