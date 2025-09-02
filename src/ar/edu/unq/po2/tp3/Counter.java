package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Counter {

	private ArrayList<Integer> array = new ArrayList<Integer>();
	
	public void addNumber(int n) {
		array.add(n);
	}
	
	public int getEvenOcurrences() {
	    int counter = 0;
	    for (Integer i : array) {
	        if (isEven(i)) {
	            counter++;
	        }
	    }
	    return counter;
	}

	private boolean isEven(int n) {
	    return (n % 2) == 0;
	}
	
	public int getOddOcurrences() {
		int counter = 0;
	    for (Integer i : array) {
	        if (!isEven(i)) {
	            counter++;
	        }
	    }
	    return counter;
	}
	
	public int countMultipleOf(int n) {
		int counter = 0;
	    for (Integer i : array) {
	        if (isMultipleOf(i, n)) {
	            counter++;
	        }
	    }
	    return counter;
	}
	
	private boolean isMultipleOf(int e, int n) {
		return (e % n) == 0;
	}
}
