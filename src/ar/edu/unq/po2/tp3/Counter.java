package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Counter {
	
	private ArrayList<Integer> array = new ArrayList<Integer>();
	
	public void addNumber(int n) {
		array.add(n);
	}
	
	public int getEvenOcurrences() {
		return (int) (array.stream().filter(n -> this.isEven(n)).count());
	}
	
	private boolean isEven(int n) {
		return (n % 2) == 0;
	}
	
	public int getOddOcurrences() {
		return (int) (array.stream().filter(n -> !this.isEven(n)).count());
	}
	
	public int getMultipleOf(int n) {
		return (int) (array.stream().filter(e -> this.isMultipleOf(e, n)).count());
	}
	
	private boolean isMultipleOf(int e, int n) {
		return (e % n) == 0;
	}
	
}
