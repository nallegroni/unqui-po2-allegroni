package ar.edu.unq.po2.tp3;


public class HigherMultiple {

	public int higherMultipleOf(int x, int y) {
		int higherMultiple = 1000;
		// Mientras higherMultiple sea mayor o igual a 0, sigue buscando el multiplo restando 1 cada vez.
		while (higherMultiple > 0) {
            if (isMultipleOfBoth(higherMultiple, x, y)) {
                return higherMultiple;
            }
            higherMultiple -= 1;
        }
		// Si no encuentra un multiplo, devuelve -1
        return -1;	}
	
	private boolean isMultipleOfBoth(int e, int x, int y) {
		return (isMultipleOf(e, x) && isMultipleOf(e, y));
	}
	
	private boolean isMultipleOf(int e, int n) {
		return (e % n) == 0;
	}
	
}
