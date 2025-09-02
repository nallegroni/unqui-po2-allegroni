package ar.edu.unq.po2.tp3;

public class HigherMultiple {

	public int HigherMultipleBetween(int x, int y) {
		int counter = 1000;
		while (!isMultipleOfBoth(counter, x, y) || counter == 0) {
			counter -= 1;
		}
		return counter;
	}

	private boolean isMultipleOfBoth(int n, int x, int y) {
		return isMultipleOf(n, x) && isMultipleOf(n, y);
	}
	
	private boolean isMultipleOf(int e, int n) {
		return (e % n) == 0;
	}
	
}
