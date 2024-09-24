package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Disassembler {
	
	public int getNumberWithMoreEvenDigits(ArrayList<Integer> array) {
		int numberWithMoreEvens = array.get(0);
		for (int n : array) {
			numberWithMoreEvens = moreEvensBetween(numberWithMoreEvens, n);
		}
		return numberWithMoreEvens;
	}
	
	private int moreEvensBetween(int x, int y) {
		if (evenDigitsIn(x) > evenDigitsIn(y)) {
			return x;
		} else {
			return y;
		}
	}
	
	private int evenDigitsIn(int n) {
		int evenDigits = 0;
		while (n > 0) {
			evenDigits =+ OneIfIsEven(n);
			n /= 10;
		}
		return evenDigits;
	}
	
	private int OneIfIsEven(int n) {
		if (isEven(n)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	private boolean isEven(int n) {
		return (n % 2) == 0;
	}
}
