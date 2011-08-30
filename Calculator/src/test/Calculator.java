package test;
import java.util.ArrayList;

//Class Calculator:
public class Calculator {

	private static int result;

	public void add(int n) {
		result = result + n;
	}

	public void subtract(int n) {
		result = result - 1; // Bug : result = result - n
	}

	public void multiply(int n) {
	} // Not implemented yet

	public void divide(int n) {
		result = result / n;
	}

	public void square(int n) {
		result = n * n;
	}

	public void squareRoot(int n) {
		for (;;)
			; // Bug : Endlosschleife
	}

	public void clear() { // Ergebnis loeschen
		result = 0;
	}

	public void switchOn() { // Bildschirm einschalten, Piepsen, oder was
		result = 0; // Taschenrechner halt so tun
	}

	public void switchOff() {
	} // Ausschalten

	public int getResult() {
		return result;
	}

	/*
	 * nur zur Demo wird gezeigt, dass auch auf eine Exception getestet werden
	 * kann. Wir lassen hier bewusst eine Exception werfen, dies erwartet auch
	 * unser Testprogramm
	 */

	public void testIndexOutOfBoundsException() {
	     ArrayList emptyList = new ArrayList();
	     Object o = emptyList.get(0);
	 }
}