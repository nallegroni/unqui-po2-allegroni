package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Counter {
	
	private ArrayList<Integer> array = new ArrayList<Integer>();
	
	public int getEvenOcurrences() {
		int pares = 0;
		for (Integer n:array) {
			if (n%2 == 0) {
				pares += 1; 
			}
		}
		return pares;
	}
	
	public void addNumber(int n) {
		array.add(n);
	}
	
}
