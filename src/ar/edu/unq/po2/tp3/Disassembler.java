package ar.edu.unq.po2.tp3;

import java.util.ArrayList;

public class Disassembler {
	
	// Devuelve el numero con mas digitos pares del arreglo.
	public int numeroConMasDigitosPares(ArrayList<Integer> array) {
		int numeroConMasDigitosPares = array.getFirst();
		for (int n : array) {
			if (cantidadDigitosPares(n) > cantidadDigitosPares(numeroConMasDigitosPares)) {
				numeroConMasDigitosPares = n;
			}
		}
		return numeroConMasDigitosPares;
	}
	
	// Devuelve la cantidad de digitos pares de n.
	private int cantidadDigitosPares(int n) {
		int cantidadDigitosPares = 0;
		while (n > 0) {
			if (isEven(n)) {
				cantidadDigitosPares += 1;
			}
			n /= 10;
		}
		return cantidadDigitosPares;
	}
	
	private boolean isEven(int n) {
	    return (n % 2) == 0;
	}
}
